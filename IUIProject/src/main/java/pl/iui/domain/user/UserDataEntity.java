package pl.iui.domain.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

import javax.persistence.*;

import org.hibernate.Hibernate;

import pl.iui.commons.domain.BaseEntity;

/**
 * Entity to hold application user advanced data - sex, birth year, address,
 * hobbies etc.
 * 
 */
@Entity
@Table(name = "appuserdata")
@Access(AccessType.FIELD)
@Proxy(lazy = false)
public class UserDataEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	private int yearOfBirth;
	private String sex;

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinColumn(name = "idadress")
	private AdressEntity adress = new AdressEntity();
	
	@ElementCollection (fetch = FetchType.EAGER)
	@CollectionTable(name="udatahobbies", joinColumns=@JoinColumn(name="userdataid"))
	@Column(name="hobby")
	private List<String> hobbies = new ArrayList<String>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public AdressEntity getAdress() {
		return adress;
	}

	public void setAdress(AdressEntity adress) {
		this.adress = adress;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

}
