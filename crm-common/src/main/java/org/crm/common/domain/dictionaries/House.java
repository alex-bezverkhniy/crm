package org.crm.common.domain.dictionaries;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class House extends BaseDictionary {

	private static final long serialVersionUID = 8970922309717785591L;

	@ManyToOne
	private Street street;

	
	public House(String code, String name, Street street) {
		super(code, name);
		this.street = street;		
	}

	public House() {
		super();
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

}
