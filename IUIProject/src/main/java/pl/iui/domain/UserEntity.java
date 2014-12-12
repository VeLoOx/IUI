package pl.iui.domain;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;

import pl.iui.commons.domain.BaseEntity;


/**
 * Entity to hold application user data - first name, last name, etc.
 *
 */
@Entity
@Table(name="appUser")
public class UserEntity extends BaseEntity {
        private static final long serialVersionUID = -8789920463809744548L;

        private String firstName;
        private String lastName;
        private String userName;
        private String password;
        
        @OneToOne  
        @JoinColumn(name="id")  
        private UserDataEntity userData;
       
        public String getFirstName() {
                return firstName;
        }
       
        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }
       
        public String getLastName() {
                return lastName;
        }
       
        public void setLastName(String lastName) {
                this.lastName = lastName;
        }
       
        public String getUserName() {
                return userName;
        }
       
        public void setUserName(String userName) {
                this.userName = userName;
        }
       
        public String getPassword() {
                return password;
        }
       
        public void setPassword(String password) {
                PasswordEncoder crypto = new Md5PasswordEncoder();
                this.password = crypto.encodePassword(password, null);
        }
        
//        @OneToOne(fetch = FetchType.LAZY, mappedBy = "userEntity", cascade = CascadeType.ALL)
		public UserDataEntity getUserData() {
			return userData;
		}

		public void setUserData(UserDataEntity userData) {
			this.userData = userData;
		}
       
}
