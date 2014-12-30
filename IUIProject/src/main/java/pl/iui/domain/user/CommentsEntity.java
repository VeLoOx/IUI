package pl.iui.domain.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Proxy;

import pl.iui.commons.domain.BaseEntity;
import pl.iui.domain.topic.TopicEntity;

@Entity
@Table(name="appcomments")
@Proxy(lazy=false)
public class CommentsEntity extends BaseEntity {

	private String autor;
	private String text;
	private Date data;
	
	private TopicEntity topic;
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_topic")*/
	public TopicEntity getTopic() {
		return topic;
	}
	public void setTopic(TopicEntity topic) {
		this.topic = topic;
	}
	
	
}
