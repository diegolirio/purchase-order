package com.diegolirio.purchaseorder.services.reports;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.stereotype.Service;

import com.diegolirio.purchaseorder.models.PurchaseOrder;

@Service("purchaseOrderReportService")
public class PurchaseOrderReportService implements ReportService {

	@Override
	public byte[] generateReport(Object object) throws JRException {
		PurchaseOrder purchaseOrder = (PurchaseOrder) object;
		String path = this.getClass().getClassLoader().getResource("").getPath();
		String pathToReportPackage = path + "com/diegolirio/purchaseorder/reports/";
		System.out.println(pathToReportPackage);
		JasperReport report = JasperCompileManager.compileReport(pathToReportPackage + "po.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(purchaseOrder.getOrdersProducts()));
		return JasperExportManager.exportReportToPdf(print);
	}

	
}
