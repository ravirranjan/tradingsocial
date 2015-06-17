package org.tradingsocial.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.tradingsocial.dao.AbstractDAO;
import org.tradingsocial.dao.UserDAO;
import org.tradingsocial.model.User;

@Repository
public class UserDAOImpl extends AbstractDAO implements UserDAO {

	public User getUser(int id) {
		return (User) getSession().get(User.class, id);
	}
	
	public User getUserByEmail(String emailAddress) {
		return (User) getSession().createQuery("from User user where user.emailAddress=?").setParameter(0, emailAddress);
	}

	@Transactional
	public void saveOrUpdate(User user) {
		getSession().saveOrUpdate(user);
	}

    @Transactional
	public void delete(int id) {
		// TODO Auto-generated method stub
		User userToDelete = new User();
        userToDelete.setId(id);
        getSession().delete(userToDelete);
	}

	public List<User> getAllUser() {
        @SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) getSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
	}

	public User loginAsUser(String emailAddress, String password) {
		return (User) getSession().createCriteria(User.class)
				.add(Restrictions.eq("emailAddress", emailAddress))
				.add(Restrictions.eq("password", password)).uniqueResult();
	}

}
