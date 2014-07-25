package org.crm.common.domain.dictionaries;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Area extends BaseDictionary {

	private static final long serialVersionUID = 6375038805743825334L;

	@ManyToOne
	private Region region;

	public Area(String code, String name, Region region) {
		super(code, name);		
		this.region = region;
		
	}

	public Area() {
		super();
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
