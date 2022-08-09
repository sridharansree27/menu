package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import DTO.User;

@WebServlet("/view")
public class Profile_User extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession(false);
		String username=(String)session.getAttribute("username");
		
		UserDao dao=new UserDao();
		User user=dao.getUserByName(username);
		
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("UserView.jsp").forward(req, resp);
	}

}
