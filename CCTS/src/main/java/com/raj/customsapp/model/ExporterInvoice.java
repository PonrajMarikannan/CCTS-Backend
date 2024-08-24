package com.raj.customsapp.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "ExporterInvoices")
public class ExporterInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;

    @ManyToOne
    @JoinColumn(name = "applicationId")
    private ExporterApplication exporterApplication;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private java.sql.Date invoiceDate;

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public ExporterApplication getExporterApplication() {
		return exporterApplication;
	}

	public void setExporterApplication(ExporterApplication exporterApplication) {
		this.exporterApplication = exporterApplication;
	}


	public java.sql.Date getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(java.sql.Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}


	public ExporterInvoice(Integer invoiceId, ExporterApplication exporterApplication, int amount, Date invoiceDate) {
		super();
		this.invoiceId = invoiceId;
		this.exporterApplication = exporterApplication;
		this.amount = amount;
		this.invoiceDate = invoiceDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public ExporterInvoice() {
		super();
	}
   
}
