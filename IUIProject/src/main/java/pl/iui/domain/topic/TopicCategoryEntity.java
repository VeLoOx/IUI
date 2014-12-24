package pl.iui.domain.topic;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "apptopiccategory")
@Proxy(lazy = false)
public class TopicCategoryEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	private static final long serialVersionUID = 1L;
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
	public String toString() {
		return name;
	}

}
