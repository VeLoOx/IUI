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

	@OneToOne(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, targetEntity=pl.iui.domain.user.AdressEntity.class)
	@JoinColumn(name = "idadress")
	private AdressEntity adress = new AdressEntity();
	
	@ElementCollection ( fetch = FetchType.EAGER)
	@CollectionTable(name="udatahobbies", joinColumns=@JoinColumn(name="userdataid"))
	@Column(name="hobby")
	private List<String> hobbies = new ArrayList<String>();
	
	@ElementCollection (fetch = FetchType.EAGER)
	@CollectionTable(name="udataratedtopics", joinColumns=@JoinColumn(name="userdataid"))
	@Column(name="ratedtopic")
	private List<Long> ratedTopics = new ArrayList<Long>();
	
	@ElementCollection (fetch = FetchType.EAGER)
	@CollectionTable(name="udatafavoritetopics", joinColumns=@JoinColumn(name="userdataid"))
	@Column(name="favoritetopic")
	private List<Long> favoriteTopics = new ArrayList<Long>();
	
	@ElementCollection (fetch = FetchType.EAGER)
	@CollectionTable(name="udatafavoriteusers", joinColumns=@JoinColumn(name="userdataid"))
	@Column(name="favoriteuser")
	private List<Long> favoriteUsers = new ArrayList<Long>();

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

	public List<Long> getRatedTopics() {
		return ratedTopics;
	}

	public void setRatedTopics(List<Long> ratedTopics) {
		this.ratedTopics = ratedTopics;
	}

	public List<Long> getFavoriteTopics() {
		return favoriteTopics;
	}

	public void setFavoriteTopics(List<Long> favoriteTopics) {
		this.favoriteTopics = favoriteTopics;
	}

	public List<Long> getFavoriteUsers() {
		return favoriteUsers;
	}

	public void setFavoriteUsers(List<Long> favoriteUsers) {
		this.favoriteUsers = favoriteUsers;
	}

}
