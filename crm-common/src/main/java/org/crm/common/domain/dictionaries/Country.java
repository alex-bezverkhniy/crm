package org.crm.common.domain.dictionaries;

import javax.persistence.Entity;

@Entity
public class Country extends BaseDictionary {

	private static final long serialVersionUID = 8948563603937511588L;

	public Country(String code, String name) {
		super(code, name);	
	}

	public Country() {
		super();
	}

}
