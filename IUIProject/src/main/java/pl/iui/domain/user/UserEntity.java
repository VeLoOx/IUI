package pl.iui.domain.user;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

/**
 * Entity to hold application user data - first name, last name, etc.
 * 
 */
@Entity
@Table(name = "appuser")
@Access(AccessType.FIELD)
@Proxy(lazy = false)
public class UserEntity implements Serializable {
	private static final long serialVersionUID = -8789920463809744548L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ud")
	private UserDataEntity userData;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		Md5PasswordEncoder crypto = new Md5PasswordEncoder();
		this.password = crypto.encodePassword(password, null);
	}

	public UserDataEntity getUserData() {
		return userData;
	}

	public void setUserData(UserDataEntity userData) {
		this.userData = userData;
	}

}
