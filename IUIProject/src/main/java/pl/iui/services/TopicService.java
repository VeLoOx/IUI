package pl.iui.services;

import java.util.List;

import pl.iui.domain.topic.TopicEntity;
import pl.iui.domain.user.UserEntity;

public interface TopicService {
	
	public boolean addTopic(TopicEntity topic, UserEntity user);
	
	public List<TopicEntity> getAllTopic();

}
