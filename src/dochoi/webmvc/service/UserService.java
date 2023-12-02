package dochoi.webmvc.service;

import java.util.List;

import dochoi.webmvc.model.User;
public interface UserService {
	
void insert(User user);
	
	void edit(User user);
	
	void edit(String fullname, String email, String phone, String username);
	
	void delete(int id);
	
	boolean changePassword(String email, String newpassword);
	
	User get(int id);
	
	User get(String username);

	List<User> getAll();

	//THỐNG KÊ
	List<User> getTop5KH();
}

