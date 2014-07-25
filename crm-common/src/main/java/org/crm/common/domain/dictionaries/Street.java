package org.crm.common.domain.dictionaries;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Street extends BaseDictionary {
	private static final long serialVersionUID = 6434541778773408815L;
	
	@ManyToOne
	private City city;
	
	public Street(String code, String name, City city) {
		super(code, name);
		this.city = city;
	}

	public Street() {
		super();
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
