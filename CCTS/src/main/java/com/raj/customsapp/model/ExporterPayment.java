package com.raj.customsapp.model;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ExporterPayments")
public class ExporterPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @Column(nullable = false)
    private int expInvoiceId;

    @Column(nullable = false)
    private java.sql.Date paymentDate;

    @Column(nullable = false)
    private int amountPaid;

	@Column(nullable = false)
    private String paymentStatus;

    @Column(nullable = false)
    private String paymentMethod;

    public ExporterPayment() {
		super();
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public int getExpInvoiceId() {
		return expInvoiceId;
	}

	public void setExpInvoiceId(int expInvoiceId) {
		this.expInvoiceId = expInvoiceId;
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

	public ExporterPayment(Integer paymentId, int expInvoiceId, Date paymentDate, int amountPaid, String paymentStatus,
			String paymentMethod) {
		super();
		this.paymentId = paymentId;
		this.expInvoiceId = expInvoiceId;
		this.paymentDate = paymentDate;
		this.amountPaid = amountPaid;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
	}


    

}

