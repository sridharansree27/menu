package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MenuDao;
import DTO.Menu;

@WebServlet("/DeleteOrder")
public class Delete_Order extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		String quantity_cancel=req.getParameter("quantity");
		String dish=Get_Dish.orders.get(Get_Dish.orders.indexOf(id)+1);
		
		int totalQuantity=0;
		boolean isPresent=false;
		
		MenuDao dao=new MenuDao();
		
		for(String order:Get_Dish.orders) {	
	        if(id.equals(order)) {
	        	if(Integer.parseInt(quantity_cancel)<=Integer.parseInt(Get_Dish.orders.get(Get_Dish.orders.indexOf(id)+2))) {
	        		totalQuantity=Integer.parseInt(Get_Dish.orders.get(Get_Dish.orders.indexOf(id)+2));
	        		
	        		if(Integer.parseInt(Get_Dish.orders.get(Get_Dish.orders.indexOf(id)+2))-Integer.parseInt(quantity_cancel)==0) {
	        			long totalPrice=Long.parseLong(Get_Dish.orders.get(Get_Dish.orders.indexOf(id)+3));
	        			
	        			Get_Dish.orders.remove(Get_Dish.orders.indexOf(id)+1);
	        			Get_Dish.orders.remove(Get_Dish.orders.indexOf(id)+1);
	        			Get_Dish.orders.remove(Get_Dish.orders.indexOf(id)+1);
	        			Get_Dish.orders.remove(Get_Dish.orders.indexOf(id));
	        			
	        			Menu menu=dao.getDishById(Integer.parseInt(id));
	        				        				        				        			
	        			if(menu!=null) {
	        				isPresent=true;
	        				Get_Dish.totalPrice=Get_Dish.totalPrice-(Integer.parseInt(quantity_cancel)*Integer.parseInt(menu.getPrice_per_kg()));
	        				dao.updateDish(Integer.parseInt(id), Integer.parseInt(menu.getQuantity_in_kg())+Integer.parseInt(quantity_cancel) );
	        				req.getRequestDispatcher("menu").forward(req, resp);
	        			}
	        			if(!isPresent) {
	        				long pricePerUnit=totalPrice/totalQuantity;
	        				Get_Dish.totalPrice=Get_Dish.totalPrice-(Integer.parseInt(quantity_cancel)*pricePerUnit);
	        				dao.insertDish(dish, quantity_cancel, String.valueOf(pricePerUnit));
	        				
	        				if(Get_Dish.orders.contains(dish)) {
                        	Get_Dish.orders.set(Get_Dish.orders.indexOf(id), String.valueOf(dao.getDishByName(dish).getId()));
	        				}
	        				
	        				req.getRequestDispatcher("menu").forward(req, resp);
	        			}
	        			break;
	        		}else {
	        			Get_Dish.orders.set(Get_Dish.orders.indexOf(id)+2, String.valueOf(Integer.parseInt(Get_Dish.orders.get(Get_Dish.orders.indexOf(id)+2))-Integer.parseInt(quantity_cancel)));
	        			
	        			Menu menu=dao.getDishById(Integer.parseInt(id));
	        			
	        			if(menu!=null) {
	        				isPresent=true;
	        				
	        				if(Get_Dish.orders.contains(id)) {
	        					Get_Dish.orders.set(Get_Dish.orders.indexOf(id)+3, String.valueOf(Integer.parseInt(Get_Dish.orders.get(Get_Dish.orders.indexOf(id)+2))*Integer.parseInt(menu.getPrice_per_kg())) );
	        				}
	        				
	        				Get_Dish.totalPrice=Get_Dish.totalPrice-(Integer.parseInt(quantity_cancel)*Integer.parseInt(menu.getPrice_per_kg()));
	        				dao.updateDish(Integer.parseInt(id), Integer.parseInt(menu.getQuantity_in_kg())+Integer.parseInt(quantity_cancel));
	        				req.getRequestDispatcher("menu").forward(req, resp);
	        			}
	        			
	        			if(!isPresent) {
	        				long totalPrice=Long.parseLong(Get_Dish.orders.get(Get_Dish.orders.indexOf(id)+3));
	        				long pricePerUnit=totalPrice/totalQuantity;
	        				
	        				if(Get_Dish.orders.contains(id)) {
	        					Get_Dish.orders.set(Get_Dish.orders.indexOf(id)+3, String.valueOf(Long.parseLong(Get_Dish.orders.get(Get_Dish.orders.indexOf(id)+3))-(Long.parseLong(quantity_cancel)*pricePerUnit)));
	        				}
	        				
	        				Get_Dish.totalPrice=Get_Dish.totalPrice-(Long.parseLong(quantity_cancel)*pricePerUnit);
	        				dao.insertDish(dish, quantity_cancel, String.valueOf(pricePerUnit));
	        				
	        				if(Get_Dish.orders.contains(dish)) {
	        					Get_Dish.orders.set(Get_Dish.orders.indexOf(id), String.valueOf(dao.getDishByName(dish).getId()));
	        				}
	        				
	        				req.getRequestDispatcher("menu").forward(req, resp);
	        			}
	        		}
	        	}else {
	        		req.getRequestDispatcher("menu").forward(req, resp);
	        	}
	        }
		}
		req.getRequestDispatcher("menu").forward(req, resp);
	}
}