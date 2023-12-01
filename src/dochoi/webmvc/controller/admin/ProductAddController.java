package dochoi.webmvc.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dochoi.webmvc.model.Catalog;
import dochoi.webmvc.model.Product;
import dochoi.webmvc.service.CategoryService;
import dochoi.webmvc.service.ProductService;
import dochoi.webmvc.service.impl.CategoryServicesImpl;
import dochoi.webmvc.service.impl.ProductServiceImpl;

@MultipartConfig
public class ProductAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService cateService = new CategoryServicesImpl();
		List<Catalog> cateList = cateService.getAll();
		req.setAttribute("catelist", cateList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/addproduct.jsp");
		dispatcher.forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=UTF-8");
			String product_cate = req.getParameter("product-cate");
			String product_name = req.getParameter("product-name");
			String product_price = req.getParameter("product-price");
			/* String product_status = req.getParameter("product-status"); */
			String product_desc = req.getParameter("product-desc");
			String product_content = req.getParameter("product-content");
			String product_discount = req.getParameter("product-discount");
			/*String product_image = req.getParameter("product-image");*/
			String product_day = req.getParameter("product-day");
			String product_quantity = req.getParameter("product-quatity");
			
			try { // Xử lý file được gửi từ form // ... (Phần xử lý file như trong đoạn mã của bạn)
				  
				  // Xử lý file được gửi từ form Part filePart = req.getPart("product-image");
				  // Đọc file được gửi từ input có name là "product-image" 
					  Product product = new Product();
					  
					  String fileName="";
					  
					  Part filePart = req.getPart("product-image");
					  if (filePart != null) {
					      // Xử lý tệp tin
						   fileName = extractFileName(filePart); // Lấy tên file
					  } else {
					      // Xử lý trường hợp filePart là null
					      System.out.println("filePart is null");
					  }

					  
					
				  // Lưu file vào một thư mục trên server 
					  String applicationPath = req.getServletContext().getRealPath("/view/client/assets/images/products");
	
					  String uploadPath = applicationPath + File.separator + "img-test"; // Thư mục để lưu file 
				  File fileUploadDirectory = new File(uploadPath); 
				  if(!fileUploadDirectory.exists()) { fileUploadDirectory.mkdirs(); }
				  
				  // Ghi file vào thư mục 
				  String savePath = uploadPath + File.separator + fileName; 
				  filePart.write(savePath);
				  System.out.println(savePath);
				  
				  product.setCatalog_id(product_cate);
					product.setName(product_name);
					product.setPrice(product_price);
					
					product.setDescription(product_desc);
					product.setContent(product_content);
					product.setDiscount(product_discount);
					product.setImage_link(fileName);
					product.setCreated(product_day);
					
					product.setQuantity(Integer.parseInt(product_quantity));
					
					if(product.getQuantity()>0) {
						product.setStatus("1");
					}else {
						product.setStatus("0");
					}
					
					
					productService.insert(product);
					resp.sendRedirect(req.getContextPath() + "/admin/product/list");
				  
				  } catch (IOException e) { // Xử lý ngoại lệ khi có lỗi trong quá trình xử lý
					  e.printStackTrace(); // In thông tin lỗi ra console hoặc xử lý tùy ý // Có thể thêm các logic khác như thông báo lỗi cho người dùng 
				  }
		}
		// Phương thức trích xuất tên file từ Part
	    private String extractFileName(Part part) {
	    	
	        String contentDisp = part.getHeader("content-disposition");
	       
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length() - 1);
	            }
	        }
	        return "";
	    }
	}