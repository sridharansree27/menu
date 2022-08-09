package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;
import DTO.User;

@WebServlet("/save")
public class Insert_User extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String user_front=req.getParameter("user");
		String email_front=req.getParameter("email");
		String pass_front=req.getParameter("pass");
		
		User user=new User();
		user.setName(user_front);
		user.setEmail(email_front);
		user.setPassword(pass_front);
		
		UserDao dao=new UserDao();
		dao.insertUser(user);
		
		req.getRequestDispatcher("UserLogin.jsp").forward(req, resp);
	}

}
