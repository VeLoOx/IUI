package pl.iui.domain;

import java.util.ArrayList;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.iui.commons.domain.BaseEntity_;

@Generated(value="Dali", date="2014-12-13T18:58:39.602+0100")
@StaticMetamodel(UserDataEntity.class)
public class UserDataEntity_ extends BaseEntity_ {
	public static volatile SingularAttribute<UserDataEntity, Integer> yearOfBirth;
	public static volatile SingularAttribute<UserDataEntity, String> sex;
	public static volatile SingularAttribute<UserDataEntity, String> city;
	public static volatile SingularAttribute<UserDataEntity, ArrayList> hobbies;
	public static volatile SingularAttribute<UserDataEntity, UserEntity> userEntity;
}