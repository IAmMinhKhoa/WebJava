package dochoi.webmvc.dao;

import java.util.List;

import dochoi.webmvc.model.Product;

public interface ProductDao {
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

	void edit_Quatity(int id, int newQuantity);
	
	//THỐNG KÊ
	List<Product> getTop5Product();
}
