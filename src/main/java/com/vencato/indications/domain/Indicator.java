package com.vencato.indications.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vencato.indications.domain.enums.DocumentType;
import com.vencato.indications.domain.enums.Profile;

@Entity
public class Indicator extends User {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToMany(mappedBy = "indicator")
	private List<Indication> indications;

	public Indicator() {
		super();
		addProfile(Profile.INDICATOR);
	}
	public Indicator(Integer id, String description, DocumentType documentType, String document, String email,
			Integer ddd, Integer phone) {
		super(id, description, documentType, document, email, ddd, phone);
		addProfile(Profile.INDICATOR);
	}

	public List<Indication> getIndications() {
		return indications;
	}
	public void setIndications(List<Indication> indications) {
		this.indications = indications;
	}
}
