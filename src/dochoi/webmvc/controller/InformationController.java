package dochoi.webmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dochoi.webmvc.dao.UserDao;
import dochoi.webmvc.dao.impl.LoginDao;
import dochoi.webmvc.dao.impl.RegisterDao;
import dochoi.webmvc.dao.impl.UserDaoImpl;
import dochoi.webmvc.jdbc.connectDB;
import dochoi.webmvc.model.Transactions;
import dochoi.webmvc.model.User;
import dochoi.webmvc.service.TransactionService;
import dochoi.webmvc.service.UserService;
import dochoi.webmvc.service.impl.TransactionServicesImpl;
import dochoi.webmvc.service.impl.UserServicesImpl;

/**
 * Servlet implementation class LoginController
 */
public class InformationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public InformationController() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			UserService loginDao = new UserServicesImpl();
			TransactionService transactionService = new TransactionServicesImpl(); 
			try {
				User u = loginDao.get(username);
				List<Transactions> transactionList = transactionService.getByUsername(username);
				request.setAttribute("orders", transactionList);
				request.setAttribute("name", u.getName());
				request.setAttribute("email", u.getEmail());
				request.setAttribute("phone", u.getPhone());
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/info.jsp");
			dispatcher.forward(request, response);
	}
}
