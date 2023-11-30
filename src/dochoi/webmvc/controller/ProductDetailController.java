package dochoi.webmvc.controller;

import java.io.Console;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dochoi.webmvc.model.Catalog;
import dochoi.webmvc.model.Product;
import dochoi.webmvc.model.Review;
import dochoi.webmvc.service.CategoryService;
import dochoi.webmvc.service.ProductService;
import dochoi.webmvc.service.ReviewService;
import dochoi.webmvc.service.impl.CategoryServicesImpl;
import dochoi.webmvc.service.impl.ProductServiceImpl;
import dochoi.webmvc.service.impl.ReviewServicesImpl;

public class ProductDetailController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServicesImpl();
	ProductService productService = new ProductServiceImpl();
	ReviewService reviewService = new ReviewServicesImpl();
	DecimalFormat df = new DecimalFormat("#.000");
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product detail_product = productService.get(Integer.parseInt(id));
		
		//System.out.println(detail_product.getQuantily());
		req.setAttribute("detail_product", detail_product);
		
		List<Catalog> name_cate_of_product = cateService.getCateByProduct(Integer.parseInt(id));
		req.setAttribute("name_cate_of_product", name_cate_of_product);
		
		String idCate = detail_product.getCatalog_id();
		
		List<Product> productListCate = productService.getProductById(Integer.parseInt(idCate));
		
		req.setAttribute("productById", productListCate);
		
		List<Review> reviewById = reviewService.getReviewById(Integer.parseInt(id));
		req.setAttribute("reviewbyid", reviewById);
		
		List<Product> productList = productService.getAll();
		req.setAttribute("productlist", productList);	
		//Giá giảm
		List<Product> productsList1 = new ArrayList<Product>();
		for(Product product: productList)
		{
			Product product1 = productService.get(Integer.parseInt(product.getId()));
			product1.setPrice(String.valueOf(df.format(Double.parseDouble(product.getPrice()) * (1 - (Double.parseDouble(product.getDiscount())/100)))));
			productsList1.add(product1);
			
		}

		req.setAttribute("productlist1", productsList1);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/product-detail.jsp");
		dispatcher.forward(req, resp);
	}

}
