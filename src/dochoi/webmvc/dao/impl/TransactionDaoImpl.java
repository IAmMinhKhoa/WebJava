package dochoi.webmvc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dochoi.webmvc.dao.CategoryDao;
import dochoi.webmvc.dao.TransactionDao;
import dochoi.webmvc.jdbc.connectDB;
import dochoi.webmvc.model.Transactions;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TransactionDaoImpl extends connectDB implements TransactionDao {
	public void insert(Transactions transaction) { 
		String sql = "INSERT INTO transactions(user_session,user_name,user_mail,user_phone,address,message,amount,payment,status,created) VALUES (?,?,?,?,?,?,?,?,?,?)"; 
		new connectDB(); 
		Connection con = connectDB.getConnect(); 
 
		try { 
			PreparedStatement ps = con.prepareStatement(sql); 
			ps.setString(1, transaction.getUser_session());
			ps.setString(2, transaction.getUser_name());
			ps.setString(3, transaction.getUser_mail());
			ps.setString(4, transaction.getUser_phone());
			ps.setString(5, transaction.getAddress());
			ps.setString(6, transaction.getMessage());
			ps.setString(7, transaction.getAmount());
			ps.setString(8, transaction.getPayment());
			ps.setString(9, "Đang chờ xác nhận");
			ps.setString(10, transaction.getCreated());
			ps.executeUpdate(); 
			
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
	} 
	
	@Override 
	public void delete(String id) { 		
		String sql = "Delete from transactions where id=?";
		new connectDB();
		Connection con = connectDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,id);
			ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	} 
	
	@Override
	public Transactions get(int id) {		
		Transactions transaction = new Transactions();
		String sql = "SELECT * FROM transactions WHERE id=?";
		new connectDB();
		Connection con = connectDB.getConnect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {				
				transaction.setId(rs.getInt("id"));
				transaction.setUser_session(rs.getString("user_session"));
				transaction.setUser_name(rs.getString("user_name"));
				transaction.setUser_mail(rs.getString("user_mail"));
				transaction.setUser_phone(rs.getString("user_phone"));
				transaction.setAddress(rs.getString("address"));
				transaction.setMessage(rs.getString("message"));
				transaction.setAmount(rs.getString("amount"));
				transaction.setPayment(rs.getString("payment"));	
				if(rs.getString("status").equals("Đang chờ xác nhận")) {
					transaction.setStatus(1);
				} else if (rs.getString("status").equals("Đang chuẩn bị đơn hàng")) {
					transaction.setStatus(2);
				} else if (rs.getString("status").equals("Đang giao hàng")) {
					transaction.setStatus(3);
				} else if (rs.getString("status").equals("Đã giao hàng")) {
					transaction.setStatus(4);
				}
				transaction.setCreated(rs.getString("created"));
				return transaction;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override 
	public void edit(Transactions transaction) { 
	String sql = "Update transactions set user_name =?, user_mail =?, user_phone =?, address= ?,message=?,amount=?,payment=?, status=? where id=?";

		new connectDB();
		Connection con = connectDB.getConnect();
		try 
		{
			PreparedStatement ps = con.prepareStatement(sql); 
			ps.setString(1, transaction.getUser_name());
			ps.setString(2, transaction.getUser_mail());
			ps.setString(3, transaction.getUser_phone());
			ps.setString(4, transaction.getAddress());
			ps.setString(5, transaction.getMessage());
			ps.setString(6, transaction.getAmount());
			ps.setInt(7, Integer.parseInt(transaction.getPayment()));
			if(transaction.getStatus() == 1) {
				ps.setString(8, "Đang chờ xác nhận");
			} else if (transaction.getStatus() == 2) {
				ps.setString(8, "Đang chuẩn bị đơn hàng");
			} else if (transaction.getStatus() == 3) {
				ps.setString(8, "Đang giao hàng");
			} else {
				ps.setString(8, "Đã giao hàng");
			}
			ps.setInt(9,transaction.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}		 
	} 
	
	@Override 
	public Transactions get(String name) { 
		return null; 
	} 
 
	@Override 
	public List<Transactions> getAll() { 
		List<Transactions> transactions = new ArrayList<Transactions>(); 
		String sql = "SELECT * FROM transactions"; 
		Connection conn = connectDB.getConnect(); 
 
		try { 
			PreparedStatement ps = conn.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery(); 
 
			while (rs.next()) { 
				Transactions transaction = new Transactions(); 
				transaction.setId(rs.getInt("id"));
				transaction.setUser_session(rs.getString("user_session"));
				transaction.setUser_name(rs.getString("user_name"));
				transaction.setUser_mail(rs.getString("user_mail"));
				transaction.setUser_phone(rs.getString("user_phone"));
				transaction.setAddress(rs.getString("address"));
				transaction.setMessage(rs.getString("message"));
				transaction.setAmount(rs.getString("amount"));
				transaction.setPayment(rs.getString("payment"));
				if(rs.getString("status").equals("Đang chờ xác nhận")) {
					transaction.setStatus(1);
				} else if (rs.getString("status").equals("Đang chuẩn bị đơn hàng")) {
					transaction.setStatus(2);
				} else if (rs.getString("status").equals("Đang giao hàng")) {
					transaction.setStatus(3);
				} else if (rs.getString("status").equals("Đã giao hàng")) {
					transaction.setStatus(4);
				}
				transaction.setCreated(rs.getString("created"));
				transactions.add(transaction); 
			} 
 
		} catch (SQLException e) { 
			e.printStackTrace(); 
		} 
 
		return transactions; 
	}
	
	@Override 
	public List<Transactions> getByUsername(String username) {
		List<Transactions> transactions = new ArrayList<Transactions>(); 
		String sql = "SELECT * FROM transactions WHERE user_session = ?"; 
		Connection conn = connectDB.getConnect(); 
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {			
				Transactions transaction = new Transactions(); 
				transaction.setId(rs.getInt("id"));
				transaction.setUser_session(rs.getString("user_session"));
				transaction.setUser_name(rs.getString("user_name"));
				transaction.setUser_mail(rs.getString("user_mail"));
				transaction.setUser_phone(rs.getString("user_phone"));
				transaction.setAddress(rs.getString("address"));
				transaction.setMessage(rs.getString("message"));

				//đổi định dạng tiền
				double number = Double.parseDouble(rs.getString("amount").split("\\.")[0]);
				DecimalFormat decimalFormat = new DecimalFormat("#,###");
				String amount = decimalFormat.format(number);
				
				transaction.setAmount(amount);
				transaction.setPayment(rs.getString("payment"));	
				if(rs.getString("status").equals("Đang chờ xác nhận")) {
					transaction.setStatus(1);
				} else if (rs.getString("status").equals("Đang chuẩn bị đơn hàng")) {
					transaction.setStatus(2);
				} else if (rs.getString("status").equals("Đang giao hàng")) {
					transaction.setStatus(3);
				} else if (rs.getString("status").equals("Đã giao hàng")) {
					transaction.setStatus(4);
				}
				
				//Đổi định dạng ngày tháng năm
				DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
		        DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
		        String outputDate= "";
		        try {
		            Date date = inputFormat.parse(rs.getString("created"));
		            outputDate = outputFormat.format(date);
		            // Tiếp tục xử lý ngày đã chuyển đổi
		        } catch (ParseException e) {
		            e.printStackTrace();
		            // Xử lý ngoại lệ ở đây, ví dụ: thông báo lỗi hoặc xử lý mặc định
		        }
		        
				transaction.setCreated(outputDate);
				transactions.add(transaction); 

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return transactions;
	}
	
	//DOANH THU
	
		//Lấy doanh thu hôm nay
		public String getDoanhThuHomNay() {
		    LocalDate currentDate = LocalDate.now();
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    String formattedDate = currentDate.format(formatter);
		    String doanhthu = "";
		    String sql = "SELECT SUM(CAST(amount AS decimal(18, 0))) " +
		            "FROM transactions " +
		            "WHERE WHERE YEAR(create) = YEAR(?) AND MONTH(create) = MONTH(?) AND DAY(create) = DAY(?)";
		    Connection conn = connectDB.getConnect();
		    try {
		        PreparedStatement ps = conn.prepareStatement(sql);
		        ps.setString(1, formattedDate);
		        ps.setString(2, formattedDate);
		        ps.setString(3, formattedDate);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
					DecimalFormat decimalFormat = new DecimalFormat("#,###");
					doanhthu = decimalFormat.format(rs.getString(1));
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return doanhthu;
		}
		
		//Lấy doanh thu hôm qua
		public String getDoanhThuHomQua() {
		    LocalDate currentDate = LocalDate.now();
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    String formattedDate = currentDate.format(formatter);
		    String doanhthu = "";
		    String sql = "SELECT SUM(CAST(amount AS decimal(18, 0))) " +
		            "FROM transactions " +
		            "WHERE WHERE YEAR(create) = YEAR(?) AND MONTH(create) = MONTH(?) AND DAY(create) = DAY(?) - 1";
		    Connection conn = connectDB.getConnect();
		    try {
		        PreparedStatement ps = conn.prepareStatement(sql);
		        ps.setString(1, formattedDate);
		        ps.setString(2, formattedDate);
		        ps.setString(3, formattedDate);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		        	if(rs.getString(1) == null) {
		        		doanhthu = "0";
		        	}
		        	else {
						DecimalFormat decimalFormat = new DecimalFormat("#,###");
						doanhthu = decimalFormat.format(rs.getString(1));	
		        	}
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return doanhthu;
		}
		
		//Lấy doanh thu tháng này
		public String getDoanhThuThangNay() {
		    LocalDate currentDate = LocalDate.now();
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		    String formattedDate = currentDate.format(formatter);
		    String doanhthu = "";
		    String sql = "SELECT SUM(CAST(amount AS decimal(18, 0))) " +
		            "FROM transactions " +
		            "WHERE WHERE YEAR(create) = YEAR(?) AND MONTH(create) = MONTH(?)";
		    Connection conn = connectDB.getConnect();
		    try {
		        PreparedStatement ps = conn.prepareStatement(sql);
		        ps.setString(1, formattedDate);
		        ps.setString(2, formattedDate);
		        ResultSet rs = ps.executeQuery();
		        while (rs.next()) {
		        	if(rs.getString(1) == null) {
		        		doanhthu = "0";
		        	}
		        	else {
						DecimalFormat decimalFormat = new DecimalFormat("#,###");
						doanhthu = decimalFormat.format(rs.getString(1));
		        	}
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return doanhthu;
		}
		
		//Lấy doanh thu tháng trước
			public String getDoanhThuThangTruoc() {
			    LocalDate currentDate = LocalDate.now();
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			    String formattedDate = currentDate.format(formatter);
			    String doanhthu = "";
			    String sql = "SELECT SUM(CAST(amount AS decimal(18, 0))) " +
			            "FROM transactions " +
			            "WHERE WHERE YEAR(create) = YEAR(?) AND MONTH(create) = MONTH(?) - 1";
			    Connection conn = connectDB.getConnect();
			    try {
			        PreparedStatement ps = conn.prepareStatement(sql);
			        ps.setString(1, formattedDate);
			        ps.setString(2, formattedDate);
		
			        ResultSet rs = ps.executeQuery();
			        while (rs.next()) {
			        	if(rs.getString(1) == null) {
			        		doanhthu = "0";
			        	}
			        	else {
							DecimalFormat decimalFormat = new DecimalFormat("#,###");
							doanhthu = decimalFormat.format(rs.getString(1));
			        	}
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			    return doanhthu;
			}
			
			//Lấy doanh thu theo ngày
					public String getDoanhThuTheoNgay(String ngay) {
					    String doanhthu = "";
					    String sql = "SELECT SUM(CAST(amount AS decimal(18, 0))) " +
					            "FROM transactions " +
					            "WHERE WHERE YEAR(create) = YEAR(?) AND MONTH(create) = MONTH(?) AND DAY(create) = DAY(?)";
					    Connection conn = connectDB.getConnect();
					    try {
					        PreparedStatement ps = conn.prepareStatement(sql);
					        ps.setString(1, ngay);
					        ps.setString(2, ngay);
					        ps.setString(3, ngay);
				
					        ResultSet rs = ps.executeQuery();
					        while (rs.next()) {
					        	if(rs.getString(1) == null) {
					        		doanhthu = "0";
					        	}
					        	else {
									DecimalFormat decimalFormat = new DecimalFormat("#,###");
									doanhthu = decimalFormat.format(rs.getString(1));
					        	}
					        }
					    } catch (SQLException e) {
					        e.printStackTrace();
					    }
					    return doanhthu;
					}
}
