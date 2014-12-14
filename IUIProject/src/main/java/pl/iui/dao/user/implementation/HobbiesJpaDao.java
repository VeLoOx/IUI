package pl.iui.dao.user.implementation;

import pl.iui.commons.dao.GenericJpaDao;
import pl.iui.dao.user.HobbiesDao;
import pl.iui.domain.user.HobbiesEntity;

public class HobbiesJpaDao extends GenericJpaDao<HobbiesEntity, Long> implements HobbiesDao {
	public HobbiesJpaDao(){
		super(HobbiesEntity.class);
	}
}
