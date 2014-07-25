package org.crm.common.domain;

import org.crm.common.domain.dictionaries.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
public class Address extends BaseEntity<Long> {

	private static final long serialVersionUID = 7454456350354694226L;
	@ManyToOne
	private House house;
	@ManyToOne
	private Street street;
	@ManyToOne
	private City city;
	@ManyToOne
	private Area area;
	@ManyToOne
	private Region region;
	@ManyToOne
	private Country country;
	
	@Temporal(TemporalType.DATE)
	private Date livesSince;

	private AddressType addressType;
	
	public Address(House house, Street street, City city, Area area,
			Region region, Country country, Date livesSince, AddressType addressType) {
		super();
		this.house = house;
		this.street = street;
		this.city = city;
		this.area = area;
		this.region = region;
		this.country = country;
		this.livesSince = livesSince;
		this.addressType = addressType;
	}

	public Address() {
		super();
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Date getLivesSince() {
		return livesSince;
	}

	public void setLivesSince(Date livesSince) {
		this.livesSince = livesSince;
	}	
	
	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		return "Address [house=" + house + ", street=" + street + ", city="
				+ city + ", area=" + area + ", region=" + region + ", country="
				+ country + ", livesSince=" + livesSince + ", addressType="
				+ addressType + ", created=" + created + ", lastModified="
				+ lastModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result	+ ((addressType == null) ? 0 : addressType.hashCode());
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((house == null) ? 0 : house.hashCode());
		//result = prime * result	+ ((livesSince == null) ? 0 : livesSince.hashCode());
		result = prime * result + ((region == null) ? 0 : region.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressType != other.addressType)
			return false;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (house == null) {
			if (other.house != null)
				return false;
		} else if (!house.equals(other.house))
			return false;
		/*
        if (livesSince == null) {
			if (other.livesSince != null)
				return false;
		} else if (!livesSince.equals(other.livesSince))
			return false;
        */
		if (region == null) {
			if (other.region != null)
				return false;
		} else if (!region.equals(other.region))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
	
	
}
