package com.raj.customsapp.model;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "ExporterApplications")
public class ExporterApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer applicationId;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "shipId")
    private Ship ship;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDING;

    @Column(nullable = false)
    private java.sql.Date submissionDate;

    private String importerName;
    private String importerEmail;
    private String impPhnum;

    private String exporterName;
    private String exporterEmail;
    private String expPhnum;

    private String productName;
    private String productDescription;

    @Column(nullable = false)
    private Double weight;

    private String destinationCountry;
    
    @Lob
    @Column(nullable = false,length = 1000000)
    private byte[] documentFile;

    public enum Status {
    	 PENDING, APPROVED, REJECTED    }

	public Integer getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public java.sql.Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(java.sql.Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public String getImporterName() {
		return importerName;
	}

	public void setImporterName(String importerName) {
		this.importerName = importerName;
	}

	public String getImporterEmail() {
		return importerEmail;
	}

	public void setImporterEmail(String importerEmail) {
		this.importerEmail = importerEmail;
	}

	public String getImpPhnum() {
		return impPhnum;
	}

	public void setImpPhnum(String impPhnum) {
		this.impPhnum = impPhnum;
	}

	public String getExporterName() {
		return exporterName;
	}

	public void setExporterName(String exporterName) {
		this.exporterName = exporterName;
	}

	public String getExporterEmail() {
		return exporterEmail;
	}

	public void setExporterEmail(String exporterEmail) {
		this.exporterEmail = exporterEmail;
	}

	public String getExpPhnum() {
		return expPhnum;
	}

	public void setExpPhnum(String expPhnum) {
		this.expPhnum = expPhnum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getDestinationCountry() {
		return destinationCountry;
	}

	public void setDestinationCountry(String destinationCountry) {
		this.destinationCountry = destinationCountry;
	}

	

	public byte[] getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(byte[] documentFile) {
		this.documentFile = documentFile;
	}

	public ExporterApplication(Integer applicationId, User user, Ship ship, Status status, Date submissionDate,
			String importerName, String importerEmail, String impPhnum, String exporterName, String exporterEmail,
			String expPhnum, String productName, String productDescription, Double weight, String destinationCountry,
			byte[] documentFile) {
		super();
		this.applicationId = applicationId;
		this.user = user;
		this.ship = ship;
		this.status = status;
		this.submissionDate = submissionDate;
		this.importerName = importerName;
		this.importerEmail = importerEmail;
		this.impPhnum = impPhnum;
		this.exporterName = exporterName;
		this.exporterEmail = exporterEmail;
		this.expPhnum = expPhnum;
		this.productName = productName;
		this.productDescription = productDescription;
		this.weight = weight;
		this.destinationCountry = destinationCountry;
		this.documentFile = documentFile;
	}

	public ExporterApplication() {
		super();
	}
    
}
