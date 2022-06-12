package com.vencato.indications.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vencato.indications.domain.enums.IndicationStatus;

@Entity
public class Indication implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String description;

	@ManyToOne
	@JoinColumn(name = "indicator_id")
	private Indicator indicator;

	@ManyToOne
	@JoinColumn(name = "producer_id")
	private Producer producer;
	
	@ManyToOne
	@JoinColumn(name = "campaign_id")
	private Campaign campaign;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate creationDate = LocalDate.now();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate closingDate;
	
	private IndicationStatus status = IndicationStatus.NEW;
	private String observations;

	@OneToOne
	@JoinColumn(name = "sale_id")
	private Sale sale;

	public Indication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Indication(Integer id, String description, Indicator indicator, /*Campaign campaign,*/ LocalDate closingDate,
			String observations) {
		super();
		this.id = id;
		this.description = description;
		this.indicator = indicator;
		this.closingDate = closingDate;
		this.observations = observations;
	}

	public Integer getID() {
		return id;
	}
	public void setID(Integer id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public Indicator getIndicator() {
		return indicator;
	}
	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}

	public Campaign getCampaign() {
		return campaign;
	}
	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
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
