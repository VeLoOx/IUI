package pl.iui.dao.user.implementation;

import pl.iui.commons.dao.GenericJpaDao;
import pl.iui.dao.user.UserDataDao;
import pl.iui.domain.user.UserDataEntity;

public class UserDataJpaDao extends GenericJpaDao<UserDataEntity, Long> implements UserDataDao {

    public UserDataJpaDao() {
            super(UserDataEntity.class);
    }

}
