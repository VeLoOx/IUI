package pl.iui.dao.topic.implementation;

import pl.iui.commons.dao.GenericJpaDao;
import pl.iui.dao.topic.TopicCategoryDao;
import pl.iui.domain.topic.TopicCategoryEntity;

public class TopicCategoryJpaDao extends GenericJpaDao<TopicCategoryEntity, Long> implements TopicCategoryDao {
	public TopicCategoryJpaDao(){
		super(TopicCategoryEntity.class);
	}
}
