package dochoi.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import dochoi.webmvc.dao.UserDao;
import dochoi.webmvc.jdbc.connectDB;
import dochoi.webmvc.model.User;

import java.sql.ResultSet;

public class UserDaoImpl extends connectDB implements UserDao {
	
	@Override
	public void insert(User user) {
		String sql = "INSERT INTO users(name,email,phone,username,password,created) VALUES (?, ?, ?, ?, ?, ?)";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6,user.getCreated());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM users where id = ?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public User get(String username) {
		User user = new User();
		String sql = "select * from users where username=?";
		new connectDB();
		Connection con = connectDB.getConnect();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreated(rs.getString("created"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

        return user;
	}

	@Override
	public User get(int id) {
		User user = new User();
		String sql = "select * from users where id=?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreated(rs.getString("created"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

        return user;
	}
	
	@Override
	public void edit(User user) {	
		String sql = "Update users set name=?, email=?, phone=?, username=?, password=?, created=? where id=?";
		new connectDB();
		Connection con = connectDB.getConnect();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getUsername());
			ps.setString(5, user.getPassword());
			ps.setString(6,user.getCreated());
			ps.setInt(7,user.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void edit(String fullname, String email, String phone, String username) {	
		String sql = "Update users set name=?, email=?, phone=? where username=?";
		new connectDB();
		Connection con = connectDB.getConnect();
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fullname);
			ps.setString(2, email);
			ps.setString(3, phone);
			ps.setString(4, username);

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<User> getAll() {		
		List<User> users = new ArrayList<User>();
		String sql = "SELECT * FROM users";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setCreated(rs.getString("created"));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return users; 
	}

	@Override
	public boolean changePassword(String email, String newpassword) {
	    if (email == null || newpassword == null) {
	        return false; // Kiểm tra tính hợp lệ của dữ liệu đầu vào
	    }

	    Connection conn = connectDB.getConnect();
	    try {
	        PreparedStatement pst = conn.prepareStatement("update users set password = ? where email = ?");
	        pst.setString(1, newpassword);
	        pst.setString(2, email);

	        int rowCount = pst.executeUpdate();
	        if (rowCount > 0) {
	            return true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); // Xử lý ngoại lệ, ghi log lỗi hoặc thông báo lỗi cho người dùng
	    }
	    return false;
	}
	
	//Thống kê top 5 khách hàng
	public List<User> getTop5KH() {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT TOP 5 users.name, SUM(CAST(amount AS decimal(18, 0))) AS amount FROM users JOIN transactions AS trans ON trans.user_session = users.username GROUP BY users.name ORDER BY amount DESC";
		Connection conn = connectDB.getConnect();

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setName(rs.getString(1));  //Tên khách hàng
				user.setAmount(rs.getString(2)); //Tổng tiền đã mua
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		}

		return users; 
	}
}


