package pl.iui.services.impl;

import java.util.List;

import pl.iui.dao.topic.TopicDao;
import pl.iui.domain.topic.TopicEntity;
import pl.iui.domain.user.AdressEntity;
import pl.iui.domain.user.UserEntity;
import pl.iui.services.TopicService;

public class TopicServiceImpl extends FacesMessagesProvider implements TopicService {
	
	private TopicDao topicDao;

	@Override
	public boolean addTopic(TopicEntity topic, UserEntity user, AdressEntity adress) {
		// TODO Auto-generated method stub
		topic.setAutor(user.getUserName());
		topic.setAdress(adress);
		topicDao.save(topic);
		
		return true;
	}

	@Override
	public List<TopicEntity> getAllTopic() {
		// TODO Auto-generated method stub
		return topicDao.findAll();
	}

	public TopicDao getTopicDao() {
		return topicDao;
	}

	public void setTopicDao(TopicDao topicDao) {
		this.topicDao = topicDao;
	}

}
