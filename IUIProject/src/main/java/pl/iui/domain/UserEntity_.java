package pl.iui.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.iui.commons.domain.BaseEntity_;

@Generated(value="Dali", date="2014-12-01T22:13:31.650+0100")
@StaticMetamodel(UserEntity.class)
public class UserEntity_ extends BaseEntity_ {
	public static volatile SingularAttribute<UserEntity, String> firstName;
	public static volatile SingularAttribute<UserEntity, String> lastName;
	public static volatile SingularAttribute<UserEntity, String> userName;
	public static volatile SingularAttribute<UserEntity, String> password;
}
