package pl.iui.domain;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import pl.iui.commons.domain.BaseEntity;

/**
 * Entity to hold application user advanced data - sex, birth year, address,
 * hobbies etc.
 *
 */
@Entity
@Table(name = "appUserData")
public class UserDataEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;
	//	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "stock"))
//	@Id
//	@GeneratedValue(generator = "generator")
//	@Column(name = "userData_ID", unique = true, nullable = false)
//	private long id;
//	private UserEntity userEntity;
	private int yearOfBirth;
	private String sex;
	private String city;
	private ArrayList<String> hobbies = new ArrayList<String>();

//	@OneToOne(fetch = FetchType.LAZY)
//	@PrimaryKeyJoinColumn
	/*public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
*/
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

	public void addHobbie(String hobbie) {
		hobbies.add(hobbie);
	}

	public void deleteHobbie(String hobbie) {
		hobbies.remove(hobbie);
	}

}
