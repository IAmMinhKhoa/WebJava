package dochoi.webmvc.service;

import java.util.List;

import dochoi.webmvc.model.Product;
public interface ProductService {
	void insert(Product product);

	void edit(Product product);

	void delete(String id);

	Product get(int id);
	
	Product get(String name);

	List<Product> getAll();
	
	List<Product> getProductById(int id);

	List<Product> searchByName(String productName);
	
	List<Product> searchByPrice(String pricemin, String pricemax);

	List<Product> searchByPriceMin(String pricemin);
	
	List<Product> getProductByIdCate(int idCate);

}
