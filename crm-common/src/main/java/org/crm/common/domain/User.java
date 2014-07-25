package org.crm.common.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User class
 * 
 * @author "Alex Bezverkhniy"
 *
 */
@Entity
@NamedQuery(name = "User.findByTheUsersName", query = "from User u where u.userName = ?1")
public class User extends AbstractPersistable<Long> {
    
	private static final long serialVersionUID = 5833255179194698922L;

	@Column(unique = true) 
	private String userName;

    private String firstName;
    private String lastName;
    
    @ManyToMany
    private List<UserRole> roles;
    
	public User() {
		this(null);
	}
	
	public User(Long id) {
		this.setId(id);
	}
    public void addRole(UserRole role) {
        if(roles == null) {
            roles = new ArrayList<UserRole>();
        }
        this.roles.add(role);
    }

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}
    
    
}
