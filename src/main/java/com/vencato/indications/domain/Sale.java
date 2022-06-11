package com.vencato.indications.domain;

import java.time.LocalDate;

import com.vencato.indications.domain.enums.SaleStatus;

public class Sale {

	private Integer ID;
	private String description;
	private Producer producer;
	private Indication indication;
	private String observations;
	private SaleStatus saleStatus = SaleStatus.NEW;
	private LocalDate creationDate = LocalDate.now();
	private LocalDate closingDate;
	
	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sale(Integer iD, String description, Producer producer, Indication indication, String observations) {
		super();
		ID = iD;
		this.description = description;
		this.producer = producer;
		this.indication = indication;
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

	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Indication getIndication() {
		return indication;
	}
	public void setIndication(Indication indication) {
		this.indication = indication;
	}

	public String getObservations() {
		return observations;
	}
	public void setObservations(String observations) {
		this.observations = observations;
	}

	public SaleStatus getSaleStatus() {
		return saleStatus;
	}
	public void setSaleStatus(SaleStatus saleStatus) {
		this.saleStatus = saleStatus;
	}

	public LocalDate getClosingDate() {
		return closingDate;
	}
	public void setClosingDate(LocalDate closingDate) {
		this.closingDate = closingDate;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

}
