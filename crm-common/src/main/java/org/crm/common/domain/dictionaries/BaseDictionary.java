package org.crm.common.domain.dictionaries;

import org.crm.common.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

@MappedSuperclass
public abstract class BaseDictionary extends BaseEntity<Long> {

	private static final long serialVersionUID = -6609825840486232711L;

	private String name;
	@Column(unique = true)
	private String code;

	public BaseDictionary() {
		super(new Date(), new Date());
	}

	public BaseDictionary(String code, String name) {
		this();
		this.setCode(code);
		this.setName(name);		
	}

	@Override
	public String toString() {
		Format formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss.SS");
		return this.getClass().getName() + " [id=" + getId() + ", name=" + name
				+ ", code=" + code + ", created=" + formatter.format(getCreated())
				+ ", lastModified=" + formatter.format(getLastModified()) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		BaseDictionary other = (BaseDictionary) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
