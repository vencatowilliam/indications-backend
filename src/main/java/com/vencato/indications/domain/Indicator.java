package com.vencato.indications.domain;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vencato.indications.domain.enums.DocumentType;
import com.vencato.indications.domain.enums.Profile;
import com.vencato.indications.dtos.IndicatorDTO;

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
			Integer ddd, Integer phone, String password) {
		super(id, description, documentType, document, email, ddd, phone, password);
		addProfile(Profile.INDICATOR);
	}

	public Indicator(IndicatorDTO obj) {
		super();
		this.id = obj.getId();
		this.description = obj.getDescription();
		this.profiles = obj.getProfiles().stream().map(x -> x.getId()).collect(Collectors.toSet());
		this.documentType = obj.getDocumentType();
		this.document = obj.getDocument();
		this.email = obj.getEmail();
		DDD = obj.getDDD();
		this.phone = obj.getPhone();
		this.creationDate = obj.getCreationDate();
	}

	public List<Indication> getIndications() {
		return indications;
	}
	public void setIndications(List<Indication> indications) {
		this.indications = indications;
	}
}
