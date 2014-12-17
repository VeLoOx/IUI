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
}
