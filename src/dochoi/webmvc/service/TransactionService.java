package dochoi.webmvc.service;

import java.util.List;

import dochoi.webmvc.model.Transactions;

public interface TransactionService {
	void insert(Transactions transaction);
	 
	void edit(Transactions transaction); 

	void delete(String id); 
 
	Transactions get(int id); 
	 
	Transactions get(String name); 
 
	List<Transactions> getAll(); 
	
	List<Transactions> getByUsername(String username); 
	
	String getDoanhThuTheoNgay(String ngay);
	
	String getDoanhThuHomNay();
	
	String getDoanhThuHomQua();
	
	String getDoanhThuThangNay();
	
	String getDoanhThuThangTruoc();

}
