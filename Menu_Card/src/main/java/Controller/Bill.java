package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Bill")
public class Bill extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<String> orders=Get_Dish.orders;
		long price=Get_Dish.totalPrice;
		
		req.setAttribute("orders", orders);
		req.setAttribute("totalPrice", price);
		
		req.getRequestDispatcher("Bill.jsp").forward(req, resp);
	}

}
