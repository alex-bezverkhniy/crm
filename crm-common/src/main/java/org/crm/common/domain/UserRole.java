package org.crm.common.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class UserRole extends AbstractPersistable<Long> {

	private static final long serialVersionUID = 4240220217219387481L;
	
	@Column(unique = true)
	private String roleName;
	
	private String description;
	
	public UserRole() {
		this(null);
	}
	
	public UserRole(Long id) {
		this.setId(id);
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
