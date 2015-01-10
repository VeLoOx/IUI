package pl.iui.dao.topic;

import java.util.List;

import pl.iui.commons.dao.GenericDao;
import pl.iui.domain.topic.TopicEntity;
import pl.iui.domain.user.UserEntity;

public interface TopicDao extends GenericDao<TopicEntity, Long> {
	
	public List<TopicEntity> findUserTopic(String name);
	public List<TopicEntity> findLastTopics(int n);
	public List<TopicEntity> findTopicForUser(UserEntity user);
	public List<TopicEntity> findMostPopularTopic(int n);
	public List<TopicEntity> findByString(String text);
}
