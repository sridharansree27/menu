package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.MenuDao;
import DTO.Menu;

@WebServlet("/menu")
public class Get_Menu extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession(false);
		String username=(String)session.getAttribute("username");
		
		if(username!=null) {
			
			MenuDao dao=new MenuDao();
	    	List<Menu> menu=dao.getMenu();
		
	    	req.setAttribute("menu", menu);
		
	    	req.getRequestDispatcher("MenuView.jsp").forward(req, resp);
		}else {
			
			resp.setContentType("text/html");
			resp.getWriter().write("Session Expired !");
			req.getRequestDispatcher("UserLogin.jsp").include(req, resp);
			
		}
	}
}
