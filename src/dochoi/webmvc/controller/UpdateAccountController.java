package dochoi.webmvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dochoi.webmvc.model.User;
import dochoi.webmvc.service.UserService;
import dochoi.webmvc.service.impl.UserServicesImpl;

/**
 * Servlet implementation class UpdateAccountController
 */
public class UpdateAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=UTF-8");
			HttpSession session = request.getSession();
			String username = (String) session.getAttribute("username");
			UserService loginDao = new UserServicesImpl();
			try {
				User u = loginDao.get(username);
				request.setAttribute("name", u.getName());
				request.setAttribute("email", u.getEmail());
				request.setAttribute("phone", u.getPhone());
			} catch (Exception e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/client/update-account.jsp");
			dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String name = request.getParameter("fullname");
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		UserService updateuser = new UserServicesImpl();
		try {
			
			updateuser.edit(name, email, phone, username);
			request.setAttribute("Message", "Đã cập nhật thành công.");
			request.setAttribute("name", name);
			request.setAttribute("email", email);
			request.setAttribute("phone", phone);
			RequestDispatcher rd = request.getRequestDispatcher("/view/client/update-account.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			request.setAttribute("Message", "Cập nhật thất bại.");
			RequestDispatcher rd = request.getRequestDispatcher("/view/client/update-account.jsp");
			rd.forward(request, response);
		}
	}

}
