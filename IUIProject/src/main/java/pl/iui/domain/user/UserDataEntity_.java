package pl.iui.domain.user;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.iui.commons.domain.BaseEntity_;

@Generated(value="Dali", date="2014-12-15T12:13:55.437+0100")
@StaticMetamodel(UserDataEntity.class)
public class UserDataEntity_ extends BaseEntity_ {
	public static volatile ListAttribute<UserDataEntity, HobbiesEntity> hobbies;
	public static volatile SingularAttribute<UserDataEntity, AdressEntity> adress;
	public static volatile SingularAttribute<UserDataEntity, Integer> yearOfBirth;
	public static volatile SingularAttribute<UserDataEntity, String> sex;
}
