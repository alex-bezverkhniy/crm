package org.crm.common.domain.dictionaries;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Region extends BaseDictionary {
	private static final long serialVersionUID = 7254555531471686289L;

	@ManyToOne
	private Country country;

	public Region(String code, String name, Country country) {
		super(code, name);
		this.country = country;
	}

	public Region() {
		super();
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
