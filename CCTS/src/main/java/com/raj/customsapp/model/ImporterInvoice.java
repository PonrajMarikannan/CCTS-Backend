package com.raj.customsapp.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ImporterInvoices")
public class ImporterInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;

    @ManyToOne
    @JoinColumn(name = "applicationId")
    private ImporterApplication importerApplication;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private java.sql.Date invoiceDate;

	public ImporterInvoice(Integer invoiceId, ImporterApplication importerApplication, int amount, Date invoiceDate) {
		super();
		this.invoiceId = invoiceId;
		this.importerApplication = importerApplication;
		this.amount = amount;
		this.invoiceDate = invoiceDate;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public ImporterApplication getImporterApplication() {
		return importerApplication;
	}

	public void setImporterApplication(ImporterApplication importerApplication) {
		this.importerApplication = importerApplication;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public java.sql.Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(java.sql.Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public ImporterInvoice() {
		super();
	}

	

}
