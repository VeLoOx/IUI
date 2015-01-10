package pl.iui.dao.user.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.util.Assert;

import pl.iui.commons.dao.GenericJpaDao;
import pl.iui.dao.user.UserDao;
import pl.iui.domain.topic.TopicEntity;
import pl.iui.domain.user.UserEntity;

/**
 * Data access object JPA impl to work with User entity database operations.
 *
 */
public class UserJpaDao extends GenericJpaDao<UserEntity, Long> implements UserDao {

        public UserJpaDao() {
                super(UserEntity.class);
        }

        /**
         * Queries database for user name availability
         *
         * @param userName
         * @return true if available
         */
        public boolean checkAvailable(String userName) {
                Assert.notNull(userName);
               
                Query query = getEntityManager()
                        .createQuery("select count(*) from " + getPersistentClass().getSimpleName()
                                        + " u where u.userName = :userName").setParameter("userName", userName);
               
                Long count = (Long) query.getSingleResult();
               
                return count < 1;
        }

        /**
         * Queries user by username
         *
         * @param userName
         * @return User entity
         */
        public UserEntity loadUserByUserName(String userName) {
        	
                Assert.notNull(userName);
               
                UserEntity user = null;
               
                Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
                                + " u where u.userName = :userName").setParameter("userName", userName);
               
                try {
                        user = (UserEntity) query.getSingleResult();
                } catch(NoResultException e) {
                        //do nothing
                }
               
                return user;
        }

		@Override
		public List<UserEntity> findLastUsers(int n) {
			// TODO Auto-generated method stub
			Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
	                + " u order by u.id DESC");
			 
			 List<UserEntity> lista = new ArrayList<UserEntity>();
			 try {
	            lista = (List<UserEntity>) query.getResultList();
	    } catch(NoResultException e) {
	            //do nothing
	    }
			
			// TODO Auto-generated method stub
			 
			 if(lista.size()>n) return lista.subList(0, n); else return lista;
		}
		
		public List<UserEntity> findFavoriteUsers(UserEntity user){
			
			Query query2 = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
	                + " u where u.id IN :ids")
	                .setParameter("ids", user.getUserData().getFavoriteUsers());
			
			 List<UserEntity> lista = new ArrayList<UserEntity>();
			 if(!user.getUserData().getFavoriteUsers().isEmpty()){
				 
				 lista = (List<UserEntity>) query2.getResultList();
				 
			 }
			 
			 return lista;
		}
		
		public List<UserEntity> findByString(String text){
			
			Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
	                + " u where u.userName LIKE CONCAT('%', :txt, '%') OR u.userData.adress.city LIKE :txt").setParameter("txt", text);
			
			 List<UserEntity> lista = new ArrayList<UserEntity>();
			 try {
	            lista = (List<UserEntity>) query.getResultList();
	    } catch(NoResultException e) {
	            //do nothing
	    }
			 
			 return lista;
		}

}

