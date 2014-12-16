package pl.iui.dao.topic.implementation;

import pl.iui.commons.dao.GenericJpaDao;
import pl.iui.dao.topic.TopicDao;
import pl.iui.domain.topic.TopicEntity;
import pl.iui.domain.user.UserEntity;

public class TopicJpaDao extends GenericJpaDao<TopicEntity, Long> implements TopicDao {

	public TopicJpaDao(){
		super(TopicEntity.class);
	}
}
