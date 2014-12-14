package pl.iui.services.impl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import pl.iui.dao.UserDataDao;
import pl.iui.domain.UserDataEntity;
import pl.iui.services.UserDataService;

public class UserDataServiceImpl implements UserDataService {

	private UserDataDao userDataDao;
	
	/**
     * Create user data- persist to database
     *
     * @param userDataEntity
     * @return true if success
     */
	public boolean createUserData(UserDataEntity userDataEntity) {
		try {
            userDataDao.save(userDataEntity);
    } catch(Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, e.getMessage(), null);
            FacesContext.getCurrentInstance().addMessage(null, message);
           
            return false;
    }
   
    return true;
	}

	public UserDataDao getUserDataDao() {
		return userDataDao;
	}

	public void setUserDataDao(UserDataDao userDataDao) {
		this.userDataDao = userDataDao;
	}

	
}
