package pl.iui.dao;

import pl.iui.commons.dao.GenericJpaDao;
import pl.iui.domain.UserDataEntity;

public class UserDataJpaDao extends GenericJpaDao<UserDataEntity, Long> implements UserDataDao {

    public UserDataJpaDao() {
            super(UserDataEntity.class);
    }

}
