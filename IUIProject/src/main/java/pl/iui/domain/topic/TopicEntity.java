package pl.iui.domain.topic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

import pl.iui.domain.user.AdressEntity;
import pl.iui.domain.user.CommentsEntity;

@Entity
@Table(name="apptopic")
@Proxy(lazy=false)
public class TopicEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	private String name;
	private String autor;
	private String describe;
	private String photo;
	
	@Column
	@Type(type="date")
	private Date data;
	
	@OneToOne(cascade={CascadeType.ALL}, fetch = FetchType.EAGER,  targetEntity=pl.iui.domain.user.AdressEntity.class)
	@JoinColumn(name="idtadress") 
	private AdressEntity adress;
	
	
	private String category;
	
	@OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable
	  (
	      name="TOP_COMM",
	      joinColumns={ @JoinColumn(name="TOP_ID", referencedColumnName="ID") },
	      inverseJoinColumns={ @JoinColumn(name="COMM_ID", referencedColumnName="ID", unique=true) }
	  )
	private List<CommentsEntity> comments = new ArrayList<CommentsEntity>();

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
	public AdressEntity getAdress() {
		return adress;
	}

	public void setAdress(AdressEntity adress) {
		this.adress = adress;
	}

	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public List<CommentsEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentsEntity> comments) {
		this.comments = comments;
	}

	@Override
	public String toString (){
		return name + "   " + category + "   " +adress.getCity();
	}
	
}
