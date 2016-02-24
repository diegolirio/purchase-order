package com.diegolirio.purchaseorder.reports.services;

import net.sf.jasperreports.engine.JRException;

import org.springframework.stereotype.Service;

@Service
public interface ReportService {

	public byte[] generateReport(Object object) throws JRException ;
	
}
