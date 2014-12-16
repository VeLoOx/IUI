package pl.iui.domain.user;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-16T21:03:54.448+0100")
@StaticMetamodel(UserDataEntity.class)
public class UserDataEntity_ {
	public static volatile SingularAttribute<UserDataEntity, Long> id;
	public static volatile SingularAttribute<UserDataEntity, AdressEntity> adress;
	public static volatile SingularAttribute<UserDataEntity, Integer> yearOfBirth;
	public static volatile SingularAttribute<UserDataEntity, String> sex;
}
