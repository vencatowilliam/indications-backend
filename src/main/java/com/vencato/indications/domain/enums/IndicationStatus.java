package com.vencato.indications.domain.enums;

public enum IndicationStatus {
	NEW(0, "NEW"), IN_PROGRESS(1, "IN PROGRESS"), PENDING(2, "PENDING"), SOLD(3, "SOLD"), NOT_SOLD(4, "NOT SOLD");

	private Integer ID;
	private String description;

	private IndicationStatus(Integer iD, String description) {
		ID = iD;
		this.description = description;
	}

	public Integer getID() {
		return ID;
	}
	public String getDescription() {
		return description;
	}

	public static IndicationStatus toEnum(Integer id) {
		if(id == null) {
			return null;
		}

		for(IndicationStatus x : IndicationStatus.values()) {
			if(id.equals(x.getID())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Status inválido!");
	}
}
