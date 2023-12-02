package dochoi.webmvc.service.impl;

import java.util.List;

import dochoi.webmvc.dao.TransactionDao;
import dochoi.webmvc.dao.impl.TransactionDaoImpl;
import dochoi.webmvc.model.Admin;
import dochoi.webmvc.model.Transactions;
import dochoi.webmvc.service.TransactionService;

public class TransactionServicesImpl implements TransactionService{
	TransactionDao transactionDao = new TransactionDaoImpl();
	 
	public void insert(Transactions transaction) { 
		transactionDao.insert(transaction); 
	} 
	
	
	@Override
	public void edit(Transactions transaction) {
		Transactions oldTransaction = transactionDao.get(transaction.getId());		
		oldTransaction.setUser_name(transaction.getUser_name());
		oldTransaction.setUser_mail(transaction.getUser_mail());
		oldTransaction.setUser_phone(transaction.getUser_phone());
		oldTransaction.setAddress(transaction.getAddress());
		oldTransaction.setMessage(transaction.getMessage());
		oldTransaction.setAmount(transaction.getAmount());
		oldTransaction.setPayment(transaction.getPayment());
		oldTransaction.setStatus(transaction.getStatus());
		transactionDao.edit(oldTransaction);
	} 
	
	
	@Override 
	public void delete(String id) { 
		transactionDao.delete(id); 
 
	} 
 
	@Override 
	public Transactions get(int id) { 
		return transactionDao.get(id); 
	} 
 
	@Override 
	public Transactions get(String name) { 
		return transactionDao.get(name); 
	} 
 
	@Override 
	public List<Transactions> getAll() { 
		return transactionDao.getAll(); 
	}
	
	@Override
	public List<Transactions> getByUsername(String username) {
		return transactionDao.getByUsername(username); 
	}
	
	//DOANH THU
 
	@Override
	public String getDoanhThuTheoNgay(String ngay) {
		return transactionDao.getDoanhThuTheoNgay(ngay);
	}
	
	@Override
	public String getDoanhThuHomNay() {
		return transactionDao.getDoanhThuHomNay();
	}
	
	@Override
	public String getDoanhThuHomQua() {
		return transactionDao.getDoanhThuHomQua();
	}
	
	@Override
	public String getDoanhThuThangNay() {
		return transactionDao.getDoanhThuThangNay();
	}
	
	@Override
	public String getDoanhThuThangTruoc() {
		return transactionDao.getDoanhThuThangTruoc();
	}

}
