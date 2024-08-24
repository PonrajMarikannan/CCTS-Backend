package com.raj.customsapp.service;

import java.util.List;
import com.raj.customsapp.model.ExporterInvoice;

public interface ExporterInvoiceService {
	
    void addApplication(ExporterInvoice inv);
    public List<ExporterInvoice> getAllInv();
    public ExporterInvoice getInv(int id);  
    public List<ExporterInvoice> getInvoicesByUserId(int id);

     
}
