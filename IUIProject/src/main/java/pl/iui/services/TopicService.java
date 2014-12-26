package pl.iui.services;

import java.util.List;

import pl.iui.domain.topic.TopicEntity;
import pl.iui.domain.user.AdressEntity;
import pl.iui.domain.user.CommentsEntity;
import pl.iui.domain.user.UserEntity;

public interface TopicService {
	
	public boolean addTopic(TopicEntity topic, UserEntity user, AdressEntity adress);
	
	public List<TopicEntity> getAllTopic();
	public List<TopicEntity> getAllTopicForUser(String name);
	
	public List<CommentsEntity> getAllCommentsForTopic(long id);
	public void addComment(TopicEntity topic, CommentsEntity comm, UserEntity user);
	
	public TopicEntity getSelectedTopic();
	public void setSelectedTopic(TopicEntity topic);
	
	public String getSelectedRate();
	public void setSelectedRate(String val);
	
	public double getRate(TopicEntity top);
	public void addRate(TopicEntity top, String rate, UserEntity ue);

}
