package com.vencato.indications.domain;

import java.util.List;
import java.util.Set;

import com.vencato.indications.domain.enums.DocumentType;

public class Indicator extends User{

	private List<Indication> indications;

	public Indicator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Indicator(Integer iD, String description, Set<DocumentType> documentType, String document, String email,
			Integer dDD, Integer phone) {
		super(iD, description, documentType, document, email, dDD, phone);
		// TODO Auto-generated constructor stub
	}

	public List<Indication> getIndications() {
		return indications;
	}
	public void setIndications(List<Indication> indications) {
		this.indications = indications;
	}
}
