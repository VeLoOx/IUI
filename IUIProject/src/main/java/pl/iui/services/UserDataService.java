package pl.iui.services;

import pl.iui.domain.UserDataEntity;

public interface UserDataService {

	/**
     * Create user data- persist to database
     *
     * @param userDataEntity
     * @return true if success
     */
    boolean createUserData(UserDataEntity userDataEntity);
}
