package dochoi.webmvc.dao;

import java.util.List;

import dochoi.webmvc.model.User;

public interface UserDao {
	
	void insert(User user);

	void edit(User user);
	
	void edit(String fullname, String email, String phone, String username);
	
	void delete(int id);

	User get(String username);

	User get(int id);
	
	List<User> getAll();
}
