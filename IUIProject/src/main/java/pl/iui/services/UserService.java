package pl.iui.services;
import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import pl.iui.domain.topic.TopicEntity;
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
    public boolean allowToRate(TopicEntity top, UserEntity ue);
    public List<UserEntity> getLastUsers(int n);
    public void addFavoriteUser(long id, UserEntity ue);
    public void addFavoriteTopic(long id, UserEntity ue);
    public boolean allowToFavoriteTopic(TopicEntity top, UserEntity ue);
    public boolean allowToFavoriteUser(UserEntity fav, UserEntity ue);
    	
}

