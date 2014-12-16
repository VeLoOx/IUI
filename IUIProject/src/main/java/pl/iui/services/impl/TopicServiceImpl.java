package pl.iui.services.impl;

import java.util.List;

import javax.faces.application.FacesMessage;

import pl.iui.dao.topic.TopicDao;
import pl.iui.domain.topic.TopicEntity;
import pl.iui.domain.user.UserEntity;
import pl.iui.services.TopicService;

public class TopicServiceImpl extends FacesMessagesProvider implements TopicService {
	
	private TopicDao topicDao;

	@Override
	public boolean addTopic(TopicEntity topic, UserEntity user) {
		// TODO Auto-generated method stub
		topic.setAutor("ALALA");
		//System.out.println(topic.get);
		topicDao.update(topic);
		
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
