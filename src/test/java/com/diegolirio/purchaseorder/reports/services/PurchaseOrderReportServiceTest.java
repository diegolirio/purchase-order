package com.diegolirio.purchaseorder.reports.services;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext-test.xml")
public class PurchaseOrderReportServiceTest {

	private ReportService reportService;
	
	public void test() {
//		reportService = new PurchaseOrderReportService();
//		PurchaseOrder po = PurchaseOrderBuilderTest.build();
//		po.setId(1l);
//		po.set
//		reportService.generateReportPath(po );
		Assert.assertNull(reportService);
	}
	
}
