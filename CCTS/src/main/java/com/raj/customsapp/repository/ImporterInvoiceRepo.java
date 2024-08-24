package com.raj.customsapp.repository;

import java.util.List;
import com.raj.customsapp.model.ImporterInvoice;

public interface ImporterInvoiceRepo {

	void save(ImporterInvoice app);
	List<ImporterInvoice> findAll();
	public ImporterInvoice getInv(int id);
	List<ImporterInvoice> getInvoicesByUserId(int id);
}

