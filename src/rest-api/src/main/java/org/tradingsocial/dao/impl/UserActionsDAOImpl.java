package org.tradingsocial.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.tradingsocial.dao.AbstractDAO;
import org.tradingsocial.dao.UserActionsDAO;
import org.tradingsocial.model.UserActions;

public class UserActionsDAOImpl extends AbstractDAO implements UserActionsDAO {

	public UserActions getUserActionsById(int id) {
		return (UserActions) getSession().get(UserActions.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<UserActions> getUserActionsBySourceUserId(int sourceUserId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserActions.class).add(Restrictions.eq("sourceUserId", sourceUserId));
		return (List<UserActions>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public List<UserActions> getUserTweetsbyStockId(int targetStockId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserActions.class).add(Restrictions.eq("targetStockId", targetStockId));
		return (List<UserActions>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public List<UserActions> getUserActionsBy(int targetStockId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserActions.class).add(Restrictions.eq("targetStockId", targetStockId));
		return (List<UserActions>) getHibernateTemplate().findByCriteria(criteria);
	}

	public void saveOrUpdate(UserActions userActions) {
		getSession().saveOrUpdate(userActions);
	}

	public void delete(int id) {
		UserActions userActionToDelete = new UserActions();
		userActionToDelete.setId(id);
		getSession().delete(userActionToDelete);

	}

	@SuppressWarnings("unchecked")
	public List<UserActions> getAllUserActions() {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserActions.class);
		return (List<UserActions>) getHibernateTemplate().findByCriteria(criteria);
	/*	@SuppressWarnings("unchecked")
		List<UserActions> listUser = (List<UserActions>) getSession().createCriteria(UserActions.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUse;r*/
	}

}
