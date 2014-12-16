package pl.iui.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import pl.iui.dao.topic.TopicCategoryDao;
import pl.iui.domain.topic.TopicCategoryEntity;
import pl.iui.services.TopicCategoryService;

public class TopicCategoryServiceImpl implements TopicCategoryService{

	TopicCategoryDao topicCategoryDao;
	@Override
	public List<TopicCategoryEntity> getAllTopicCategory() {
		// TODO Auto-generated method stub
		return topicCategoryDao.findAll();
	}
	public TopicCategoryDao getTopicCategoryDao() {
		return topicCategoryDao;
	}
	  @Required
	public void setTopicCategoryDao(TopicCategoryDao topicCategoryDao) {
		this.topicCategoryDao = topicCategoryDao;
	}

}
