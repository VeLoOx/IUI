package pl.iui.services.impl;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class FacesMessagesProvider {

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
