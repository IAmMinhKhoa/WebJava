package dochoi.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dochoi.webmvc.dao.ProductDao;
import dochoi.webmvc.jdbc.connectDB;
import dochoi.webmvc.model.Ordered;
import dochoi.webmvc.model.Product;

import java.sql.ResultSet;

public class ProductDaoImpl extends connectDB implements ProductDao {

	@Override
	public void insert(Product product) {
		String sql = "INSERT INTO product(catalog_id, name, price, status, description, content, discount, image_link, created, quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getCatalog_id());
			ps.setString(2, product.getName());
			ps.setString(3, product.getPrice());
			System.out.println(product.getStatus());
			ps.setString(4, product.getStatus());
			ps.setString(5, product.getDescription());
			ps.setString(6, product.getContent());
			ps.setString(7, product.getDiscount());
			ps.setString(8, product.getImage_link());
			ps.setString(9, product.getCreated());
			
			ps.setInt(10, product.getQuantity());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Product product) {
		String sql = "UPDATE product SET name = ?, catalog_id = ?, price = ?, status = ?, description = ?, content = ?, discount = ?, image_link = ?, created = ?,quantity=? WHERE id = ?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getCatalog_id());
			ps.setString(3, product.getPrice());
			ps.setString(4, product.getStatus());
			ps.setString(5, product.getDescription());
			ps.setString(6, product.getContent());
			ps.setString(7, product.getDiscount());
			ps.setString(8, product.getImage_link());
			ps.setString(9, product.getCreated());
			
			ps.setInt(10, product.getQuantity());
			
			ps.setString(11, product.getId());
			
			
			
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String id) {
		//String sql = "DELETE FROM product WHERE id = ?";
		
		String sql = "update product set status=0 where id=?";
		new connectDB();
		Connection conn = connectDB.getConnect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Product get(int id) {
		String sql = "SELECT * FROM product WHERE id = ? ";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				
				product.setQuantity(rs.getInt("quantity"));
				return product;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product get(String name) {
		return null;
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				
				
				product.setQuantity(rs.getInt("quantity"));
				
				products.add(product);
				//System.out.println(product.getPrice());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return products;
	}

	@Override
	public List<Product> getProductById(int id) {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE catalog_id=?";
		Connection conn = connectDB.getConnect();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();

				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				
				product.setQuantity(rs.getInt("quantity"));
				products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	

	@Override
	public List<Product> searchByName(String keyword) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE name LIKE ? ";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				
				product.setQuantity(rs.getInt("quantity"));	
				productList.add(product);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return productList;
	}
	
	@Override
	public List<Product> searchByPrice(String pricemin, String pricemax) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE CAST(price - (price * discount / 100) AS INTEGER) >= ? AND  CAST(price - (price * discount / 100) AS INTEGER) <= ?";
		Connection conn = connectDB.getConnect();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pricemin);
			ps.setString(2, pricemax);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				product.setQuantity(rs.getInt("quantity"));	
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
		
	}
	
	public List<Product> searchByPriceMin(String pricemin) {
		List<Product> productList = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE CAST(price - (price * discount / 100) AS INTEGER) >= ?";
		Connection conn = connectDB.getConnect();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pricemin);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getString("id"));
				product.setCatalog_id(rs.getString("catalog_id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setStatus(rs.getString("status"));
				product.setDescription(rs.getString("description"));
				product.setContent(rs.getString("content"));
				product.setDiscount(rs.getString("discount"));
				product.setImage_link(rs.getString("image_link"));
				product.setCreated(rs.getString("created"));
				product.setQuantity(rs.getInt("quantity"));	
				productList.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public void edit_Quatity(int id, int newQuantity) {
		String sql = "UPDATE product SET quantity=? WHERE id = ?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, newQuantity);
			ps.setInt(2, id);	
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	//THỐNG KÊ
	@Override
	public List<Product> getTop5Product(){
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT TOP 10 ord.product_id, prod.name, SUM(ord.qty) as qty FROM ordered ord JOIN product prod ON ord.product_id = prod.id GROUP BY ord.product_id, prod.name ORDER BY SUM(ord.qty) DESC";
		Connection con = connectDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Product product = new Product();
				product.setId(rs.getString(1));
				product.setName(rs.getString(2));
				product.setQuantity(rs.getInt(3));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public List<Product> getTop5HighestQuantity() {
		List<Product> products = new ArrayList<Product>();
		String sql = "SELECT TOP 5 product.id,product.name ,product.quantity FROM product ORDER BY product.quantity DESC";
		Connection con = connectDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				Product product = new Product();
				product.setId(rs.getString(1));
				product.setName(rs.getString(2));
				product.setQuantity(rs.getInt(3));
				products.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

}
