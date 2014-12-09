package pl.iui.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;






import pl.iui.dao.UserDao;
import pl.iui.domain.UserEntity;
import pl.iui.services.UserService;

public class UserServiceImpl implements UserService, UserDetailsService {

	private UserDao userDao;

	/**
	 * Create user - persist to database
	 *
	 * @param userEntity
	 * @return true if success
	 */
	public boolean createUser(UserEntity userEntity) {
		if (!userDao.checkAvailable(userEntity.getUserName())) {
            FacesMessage message = constructErrorMessage(String.format("User name '%s' is not available", userEntity.getUserName()), null);
            getFacesContext().addMessage(null, message);
           
            return false;
    }
   
    try {
            userDao.save(userEntity);
    } catch(Exception e) {
            FacesMessage message = constructFatalMessage(e.getMessage(), null);
            getFacesContext().addMessage(null, message);
           
            return false;
    }
   
    return true;


	}
	
	/**
     * Construct UserDetails instance required by spring security
     */

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserEntity user = userDao.loadUserByUserName(userName);
        
        if (user == null) {
                throw new UsernameNotFoundException(String.format("No such user with name provided '%s'", userName));
        }
       
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
       
        User userDetails = new User(user.getUserName(), user.getPassword(), authorities);
       
        return userDetails;

	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean checkAvailable(AjaxBehaviorEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserEntity loadUserEntityByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
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


	

}
