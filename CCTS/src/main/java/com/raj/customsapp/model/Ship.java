package com.raj.customsapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Ships")
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shipId;

    @Column(nullable = false)
    private String shipName;
    
    @Column(nullable = false)
    private Double price_per_ton;

    @Column(nullable = true)
    private String shipStatus="Not Arrived";

	public String getShipStatus() {
		return shipStatus;
	}

	public void setShipStatus(String shipStatus) {
		this.shipStatus = shipStatus;
	}

	public Double getPrice_per_ton() {
		return price_per_ton;
	}

	public void setPrice_per_ton(Double price_per_ton) {
		this.price_per_ton = price_per_ton;
	}

	@Column(nullable = true)
	private Date arrivalDate;

    private Date boardingDate;
    private Date departureDate;
    
    @Column(nullable = true)
    private String departurePort;
   

	public Ship(Integer shipId, String shipName, Double price_per_ton, String shipStatus, Date arrivalDate,
			Date boardingDate, Date departureDate, String departurePort, String boardingPort, Double maxCapacity,
			Double currentLoad) {
		super();
		this.shipId = shipId;
		this.shipName = shipName;
		this.price_per_ton = price_per_ton;
		this.shipStatus = shipStatus;
		this.arrivalDate = arrivalDate;
		this.boardingDate = boardingDate;
		this.departureDate = departureDate;
		this.departurePort = departurePort;
		this.boardingPort = boardingPort;
		this.maxCapacity = maxCapacity;
		this.currentLoad = currentLoad;
	}

	public String getBoardingPort() {
		return boardingPort;
	}

	public void setBoardingPort(String boardingPort) {
		this.boardingPort = boardingPort;
	}

	public String getDeparturePort() {
		return departurePort;
	}

	public void setDeparturePort(String departurePort) {
		this.departurePort = departurePort;
	}

	

	@Column(nullable = true)
    private String boardingPort;

    @Column(nullable = false)
    private Double maxCapacity;

    @Column(nullable = false)
    private Double currentLoad;

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getBoardingDate() {
		return boardingDate;
	}

	public void setBoardingDate(Date boardingDate) {
		this.boardingDate = boardingDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}


	public Double getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Double maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public Double getCurrentLoad() {
		return currentLoad;
	}

	public void setCurrentLoad(Double currentLoad) {
		this.currentLoad = currentLoad;
	}


	public Ship() {
		super();
	}
	
    
}
