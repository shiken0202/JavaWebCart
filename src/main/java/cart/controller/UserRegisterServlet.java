package cart.controller;

import java.io.IOException;

import cart.service.EmailService;
import cart.service.UserRegisterService;
import cart.service.impl.UserRegisterServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user/register")
public class UserRegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");
		req.getRequestDispatcher("/WEB-INF/view/cart/user_register.jsp").forward(req, resp);
	}
	UserRegisterService userRegisterService=new UserRegisterServiceImpl();
	EmailService emailService=new EmailService();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String email=req.getParameter("email");

		userRegisterService.addUser(username, password, email);
		
		String emailConfirmLink="http://localhost:8080/JavaWebCart/email/confirm?username="+username;
		emailService.sendEmail(email,emailConfirmLink );
		RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/view/cart/user_register.jsp");
		rd.forward(req, resp);

	}
	
	
}