package pl.iui.domain.user;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2014-12-16T21:03:34.951+0100")
@StaticMetamodel(AdressEntity.class)
public class AdressEntity_ {
	public static volatile SingularAttribute<AdressEntity, Long> id;
	public static volatile SingularAttribute<AdressEntity, String> city;
	public static volatile SingularAttribute<AdressEntity, String> postCode;
	public static volatile SingularAttribute<AdressEntity, String> street;
	public static volatile SingularAttribute<AdressEntity, String> numberPos;
	public static volatile SingularAttribute<AdressEntity, String> coordinate;
}
