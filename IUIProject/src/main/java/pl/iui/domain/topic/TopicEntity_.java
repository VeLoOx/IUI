package pl.iui.domain.topic;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-26T12:34:32.588+0100")
@StaticMetamodel(TopicEntity.class)
public class TopicEntity_ {
	public static volatile SingularAttribute<TopicEntity, Long> id;
	public static volatile SingularAttribute<TopicEntity, Object> adress;
	public static volatile CollectionAttribute<TopicEntity, Object> comments;
}
