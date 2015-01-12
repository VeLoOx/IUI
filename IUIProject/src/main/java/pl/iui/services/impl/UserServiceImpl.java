package pl.iui.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.inputtext.InputText;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;















import pl.iui.dao.user.UserDao;
import pl.iui.dao.user.UserDataDao;
import pl.iui.domain.topic.TopicEntity;
import pl.iui.domain.user.AdressEntity;
import pl.iui.domain.user.UserDataEntity;
import pl.iui.domain.user.UserEntity;
import pl.iui.services.UserService;

public class UserServiceImpl implements UserService, UserDetailsService {

    private UserDao userDao;
    private UserDataDao dataDao;
    private UserEntity selectedUser;
   
    /**
     * Create user - persist to database
     *
     * @param userEntity
     * @return true if success
     */
    public boolean createUser(UserEntity userEntity) {
           
            if (!userDao.checkAvailable(userEntity.getUserName())) {
                    FacesMessage message = constructErrorMessage(String.format(getMessageBundle().getString("userExistsMsg"), userEntity.getUserName()), null);
                    getFacesContext().addMessage(null, message);
                   
                    return false;
            }
           
            try {
            		AdressEntity adress = new AdressEntity();
            		UserDataEntity data = new UserDataEntity();
            		data.setAdress(adress);
            		
            		userEntity.setUserData(data);
                    userDao.save(userEntity);
            } catch(Exception e) {
                    FacesMessage message = constructFatalMessage(e.getMessage(), null);
                    getFacesContext().addMessage(null, message);
                   
                    return false;
            }
           
            return true;
    }
    
    
    public boolean updateUserData (UserEntity userEntity, UserDataEntity udataEntity){
    	
    	 
    
     try {
    	 userEntity.getUserData().setAdress(udataEntity.getAdress());
    	 userEntity.getUserData().setHobbies(udataEntity.getHobbies());
    	 userEntity.getUserData().setSex(udataEntity.getSex());
    	 userEntity.getUserData().setYearOfBirth(udataEntity.getYearOfBirth());
    	 	//userEntity.setUserData(udataEntity);
           userDao.update(userEntity);
    	 //dataDao.update(udataEntity);
     } catch(Exception e) {
             FacesMessage message = constructFatalMessage(e.getMessage(), null);
             getFacesContext().addMessage(null, message);
            
             return false;
     }
    	
    	return true;
    }
    
    public boolean updateUserData (UserDataEntity userDataEntity){
        try {
       	 		System.out.println("Uaktualniam");
               // userDao.update(userEntity);
       	 		dataDao.update(userDataEntity);
        } catch(Exception e) {
                FacesMessage message = constructFatalMessage(e.getMessage(), null);
                getFacesContext().addMessage(null, message);
               
                return false;
        }
       	
       	return true;
       }
    
   
    /**
     * Check user name availability. UI ajax use.
     *
     * @param ajax event
     * @return
     */
    public boolean checkAvailable(AjaxBehaviorEvent event) {
           
            InputText inputText = (InputText) event.getSource();
            String value = (String) inputText.getValue();
           
            boolean available = userDao.checkAvailable(value);
           
            if (!available) {
                    FacesMessage message = constructErrorMessage(null, String.format(getMessageBundle().getString("userExistsMsg"), value));
                    getFacesContext().addMessage(event.getComponent().getClientId(), message);
            } else {
                    FacesMessage message = constructInfoMessage(null, String.format(getMessageBundle().getString("userAvailableMsg"), value));
                    getFacesContext().addMessage(event.getComponent().getClientId(), message);
            }
           
            return available;
    }

    /**
     * Construct UserDetails instance required by spring security
     */
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
           
            UserEntity user = userDao.loadUserByUserName(userName);
           
            if (user == null) {
                    throw new UsernameNotFoundException(String.format(getMessageBundle().getString("badCredentials"), userName));
            }
           
            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
           
            User userDetails = new User(user.getUserName(), user.getPassword(), authorities);
           
            return userDetails;
    }
   
    /**
     * Retrieves full User record from database by user name
     *
     * @param userName
     * @return UserEntity
     */
    public UserEntity loadUserEntityByUsername(String userName) {
            return userDao.loadUserByUserName(userName);
    }

    protected FacesMessage constructErrorMessage(String message, String detail){
            return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, detail);
    }
   
    protected FacesMessage constructInfoMessage(String message, String detail) {
            return new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
    }
   
    protected FacesMessage constructFatalMessage(String message, String detail) {
            return new FacesMessage(FacesMessage.SEVERITY_FATAL, message, detail);
    }
   
    protected FacesContext getFacesContext() {
            return FacesContext.getCurrentInstance();
    }
   
    protected ResourceBundle getMessageBundle() {
            return ResourceBundle.getBundle("message-labels");
    }

    public UserDao getUserDao() {
            return userDao;
    }

    public void setUserDao(UserDao userDao) {
            this.userDao = userDao;
    }


	@Override
	public void addRatedTopic(long id, UserEntity ue) {
		// TODO Auto-generated method stub
		
		ue.getUserData().getRatedTopics().add(id);
		
		//ue.getUserData().getHobbies().clear();
		userDao.update(ue);
		
	}
	
	public void addFavoriteTopic(long id, UserEntity ue) {
		// TODO Auto-generated method stub
		
		ue.getUserData().getFavoriteTopics().add(id);
		
		//ue.getUserData().getHobbies().clear();
		userDao.update(ue);
		
	}
	
	public void addFavoriteUser(long id, UserEntity ue) {
		// TODO Auto-generated method stub
		
		ue.getUserData().getFavoriteUsers().add(id);
		
		//ue.getUserData().getHobbies().clear();
		userDao.update(ue);
		
	}


	@Override
	public boolean allowToRate(TopicEntity top, UserEntity ue) {
		// TODO Auto-generated method stub
		System.out.println("ID!!!!!! = "+top.getId());
		if(ue.getUserData().getRatedTopics().contains(top.getId()))
		return false; else return true;
	}
	
	public boolean allowToFavoriteTopic(TopicEntity top, UserEntity ue) {
		// TODO Auto-generated method stub
		System.out.println("ID!!!!!! = "+top.getId());
		if(ue.getUserData().getFavoriteTopics().contains(top.getId()))
		return false; else return true;
	}
	
	public boolean allowToFavoriteUser(UserEntity fav, UserEntity ue) {
		// TODO Auto-generated method stub
		System.out.println("ID!!!!!! = "+fav.getId());
		if(ue.getUserData().getFavoriteUsers().contains(fav.getId()))
		return false; else return true;
	}


	public UserEntity getSelectedUser() {
		return selectedUser;
	}


	public void setSelectedUser(UserEntity selectedUser) {
		this.selectedUser = selectedUser;
	}


	@Override
	public List<UserEntity> getLastUsers(int n) {
		// TODO Auto-generated method stub
		return userDao.findLastUsers(n);
	}
	
	public List<UserEntity> getFavoriteUsers(UserEntity u) {
		// TODO Auto-generated method stub
		return userDao.findFavoriteUsers(u);
	}
	
	public List<UserEntity> getUserSearch(String text){
		return userDao.findByString(text);
	}


	public UserDataDao getDataDao() {
		return dataDao;
	}


	public void setDataDao(UserDataDao dataDao) {
		this.dataDao = dataDao;
	}

}

