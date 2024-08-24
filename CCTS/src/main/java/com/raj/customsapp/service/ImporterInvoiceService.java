package com.raj.customsapp.service;

import java.util.List;
import com.raj.customsapp.model.ImporterInvoice;

public interface ImporterInvoiceService {
	
    void addApplication(ImporterInvoice inv);
    public List<ImporterInvoice> getAllInv();
    public ImporterInvoice getInv(int id);  
    public List<ImporterInvoice> getInvoicesByUserId(int id);

     
}
