package pl.iui.domain.topic;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.iui.commons.domain.BaseEntity_;
import pl.iui.domain.user.AdressEntity;
import pl.iui.domain.user.CommentsEntity;
import pl.iui.domain.user.UserEntity;

@Generated(value="Dali", date="2014-12-15T14:49:43.954+0100")
@StaticMetamodel(TopicEntity.class)
public class TopicEntity_ extends BaseEntity_ {
	public static volatile SingularAttribute<TopicEntity, AdressEntity> adress;
	public static volatile SingularAttribute<TopicEntity, Date> data;
	public static volatile ListAttribute<TopicEntity, CommentsEntity> comments;
	public static volatile SingularAttribute<TopicEntity, String> name;
	public static volatile SingularAttribute<TopicEntity, UserEntity> autor;
	public static volatile SingularAttribute<TopicEntity, String> describe;
	public static volatile SingularAttribute<TopicEntity, String> photo;
}
