package pl.iui.dao;

import pl.iui.commons.dao.GenericDao;
import pl.iui.domain.UserEntity;



/**
 * Data access object interface to work with User entity database operations.
 *
 */
public interface UserDao extends GenericDao<UserEntity, Long> {

        /**
         * Queries database for user name availability
         *
         * @param userName
         * @return true if available
         */
        boolean checkAvailable(String userName);
       
        /**
         * Queries user by username
         *
         * @param userName
         * @return User entity
         */
        UserEntity loadUserByUserName(String userName);
}

