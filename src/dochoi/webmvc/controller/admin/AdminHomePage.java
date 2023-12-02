package dochoi.webmvc.controller.admin;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dochoi.webmvc.model.Product;
import dochoi.webmvc.model.Transactions;
import dochoi.webmvc.model.User;
import dochoi.webmvc.service.UserService;
import dochoi.webmvc.service.ProductService;
import dochoi.webmvc.service.TransactionService;
import dochoi.webmvc.service.impl.UserServicesImpl;
import dochoi.webmvc.service.impl.ProductServiceImpl;
import dochoi.webmvc.service.impl.TransactionServicesImpl;

import java.util.List;


public class AdminHomePage extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	UserService userService = new UserServicesImpl();
	TransactionService  transactionService =new TransactionServicesImpl();
	
	
    public AdminHomePage() {
        super();
    }	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Product> productListTOP5 = productService.getTop5Product();
		List<Product> prodcutHighestQuantity = productService.getTop5HighestQuantity();
		List<User> users = userService.getTop5KH();	
		String  transactions_ToDay =transactionService.getDoanhThuHomNay();
		String  transactions_Yesterday =transactionService.getDoanhThuHomQua();
		String  transactions_ThatMonth =transactionService.getDoanhThuThangNay();
		String  transactions_LastMonth =transactionService.getDoanhThuThangTruoc();
		
		
		request.setAttribute("userlistTOP5", users);
		request.setAttribute("productlistTOP5", productListTOP5);
		request.setAttribute("prodcutHighestQuantity", prodcutHighestQuantity);
		
		
		request.setAttribute("transactions_ToDay",formatNumberWithCommas(transactions_ToDay) );
		request.setAttribute("transactions_Yesterday",formatNumberWithCommas(transactions_Yesterday) );
		request.setAttribute("transactions_ThatMonth",formatNumberWithCommas(transactions_ThatMonth) );
		request.setAttribute("transactions_LastMonth",formatNumberWithCommas(transactions_LastMonth) );
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/index.jsp");
		dispatcher.forward(request,response);
	}
	public static String formatNumberWithCommas(String numberString) {
        StringBuilder sb = new StringBuilder(numberString);

        // Tạo chuỗi mới với dấu chấm sau mỗi 3 ký tự từ phải sang trái
        for (int i = sb.length() - 3; i > 0; i -= 3) {
            sb.insert(i, '.');
        }

        return sb.toString();
    }
}
