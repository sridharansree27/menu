package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import DAO.MenuDao;
import DTO.Menu;
import DTO.User;

@WebServlet("/dish")
public class Get_Dish extends HttpServlet {
	
	static boolean outOfStock=true;
	static List<String> orders=new ArrayList<String>();
	static long totalPrice=0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		int quantity_ordered=Integer.parseInt(req.getParameter("quantity"));
		
		
		MenuDao dao=new MenuDao();
		Menu menu=dao.getDishById(id);
				
		if(menu!=null) {
			String dish=menu.getDish();
			int quantity_actual=Integer.parseInt(menu.getQuantity_in_kg());
			int price=Integer.parseInt(menu.getPrice_per_kg());
			outOfStock=false;
			boolean isPrevious=false;
			if(quantity_ordered<=quantity_actual) {
				if(orders.isEmpty()) {
					orders.add(String.valueOf(id));
			        orders.add(dish);
			        orders.add(String.valueOf(quantity_ordered));
		        	orders.add(String.valueOf(quantity_ordered*price));
		        	totalPrice=totalPrice+quantity_ordered*price;
		        	}else {
				        for(String order:orders) {	
					        if(dish.equals(order)) {
						        isPrevious=true;
					        	orders.set(orders.indexOf(order)+1, String.valueOf(Integer.parseInt(orders.get(orders.indexOf(order)+1)) + quantity_ordered ));
					        	orders.set(orders.indexOf(order)+2, String.valueOf(Integer.parseInt(orders.get(orders.indexOf(order)+2)) + quantity_ordered*price) );
					        	totalPrice=totalPrice+quantity_ordered*price;
					        	break;
					        	}
					        }		        
				        if(!isPrevious) {
				        orders.add(String.valueOf(id));
					    orders.add(dish);
				    	orders.add(String.valueOf(quantity_ordered));
					    orders.add(String.valueOf(quantity_ordered*price));
					    totalPrice=totalPrice+quantity_ordered*price;
					    if(quantity_actual-quantity_ordered == 0) {
							dao.deleteDishById(id);
							req.getRequestDispatcher("menu").forward(req, resp);
					    	}else {
					    		dao.updateDish(id, quantity_actual-quantity_ordered);
					    		req.getRequestDispatcher("menu").forward(req, resp);
					    		}
				    	}
				        }
				if(quantity_actual-quantity_ordered == 0) {
					dao.deleteDishById(id);
					req.getRequestDispatcher("menu").forward(req, resp);
			    	}else {
			    		dao.updateDish(id, quantity_actual-quantity_ordered);
			    		req.getRequestDispatcher("menu").forward(req, resp);
			    		}
				
		}else {
			req.getRequestDispatcher("menu").forward(req, resp);
		}
	}else {
		req.getRequestDispatcher("menu").forward(req, resp);
	}
}
}
