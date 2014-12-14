package pl.iui.domain.user;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Proxy(lazy=false)
public class UserDataEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private int yearOfBirth;
	private String sex;
	
	private ArrayList<HobbiesEntity> hobbies = new ArrayList<HobbiesEntity>();
	private AdressEntity adress = new AdressEntity();

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

	
	@OneToMany(cascade=CascadeType.ALL)
	@OrderColumn(name="HOBBYINDEX")
	public ArrayList<HobbiesEntity> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<HobbiesEntity> hobbies) {
		this.hobbies = hobbies;
	}

	public void addHobbie(HobbiesEntity hobbie) {
		hobbies.add(hobbie);
	}

	public void deleteHobbie(String hobbie) {
		hobbies.remove(hobbie);
	}

	public AdressEntity getAdress() {
		return adress;
	}
	
	@OneToOne(cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name="id_adress") 
	public void setAdress(AdressEntity adress) {
		this.adress = adress;
	}

}
