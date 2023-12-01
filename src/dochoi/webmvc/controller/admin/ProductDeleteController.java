package dochoi.webmvc.controller.admin;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dochoi.webmvc.service.ProductService;
import dochoi.webmvc.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class CatagoryDeleteController
 */
@WebServlet(urlPatterns = { "/admin/product/delete" })
public class ProductDeleteController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		String imageproduct = productService.getImage(getServletInfo());
		if(imageproduct != "") {
			DeleteImage("/view/client/assets/images/products/img-test/"+imageproduct);
		}
		
		
		productService.delete(id);
		resp.sendRedirect(req.getContextPath() + "/admin/product/list");
	}
	public void DeleteImage (String path) {
		
		File file = new File (path);
		if (file.exists()) {
			file.delete();
              
        }
	}
}
