package com.vencato.indications.domain;

import java.time.LocalDate;

import com.vencato.indications.domain.enums.IndicationStatus;

public class Indication {

	private Integer ID;
	private String description;
	private LocalDate creationDate = LocalDate.now();
	private LocalDate closingDate;
	private IndicationStatus status = IndicationStatus.NEW;
	private String observations;
	private Sale sale;

	public Indication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Indication(Integer iD, String description, LocalDate closingDate, String observations) {
		super();
		ID = iD;
		this.description = description;
		this.closingDate = closingDate;
		this.observations = observations;
	}

	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}
	public IndicationStatus getStatus() {
		return status;
	}
	public void setStatus(IndicationStatus status) {
		this.status = status;
	}
	
	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}
	
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
}
