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

/**
 * Servlet implementation class ProductEditController
 */
@MultipartConfig()
@WebServlet(urlPatterns={"/admin/product/edit"})
public class ProductEditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CategoryService cateService = new CategoryServicesImpl();
		List<Catalog> cateList = cateService.getAll();
		req.setAttribute("catelist", cateList);
		
		String id = req.getParameter("id");
		Product product = productService.get(Integer.parseInt(id));
		req.setAttribute("product", product);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/editproduct.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		
		//product.setImage_link(req.getParameter("product-image"));
		
		
		
		try { // Xử lý file được gửi từ form // ... (Phần xử lý file như trong đoạn mã của bạn)
			  
			  // Xử lý file được gửi từ form Part filePart = req.getPart("product-image");
			  // Đọc file được gửi từ input có name là "product-image" 
				  Product product = new Product();
				  product.setId(req.getParameter("product-sku"));
				  product.setCatalog_id(req.getParameter("product-cate"));
				  product.setName(req.getParameter("product-name"));
				  product.setPrice(req.getParameter("product-price"));
				  product.setStatus(req.getParameter("product-status"));
				  product.setDescription(req.getParameter("product-desc"));
				  product.setContent(req.getParameter("product-content"));
				  product.setDiscount(req.getParameter("product-discount"));
				  Part filePart = req.getPart("product-image");
				  
				  if(filePart != null) {
					  String imageproduct = productService.getImage(getServletInfo());
						if(imageproduct != "") {
							DeleteImage("/view/client/assets/images/products/img-test/"+imageproduct);
						}
				  }
				  
				  String fileName = extractFileName(filePart); // Lấy tên file
				
			  // Lưu file vào một thư mục trên server 
		      String applicationPath = req.getServletContext().getRealPath("/view/client/assets/images/products");
			  String uploadPath = applicationPath + File.separator + "img-test"; // Thư mục để lưu file 
			  File fileUploadDirectory = new File(uploadPath); 
			  if(!fileUploadDirectory.exists()) { fileUploadDirectory.mkdirs(); }
			  
			  // Ghi file vào thư mục 
			  String savePath = uploadPath + File.separator + fileName; 
			  filePart.write(savePath);
			  
			  product.setCreated(req.getParameter("product-day"));
			  productService.edit(product);
				
			  resp.sendRedirect(req.getContextPath()+"/admin/product/list");

			  
			  
			  } catch (IOException e) { // Xử lý ngoại lệ khi có lỗi trong quá trình xử lý
				  e.printStackTrace(); // In thông tin lỗi ra console hoặc xử lý tùy ý // Có thể thêm các logic khác như thông báo lỗi cho người dùng 
			  }
	}
	public void DeleteImage (String path) {
		
		File file = new File (path);
		if (file.exists()) {
			file.delete();
              
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