package pl.iui.domain.user;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.iui.commons.domain.BaseEntity_;
import pl.iui.domain.topic.TopicEntity;

@Generated(value="Dali", date="2014-12-15T14:49:43.986+0100")
@StaticMetamodel(CommentsEntity.class)
public class CommentsEntity_ extends BaseEntity_ {
	public static volatile SingularAttribute<CommentsEntity, Date> data;
	public static volatile SingularAttribute<CommentsEntity, String> autor;
	public static volatile SingularAttribute<CommentsEntity, String> text;
	public static volatile SingularAttribute<CommentsEntity, TopicEntity> topic;
}
