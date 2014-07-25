package org.crm.common.domain.dictionaries;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class City extends BaseDictionary {

	private static final long serialVersionUID = 3205346778561632761L;

	@ManyToOne
	private Area area;



	public City(String code, String name, Area area) {		
		super(code, name);		
		this.area = area;		
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

}
