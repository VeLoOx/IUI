package pl.iui.services;
import javax.faces.event.AjaxBehaviorEvent;

import pl.iui.domain.user.UserDataEntity;
import pl.iui.domain.user.UserEntity;



/**
 * Service providing service methods to work with user data and entity.
 *
 */
public interface UserService {

    /**
     * Create user - persist to database
     *
     * @param userEntity
     * @return true if success
     */
    boolean createUser(UserEntity userEntity);
   
    /**
     * Check user name availability. UI ajax use.
     *
     * @param ajax event
     * @return
     */
    boolean checkAvailable(AjaxBehaviorEvent event);
    
    boolean updateUserData (UserEntity userEntity, UserDataEntity udataEntity);
   
    /**
     * Retrieves full User record from database by user name
     *
     * @param userName
     * @return UserEntity
     */
    UserEntity loadUserEntityByUsername(String userName);
    
    public void addRatedTopic(long id, UserEntity ue);
    	
}

