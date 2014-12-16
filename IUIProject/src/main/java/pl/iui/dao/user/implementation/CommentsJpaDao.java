package pl.iui.dao.user.implementation;

import pl.iui.commons.dao.GenericJpaDao;
import pl.iui.dao.user.CommentsDao;
import pl.iui.domain.user.CommentsEntity;

public class CommentsJpaDao extends GenericJpaDao<CommentsEntity,Long> implements CommentsDao {
	public CommentsJpaDao(){
		super(CommentsEntity.class);
	}
}
