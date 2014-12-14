package pl.iui.domain.user;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import pl.iui.commons.domain.BaseEntity;

@Entity
@Table(name="apphobbies")
@Proxy(lazy=false)
public class HobbiesEntity extends BaseEntity {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
