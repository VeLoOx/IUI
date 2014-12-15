package pl.iui.domain.topic;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

import pl.iui.commons.domain.BaseEntity;
import pl.iui.domain.user.AdressEntity;
import pl.iui.domain.user.UserEntity;
import pl.iui.domain.user.CommentsEntity;;

@Entity
@Table(name="apptopic")
@Proxy(lazy=false)
public class TopicEntity extends BaseEntity {

	private String name;
	private UserEntity autor;
	private String describe;
	private String photo;
	private Date data;
	
	private AdressEntity adress;
	private List<CommentsEntity> comments;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserEntity getAutor() {
		return autor;
	}

	public void setAutor(UserEntity autor) {
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
	
	@OneToOne(cascade={CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name="id_adress") 
	public AdressEntity getAdress() {
		return adress;
	}

	public void setAdress(AdressEntity adress) {
		this.adress = adress;
	}

	@Column
	@Type(type="date")
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@OneToMany(cascade=CascadeType.ALL)
	@OrderColumn(name="id_comments")
	public List<CommentsEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentsEntity> comments) {
		this.comments = comments;
	}
	
}
