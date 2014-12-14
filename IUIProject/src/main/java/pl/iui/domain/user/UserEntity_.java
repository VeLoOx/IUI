package pl.iui.domain.user;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.iui.commons.domain.BaseEntity_;

@Generated(value="Dali", date="2014-12-12T17:18:28.936+0100")
@StaticMetamodel(UserEntity.class)
public class UserEntity_ extends BaseEntity_ {
	public static volatile SingularAttribute<UserEntity, String> firstName;
	public static volatile SingularAttribute<UserEntity, String> lastName;
	public static volatile SingularAttribute<UserEntity, String> userName;
	public static volatile SingularAttribute<UserEntity, String> password;
	public static volatile SingularAttribute<UserEntity, UserDataEntity> userData;
}
