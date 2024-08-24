package com.raj.customsapp.repository;

import java.util.List;
import com.raj.customsapp.model.ExporterInvoice;

public interface ExporterInvoiceRepo {

	void save(ExporterInvoice app);
	List<ExporterInvoice> findAll();
	public ExporterInvoice getInv(int id);
	List<ExporterInvoice> getInvoicesByUserId(int id);
}

