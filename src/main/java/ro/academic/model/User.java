package ro.academic.model;



import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * User entity
 * @author Alexandru
 *
 */
@Entity
@Table(name = "User")
public class User implements Serializable {
	
    /**
	 *  Default serial version
	 */
	private static final long serialVersionUID = 1L;
	
    private String username;
    
    private String password;
    
    private int priviledge;

    @Id
	@Column(name = "username", unique = true, 
			nullable = false, length = 64)
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "priviledge", unique = false, 
			nullable = false)
	public int getPriviledge() {
		return priviledge;
	}

	public void setPriviledge(int priviledge) {
		this.priviledge = priviledge;
	}


	@Column(name = "password", unique = false, 
			nullable = false, length = 129)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}
