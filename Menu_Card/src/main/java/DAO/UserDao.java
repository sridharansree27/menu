package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import DTO.User;

public class UserDao {
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void insertUser(User user) {
		transaction.begin();
		manager.persist(user);
		transaction.commit();
	}

	public User getUserById(int id) {
		return manager.find(User.class, id);
	}
	
	public User getUserByName(String user) {
		Query q=manager.createQuery("select u from User u where u.name=?1", User.class);
		q.setParameter(1,user);
		return (User)q.getSingleResult();
	}
	
	public User getUserByEmail(String user) {
		Query q=manager.createQuery("select u from User u where u.email=?1", User.class);
		q.setParameter(1,user);
		return (User)q.getSingleResult();
	}
	
	public User getUserByEmailAndPassword(String email,String pass){
        Query q=manager.createQuery("select u from User u where u.email=?1 and u.password=?2",User.class);
        q.setParameter(1,email);
        q.setParameter(2,pass);
        try {
        	return (User)q.getSingleResult();
        }catch(NoResultException e) {
        	return null;
        }
	}

	public List<User> getUsers(){
        Query q=manager.createQuery("select u from User u",User.class);
        return q.getResultList();
	}
	
	public void updateUser(User user) {
		transaction.begin();
        manager.merge(user);
        transaction.commit();
	}

	public void deleteUserById(int id) {	
		User user=getUserById(id);	
		if(user!=null) {
	            transaction.begin();
	            manager.remove(user);
	            transaction.commit();
			}else {
				System.out.println("Id doesn't exist!");
			}
	}
	
}
