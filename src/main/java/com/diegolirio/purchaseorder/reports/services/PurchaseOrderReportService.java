package com.diegolirio.purchaseorder.reports.services;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegolirio.purchaseorder.models.Customer;
import com.diegolirio.purchaseorder.models.OrdersProducts;
import com.diegolirio.purchaseorder.models.PurchaseOrder;
import com.diegolirio.purchaseorder.reports.mirror.POReportMirror;
import com.diegolirio.purchaseorder.services.CustomerService;

@Component("purchaseOrderReportService")
public class PurchaseOrderReportService implements ReportService {

	@Autowired
	private CustomerService customerService; 
	
	@Override
	public byte[] generateReport(Object object) throws JRException {
		PurchaseOrder purchaseOrder = (PurchaseOrder) object;
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String pathToReportPackage = path + "com/diegolirio/purchaseorder/reports/";
		JasperReport report = JasperCompileManager.compileReport(pathToReportPackage + "po.jrxml");
		List<POReportMirror> list = this.toReportMirror(purchaseOrder.getOrdersProducts());
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(list));
		return JasperExportManager.exportReportToPdf(print);
	}

	private List<POReportMirror> toReportMirror(List<OrdersProducts> ordersProducts) {
		if (ordersProducts == null || ordersProducts.size() < 1)
			return null;
		List<POReportMirror> list = new ArrayList<POReportMirror>();
		Customer sender = this.customerService.get(ordersProducts.get(0).getOrder().getCustomerAddressSender().getPeople().getId());
		Customer recipient = this.customerService.get(ordersProducts.get(0).getOrder().getCustomerAddressRecipient().getPeople().getId());
		for (OrdersProducts op : ordersProducts) {
			POReportMirror mirror = new POReportMirror(op, sender, recipient);
			list.add(mirror);
		}
		return list;
	}

	
}

