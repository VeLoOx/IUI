package pl.iui.dao.topic;

import java.util.List;

import pl.iui.commons.dao.GenericDao;
import pl.iui.domain.topic.TopicEntity;

public interface TopicDao extends GenericDao<TopicEntity, Long> {
	
	public List<TopicEntity> findUserTopic(String name);

}
