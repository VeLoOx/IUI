package pl.iui.domain.user;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import pl.iui.commons.domain.BaseEntity;

@Entity
@Table(name="apphobbies")
@Access(AccessType.FIELD)
@Proxy(lazy=false)
public class HobbiesEntity {
	@Id
    @GeneratedValue
    @Column(name="id")
	 private Long id;
	
	private String name;
	 
     
     public Long getId() {
             return id;
     }
     public void setId(Long id) {
             this.id = id;
     }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
}
