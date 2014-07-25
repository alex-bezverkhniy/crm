package org.crm.common.domain;

import org.crm.common.domain.dictionaries.Sex;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Customer extends BaseEntity<Long> {

	private static final long serialVersionUID = -4968910478543113598L;
	
	@Column(unique = true)
	private String code;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String homePhone;
	private String workPhone;
	private String mobilePhone;
	private String contactPhone;
	private String skype;
	@Temporal(TemporalType.DATE)
	private Date birthday;
	private Sex sex;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Address> addresses; 
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	
	
	@Override
	public String toString() {
		return "Customer [code=" + code + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName
				+ ", email=" + email + ", homePhone=" + homePhone
				+ ", workPhone=" + workPhone + ", mobilePhone=" + mobilePhone
				+ ", contactPhone=" + contactPhone + ", skype=" + skype
				+ ", birthday=" + birthday + ", sex=" + sex + ", addresses="
				+ addresses + ", created=" + created + ", lastModified="
				+ lastModified + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result	+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result	+ ((contactPhone == null) ? 0 : contactPhone.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result	+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result	+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result	+ ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result	+ ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
		Customer other = (Customer) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (contactPhone == null) {
			if (other.contactPhone != null)
				return false;
		} else if (!contactPhone.equals(other.contactPhone))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (mobilePhone == null) {
			if (other.mobilePhone != null)
				return false;
		} else if (!mobilePhone.equals(other.mobilePhone))
			return false;
		if (sex != other.sex)
			return false;
		return true;
	}
	
}
