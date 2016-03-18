package com.diegolirio.purchaseorder.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.OrdersProducts;
import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.models.StatusType;
import com.diegolirio.purchaseorder.reports.services.ReportService;
import com.diegolirio.purchaseorder.repositories.PurchaseOrderRepositorie;

@Service
public class PurchaseOrderService {
	
	private static final String FROM_EMAIL = "pedido@cafglass.com.br";
	
	@Autowired
	private PurchaseOrderRepositorie purchaseOrderRepositorie;
	
	@Autowired
	private com.diegolirio.purchaseorder.services.mail.Mail mail;
	
	@Autowired @Qualifier("purchaseOrderReportService")
	private ReportService  reportService;	

	@Autowired
	private OrdersProductsService ordersProductsService;
	
	public Iterable<PurchaseOrder> getAll() {
		return this.purchaseOrderRepositorie.findAll();
	}
	
	public PurchaseOrder save(PurchaseOrder purchaseOrder) {
		if(purchaseOrder.getId() == null || purchaseOrder.getId() <= 0) purchaseOrder.setEmissionDate(Calendar.getInstance().getTime());
		return this.purchaseOrderRepositorie.save(purchaseOrder);
	}

	public PurchaseOrder get(Long id) {
		return this.purchaseOrderRepositorie.findOne(id);
	}

	public PurchaseOrder setStatus(PurchaseOrder purchaseOrder, StatusType status) {
		// pendente para concluido
		if(status == StatusType.completed) {
			if(purchaseOrder.getStatus() == StatusType.pending) {
				purchaseOrder.setStatus(StatusType.completed);
				this.purchaseOrderRepositorie.save(purchaseOrder);
				return purchaseOrder;
			} else {
				throw new RuntimeException("Impossivel concluir Pedido, Somente os pedido com Status pendente podem ser concluidos");
			}
		}
		else if(status == StatusType.canceled) {
			if(purchaseOrder.getStatus() == StatusType.completed) {
				purchaseOrder.setStatus(StatusType.canceled); 
				this.purchaseOrderRepositorie.save(purchaseOrder);
				return purchaseOrder;
			} else {
				throw new RuntimeException("Impossivel cancelar Pedido, Somente os pedido com Status concluidos podem ser alterados para cancelado");
			}
		} 
		throw new RuntimeException("Impossivel Alterar Status do Pedido  para " + status);
	}
	
	/**
	 * Efetiva -> Muda status, Envia email
	 * @param id
	 * @return
	 */
	public PurchaseOrder completed(long id) {
		PurchaseOrder po = this.purchaseOrderRepositorie.findOne(id);
		po = this.setStatus(po, StatusType.completed);
		po.setOrdersProducts(this.ordersProductsService.getListByPurchaseOrder(po));
		try {
			boolean sent = this.sendEmailAttachmentPO(po);
			if(sent == false) 
				throw new RuntimeException("Erro: Email não enviado para o Cliente");
		} catch (MessagingException | JRException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return po;
	}
	
	/**
	 * Send Mail for Customer
	 * @param 
	 * @return
	 */
	public boolean sendEmailLinkPO(PurchaseOrder po) {
		String from = FROM_EMAIL;
		String to = po.getCustomerAddressSender().getPeople().getEmail();
		String [] cc = {po.getCustomerAddressRecipient().getPeople().getEmail()};
		String linkPdf = "http://localhost:8080/pedido/purchaseorder/"+po.getId()+"/print/pdf";
		return this.mail.sendMailSimple("Pedido numero " + po.getId(), "Segue o link do pedido "+linkPdf+"\n\nNão responda este Email" , from, to, cc);
	}

	/**
	 * Envia email com anexo em PDF da PO
	 * @param po
	 * @return
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws JRException
	 */
	public boolean sendEmailAttachmentPO(PurchaseOrder po) throws AddressException, MessagingException, JRException {
		String to = po.getCustomerAddressRecipient().getPeople().getEmail();
		String[] cc = {po.getCustomerAddressRecipient().getPeople().getEmail()};
		String pathFileAnexo = this.reportService.generateReportPath(po);
		return this.mail.sendMailHtml("Pedido numero " + po.getId(), "<h3>Segue pedido em anexo</h3>Não responda este Email", FROM_EMAIL, to , cc , pathFileAnexo);
	}

	/**
	 * Send mail 
	 * @param id
	 * @return
	 * @throws AddressException
	 * @throws MessagingException
	 * @throws JRException
	 */
	public boolean sendEmailAttachmentPO(long id) throws AddressException, MessagingException, JRException {
		PurchaseOrder po = this.purchaseOrderRepositorie.findOne(id);
		po.setOrdersProducts(this.ordersProductsService.getListByPurchaseOrder(po));
		return this.sendEmailAttachmentPO(po);
	}
	
	
	/**
	 * Consulta avancada
	 * @param status
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public List<PurchaseOrder> searchAdvanced(StatusType status, String dateStart, String dateEnd) {
		//Calendar instance = Calendar.getInstance();
		//instance.add(Calendar.DATE, -30);
		 Date start = null;
		 Date end = null;
        try {
            //DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            start = (java.util.Date)formatter.parse(dateStart);
            end = (java.util.Date)formatter.parse(dateEnd);
        } catch (ParseException e) {            
            throw new RuntimeException(e);
        }
		return this.purchaseOrderRepositorie.findByStatusAndEmissionDateBetween(status, start, end);
	}

	/**
	 * Consulta avancada
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public List<PurchaseOrder> findByEmissionDateBetween(String dateStart, String dateEnd) {
		 Date start = null;
		 Date end = null;
        try {
        	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            start = (java.util.Date)formatter.parse(dateStart);
            end = (java.util.Date)formatter.parse(dateEnd);
        } catch (ParseException e) {            
            throw new RuntimeException(e);
        }
		return this.purchaseOrderRepositorie.findByEmissionDateBetween(start, end);
	}
	
	/**
	 * Delete por id, caso o pedido esteja com o status pendente 
	 * @param id
	 */
	public void delete(long id) {
		PurchaseOrder po = this.purchaseOrderRepositorie.findOne(id);
		this.delete(po);
	}

	/**
	 * Delete objeto, caso o pedido esteja com o status pendente 
	 * @param purchaseOrder
	 */
	public void delete(PurchaseOrder purchaseOrder) {
		if(purchaseOrder.getStatus() == StatusType.pending ) {
			this.ordersProductsService.deleteByPurchaseOrder(purchaseOrder);
			this.purchaseOrderRepositorie.delete(purchaseOrder);
		} else {
			throw new RuntimeException("Pedido encontra-se com Status "+purchaseOrder.getStatus() + " nao podera ser excluido!!!");
		}		
	}

	/**
	 * Cancelar PO
	 * @param id
	 * @param reason
	 * @return
	 */
	public PurchaseOrder cancel(long id, String reason) {
		PurchaseOrder po = this.purchaseOrderRepositorie.findOne(id);
		po = this.setStatus(po, StatusType.canceled);
		return po;
	}

	/**
	 * Gera Relatorio passando devolvendo em um array de byte
	 * @param id
	 * @return
	 * @throws JRException
	 */
	public byte[] generateReport(long id) throws JRException {
		PurchaseOrder purchaseOrder = this.purchaseOrderRepositorie.findOne(id);
		List<OrdersProducts> ordersProducts = this.ordersProductsService.getListByPurchaseOrder(purchaseOrder);
		purchaseOrder.setOrdersProducts(ordersProducts);
		byte[] bytes = this.reportService.generateReport(purchaseOrder);
		return bytes;
	}
	
}
