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

import dochoi.webmvc.model.Transactions;
import dochoi.webmvc.model.User;
import dochoi.webmvc.service.TransactionService;
import dochoi.webmvc.service.UserService;
import dochoi.webmvc.service.impl.TransactionServicesImpl;
import dochoi.webmvc.service.impl.UserServicesImpl;

/**
 * Servlet implementation class InfomationListOrderController
 */
public class InfomationListOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");

		TransactionService transactionService = new TransactionServicesImpl(); 
		try {

			List<Transactions> transactionList = transactionService.getByUsername(username);
			req.setAttribute("orders", transactionList);

		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/info-list-order.jsp");
		dispatcher.forward(req, resp);
	}

}
