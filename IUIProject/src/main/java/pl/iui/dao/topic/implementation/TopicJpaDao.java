package pl.iui.dao.topic.implementation;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import pl.iui.commons.dao.GenericJpaDao;
import pl.iui.dao.topic.TopicDao;
import pl.iui.domain.topic.TopicEntity;
import pl.iui.domain.user.UserEntity;

public class TopicJpaDao extends GenericJpaDao<TopicEntity, Long> implements TopicDao {

	public TopicJpaDao(){
		super(TopicEntity.class);
	}

	@Override
	public List<TopicEntity> findUserTopic(String name) {
		
		
		 Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
                 + " u where u.autor = :userName").setParameter("userName", name);
		 
		 List<TopicEntity> lista = new ArrayList<TopicEntity>();
		 try {
             lista = (List<TopicEntity>) query.getResultList();
     } catch(NoResultException e) {
             //do nothing
     }
		
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public List<TopicEntity> findLastTopics(int n) {
		// TODO Auto-generated method stub
		
		
		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
                + " u order by u.id DESC");
		 
		 List<TopicEntity> lista = new ArrayList<TopicEntity>();
		 try {
            lista = (List<TopicEntity>) query.getResultList();
    } catch(NoResultException e) {
            //do nothing
    }
		
		// TODO Auto-generated method stub
		 if(n<lista.size())
		return lista.subList(0, n); else return lista;
	}
	
	public List<TopicEntity> findTopicForUser(UserEntity user){
	    Query query=null;
		if(user.getUserData().getHobbies().isEmpty()){
		
		  query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
                 + " u where u.category = :cat AND u.adress.city = :cit")
                 .setParameter("cat","Inne")
                 .setParameter("cit", user.getUserData().getAdress().getCity());
		} else {
			query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
	                 + " u where u.category IN :cat AND u.adress.city = :cit")
	                 .setParameter("cat",user.getUserData().getHobbies())
	                 .setParameter("cit", user.getUserData().getAdress().getCity());
		}
		 
		Query query2 = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
                + " u where u.id IN :ids")
                .setParameter("ids", user.getUserData().getRatedTopics());
		 
		 
		 List<TopicEntity> lista = new ArrayList<TopicEntity>();
		 try {
            lista = (List<TopicEntity>) query.getResultList();
            if(!user.getUserData().getRatedTopics().isEmpty())
            lista.removeAll(query2.getResultList());
            
    } catch(NoResultException e) {
            //do nothing
    }
		 return lista;
	}
	
	public List<TopicEntity> findMostPopularTopic(int n){
		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
                + " u order by u.numberRate DESC");
		 
		 List<TopicEntity> lista = new ArrayList<TopicEntity>();
		 try {
            lista = (List<TopicEntity>) query.getResultList();
    } catch(NoResultException e) {
            //do nothing
    }
		
		// TODO Auto-generated method stub
		 if(n<lista.size())
		return lista.subList(0, n); else return lista;
	}
	
	public List<TopicEntity> findByString(String text){
		
		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
                + " u where u.name LIKE CONCAT('%', :txt, '%') OR u.adress.city LIKE :txt").setParameter("txt", text);
		
		 List<TopicEntity> lista = new ArrayList<TopicEntity>();
		 try {
            lista = (List<TopicEntity>) query.getResultList();
    } catch(NoResultException e) {
            //do nothing
    }
		 
		 return lista;
	}
	
	
}
