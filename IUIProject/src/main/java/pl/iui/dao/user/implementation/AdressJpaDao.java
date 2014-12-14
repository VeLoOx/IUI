package pl.iui.dao.user.implementation;

import pl.iui.commons.dao.GenericJpaDao;
import pl.iui.dao.user.AdressDao;
import pl.iui.domain.user.AdressEntity;

public class AdressJpaDao extends GenericJpaDao<AdressEntity, Long> implements AdressDao {

	public AdressJpaDao() {
		super(AdressEntity.class);
		// TODO Auto-generated constructor stub
	}

}
