package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDao;
import DTO.User;

@WebServlet("/login")
public class Login_User extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email_mid=req.getParameter("email");
		String pass_mid=req.getParameter("pass");
		
		UserDao dao=new UserDao();
		User user=dao.getUserByEmailAndPassword(email_mid, pass_mid);

		if(user!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("username", user.getName());
			req.getRequestDispatcher("Home.jsp").forward(req, resp);
		}else {
			resp.setContentType("text/html");
			resp.getWriter().write("Invalid Credentials !");
			req.getRequestDispatcher("UserLogin.jsp").include(req, resp);
		}
	}

}
