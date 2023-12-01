package dochoi.webmvc.service.impl;


import java.util.List;

import dochoi.webmvc.dao.ProductDao;
import dochoi.webmvc.dao.impl.ProductDaoImpl;
import dochoi.webmvc.model.Product;
import dochoi.webmvc.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao productDao = new ProductDaoImpl();

	@Override
	public void insert(Product product) {
		productDao.insert(product);
	}

	@Override
	public void edit(Product newProduct) {
		Product oldProduct = productDao.get(Integer.parseInt(newProduct.getId()));
		oldProduct.setName(newProduct.getName());
		oldProduct.setCatalog_id(newProduct.getCatalog_id());
		 oldProduct.setStatus(newProduct.getStatus()); 
		oldProduct.setPrice(newProduct.getPrice());
		oldProduct.setDescription(newProduct.getDescription());
		oldProduct.setContent(newProduct.getContent());
		oldProduct.setDiscount(newProduct.getDiscount());
		oldProduct.setImage_link(newProduct.getImage_link());
		oldProduct.setCreated(newProduct.getCreated());
		oldProduct.setQuantity(newProduct.getQuantity());
		
		
		productDao.edit(oldProduct);

	}

	@Override
	public void delete(String id) {
		productDao.delete(id);

	}

	@Override
	public Product get(int id) {
		return productDao.get(id);
	}

	@Override
	public Product get(String name) {
		return productDao.get(name);
	}

	@Override
	public List<Product> getAll() {
		return productDao.getAll();
	}

	@Override
	public List<Product> getProductById(int id) {
		return productDao.getProductById(id);
	}
	
	@Override
	public List<Product> searchByName(String productName) {
		return productDao.searchByName(productName);
	}
	
	@Override
	public List<Product> searchByPrice(String pricemin, String pricemax) {
		return productDao.searchByPrice(pricemin, pricemax);
	}
	
	@Override
	public List<Product> searchByPriceMin(String pricemin) {
		return productDao.searchByPriceMin(pricemin);
	}

	@Override
	public List<Product> getProductByIdCate(int idCate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void edit_Quatity(int id, int newQuantity) {
		productDao.edit_Quatity(id, newQuantity);
		
	}



}