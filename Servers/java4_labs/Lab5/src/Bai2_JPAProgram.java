import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.User;

public class Bai2_JPAProgram {
	public static void main(String[] args) {
		create();
		update();
//		remove();
//		findAll();
//		findByRole(true);
//		findKeyword("Nguyen");
//		findOne("PS01", "123456");
//		findPage(3, 5);
	}

	private static void create() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Lab5");
		EntityManager em = factory.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			User user = new User();
			user.setId("PS01");
			user.setEmail("poly1@gmail.com");
			user.setFullname("Nguyen Superman");
			user.setPassword("123456");
			em.persist(user);
			System.out.println("Insert Success!!");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
			factory.close();
		}
	}

	private static void update() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Lab5");
		EntityManager em = factory.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			User user = em.find(User.class, "PS01");
			user.setPassword("123456");
			user.setAdmin(true);
			em.merge(user);
			System.out.println("Update Success!!");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
			factory.close();
		}
	}

	private static void remove() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Lab5");
		EntityManager em = factory.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			User user = em.find(User.class, "PS01");
			em.remove(user);
			System.out.println("Remove Success!!");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
			factory.close();
		}
	}

	private static void findAll() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Lab5");
		EntityManager em = factory.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			String jpql = "SELECT u FROM User u";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			List<User> list = query.getResultList();
			for (User user : list) {
				System.out.println("Fullname: " + user.getFullname());
				System.out.println("Is Admin: " + (user.getAdmin() ? "Yes" : "No"));
			}
			System.out.println("findAll Success!!");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
			factory.close();
		}
	}

	private static void findByRole(boolean role) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Lab5");
		EntityManager em = factory.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			String jpql = "SELECT u FROM User u WHERE u.admin=:role";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("role", role);
			List<User> list = query.getResultList();
			for (User user : list) {
				System.out.println("Fullname: " + user.getFullname());
				System.out.println("Is Admin: " + (user.getAdmin() ? "Yes" : "No"));
			}
			System.out.println("findByRole Success!!");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
			factory.close();
		}
	}

	private static void findKeyword(String keyword) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Lab5");
		EntityManager em = factory.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			String jpql = "SELECT u FROM User u WHERE u.fullname LIKE ?0";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter(0, keyword);
			List<User> list = query.getResultList();
			for (User user : list) {
				System.out.println("Fullname: " + user.getFullname());
				System.out.println("Is Admin: " + (user.getAdmin() ? "Yes" : "No"));
			}
			System.out.println("findKeyword Success!!");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
			factory.close();
		}
	}

	private static void findOne(String username, String password) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Lab5");
		EntityManager em = factory.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			String jpql = "SELECT u FROM User u WHERE u.id=:id AND u.password=:password";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("id", username);
			query.setParameter("password", password);
			List<User> list = query.getResultList();
			for (User user : list) {
				System.out.println("Fullname: " + user.getFullname());
				System.out.println("Is Admin: " + (user.getAdmin() ? "Yes" : "No"));
			}
			System.out.println("findOne Success!!");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
			factory.close();
		}
	}

	private static void findPage(int page, int size) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Lab5");
		EntityManager em = factory.createEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			String jpql = "SELECT u FROM User u";
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setFirstResult(page * size);
			query.setMaxResults(size);
			List<User> list = query.getResultList();
			for (User user : list) {
				System.out.println("Fullname: " + user.getFullname());
				System.out.println("Is Admin: " + (user.getAdmin() ? "Yes" : "No"));
			}
			System.out.println("findPage Success!!");
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
			factory.close();
		}
	}
}
