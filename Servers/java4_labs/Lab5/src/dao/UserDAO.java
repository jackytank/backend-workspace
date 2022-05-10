package dao;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;
import utils.JpaUtils;

public class UserDAO {
	EntityManager em = JpaUtils.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
	}

	public void insert(User user) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw new RuntimeException(e);
		}

	}

	public void update(User user) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw new RuntimeException(e);
		}
	}

	public void remove(String id) {
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			User user = this.findByID(id);
			if (user != null) {
				em.remove(user);
			} else {
				throw new Exception("Can't find User");
			}

			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw new RuntimeException(e);
		}
	}

	public User findByID(String id) {
		User user = em.find(User.class, id);
		return user;
	}

	public List<User> findAll() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
}
