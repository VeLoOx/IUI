package pl.iui.domain.user;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import pl.iui.commons.domain.BaseEntity_;

@Generated(value="Dali", date="2014-12-15T12:41:58.150+0100")
@StaticMetamodel(AdressEntity.class)
public class AdressEntity_ extends BaseEntity_ {
	public static volatile SingularAttribute<AdressEntity, String> city;
	public static volatile SingularAttribute<AdressEntity, String> postCode;
	public static volatile SingularAttribute<AdressEntity, String> street;
	public static volatile SingularAttribute<AdressEntity, String> number;
}
