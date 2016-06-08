package com.mindtree.bug.tracker.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.mindtree.bug.tracker.dao.GenieDao;
import com.mindtree.bug.tracker.entity.Genie;
import com.mindtree.bug.tracker.entity.User;
import com.mindtree.bug.tracker.exception.DatabaseException;

/**
 * @author M1035940
 *
 */
@Repository
public class GenieDaoimpl implements GenieDao {

	/**
	 * 
	 */
	private SessionFactory sessionFactory;

	/**
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.bug.tracker.dao.GenieDao#saveGenie(com.mindtree.bug.tracker.
	 * entity.Genie)
	 */
	public boolean saveGenie(Genie genieForm) throws DatabaseException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.save(genieForm);
			return true;
		} catch (HibernateException hibernateException) {
			System.out.println("exception" + hibernateException);
			throw new DatabaseException(hibernateException.getCause());
		} finally {
			if (session != null)
				session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.bug.tracker.dao.GenieDao#getAllAssignedGenie(java.lang.
	 * String)
	 */
	public List<Genie> getAllAssignedGenie(String username) throws DatabaseException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session
					.createQuery("from Genie g where g.assignedTo.username= :username and g.status = true");

			query.setParameter("username", username);
			@SuppressWarnings("unchecked")
			List<Genie> list = query.list();
			return list;
		} catch (HibernateException hibernateException) {
			System.out.println("exception" + hibernateException);
			throw new DatabaseException(hibernateException.getCause());
		} finally {
			if (session != null)
				session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.bug.tracker.dao.GenieDao#changeGenieStatus(java.lang.String)
	 */
	public boolean changeGenieStatus(String slno) throws DatabaseException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Genie genie = (Genie) session.get(Genie.class, Integer.parseInt(slno));
			genie.setStatus(false);
			return true;
		} catch (HibernateException hibernateException) {
			if (session != null && session.getTransaction() != null)
				session.getTransaction().rollback();
			System.out.println("exception" + hibernateException);
			throw new DatabaseException(hibernateException.getCause());
		} finally {
			if (session != null)
				session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.bug.tracker.dao.GenieDao#getAllGenie()
	 */
	public List<Genie> getAllGenie() throws DatabaseException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from Genie g where g.assignedTo = null");
			@SuppressWarnings("unchecked")
			List<Genie> list = query.list();
			return list;
		} catch (HibernateException hibernateException) {
			System.out.println("exception" + hibernateException);
			throw new DatabaseException(hibernateException.getCause());
		} finally {
			if (session != null)
				session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mindtree.bug.tracker.dao.GenieDao#getAllAssociate()
	 */
	public List<User> getAllAssociate() throws DatabaseException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery("from UserRoles u where u.role='ROLE_ASSOCIATE'");
			@SuppressWarnings("unchecked")
			List<User> list = query.list();
			return list;
		} catch (HibernateException hibernateException) {
			System.out.println("exception" + hibernateException);
			throw new DatabaseException(hibernateException.getCause());
		} finally {
			if (session != null)
				session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mindtree.bug.tracker.dao.GenieDao#assignAssociate(java.lang.String,
	 * java.lang.String)
	 */
	public String assignAssociate(int slno, String associateName) throws DatabaseException {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Genie genie = (Genie) session.get(Genie.class, slno);
			User user = new User();
			user.setUsername(associateName);
			genie.setAssignedTo(user);
			return "success";
		} catch (HibernateException hibernateException) {
			if (session != null && session.getTransaction() != null)
				session.getTransaction().rollback();
			System.out.println("exception" + hibernateException);
			throw new DatabaseException(hibernateException.getCause());
		} finally {
			if (session != null)
				session.close();
		}
	}
}
