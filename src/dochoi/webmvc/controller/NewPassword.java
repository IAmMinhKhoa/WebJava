package dochoi.webmvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dochoi.webmvc.service.UserService;
import dochoi.webmvc.service.impl.UserServicesImpl;

/**
 * Servlet implementation class NewPassword
 */

public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		String newPassword = request.getParameter("password");
		String confPassword = request.getParameter("confPassword");
		RequestDispatcher dispatcher = null;
		if (newPassword != null && confPassword != null && newPassword.equals(confPassword)) {

			try {
				UserService userSer = new UserServicesImpl();
				boolean check = userSer.changePassword(email, newPassword);
				if (check) {
					request.setAttribute("status", "resetSuccess");
					dispatcher = request.getRequestDispatcher("/view/client/login.jsp");
				} else {
					request.setAttribute("status", "resetFailed");
					dispatcher = request.getRequestDispatcher("/view/client/login.jsp");
				}
				
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
