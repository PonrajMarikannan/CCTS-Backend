package com.raj.customsapp.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ImporterPayments")
public class ImporterPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @Column(nullable = false)
    private int impInvoiceId;

    @Column(nullable = false)
    private java.sql.Date paymentDate;

    @Column(nullable = false)
    private int amountPaid;

    @Column(nullable = false)
    private String paymentStatus;

    @Column(nullable = false)
    private String paymentMethod;

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public int getImpInvoiceId() {
		return impInvoiceId;
	}

	public void setImpInvoiceId(int impInvoiceId) {
		this.impInvoiceId = impInvoiceId;
	}

	public java.sql.Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(java.sql.Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public ImporterPayment(Integer paymentId, int impInvoiceId, Date paymentDate, int amountPaid, String paymentStatus,
			String paymentMethod) {
		super();
		this.paymentId = paymentId;
		this.impInvoiceId = impInvoiceId;
		this.paymentDate = paymentDate;
		this.amountPaid = amountPaid;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
	}

	public ImporterPayment() {
		super();
	}


   
}
