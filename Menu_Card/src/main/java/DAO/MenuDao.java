package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import DTO.Menu;
import DTO.User;

public class MenuDao {
	
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
	EntityManager manager=factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void insertDish(String dish,String quantity,String price) {
		
		Menu menu=new Menu();
		
		menu.setDish(dish);
		menu.setQuantity_in_kg(quantity);
		menu.setPrice_per_kg(price);
		
		transaction.begin();
		manager.persist(menu);
		transaction.commit();
	}
	
	public List<Menu> getMenu() {
		Query q=manager.createQuery("select m from Menu m",Menu.class);
		return q.getResultList();
	}
	
	public Menu getDishById(int id) {
		return manager.find(Menu.class, id);
	}
	
	public Menu getDishByName(String dish) {
		Query q=manager.createQuery("select m from Menu m where m.dish=?1", Menu.class);
		q.setParameter(1,dish);
		return (Menu)q.getSingleResult();
	}
	
	
	public void deleteDishById(int id) {	
		Menu menu=getDishById(id);	
		if(menu!=null) {
	            transaction.begin();
	            manager.remove(menu);
	            transaction.commit();
			}else {
				System.out.println("Dish doesn't exist !");
			}
	}
	
	public void updateDish(int id,int quantity) {
		
		Menu menu=getDishById(id);
		
		if(menu!=null) {
			transaction.begin();
			menu.setQuantity_in_kg(String.valueOf(quantity));
			manager.merge(menu);
	        transaction.commit();
		}
	}

}
