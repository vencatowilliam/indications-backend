package com.vencato.indications.domain.enums;

public enum DocumentType {

	CPF(0, "CPF"), CNPJ(0, "CNPJ");
	
	private Integer id;
	private String description;

	private DocumentType(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}
	public String getDescription() {
		return description;
	}

	public static DocumentType toEnum(Integer id) {
		if(id == null) {
			return null;
		}

		for(DocumentType x : DocumentType.values()) {
			if(id.equals(x.getId())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Tipo de documento inválido!");
	}
}
