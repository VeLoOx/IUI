package pl.iui.services;

import java.util.List;

import pl.iui.domain.topic.TopicEntity;
import pl.iui.domain.user.AdressEntity;
import pl.iui.domain.user.UserEntity;

public interface TopicService {
	
	public boolean addTopic(TopicEntity topic, UserEntity user, AdressEntity adress);
	
	public List<TopicEntity> getAllTopic();

}
