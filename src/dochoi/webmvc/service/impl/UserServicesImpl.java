package dochoi.webmvc.service.impl;


import java.util.List;

import dochoi.webmvc.dao.UserDao;
import dochoi.webmvc.dao.impl.UserDaoImpl;
import dochoi.webmvc.model.User;
import dochoi.webmvc.service.UserService;

public class UserServicesImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public void edit(User newUser) {
		User oldUSer = userDao.get(newUser.getId());
		oldUSer.setName(newUser.getName());
		oldUSer.setEmail(newUser.getEmail());
		oldUSer.setPhone(newUser.getPhone());
		oldUSer.setUsername(newUser.getUsername());
		oldUSer.setPassword(newUser.getPassword());
		oldUSer.setCreated(newUser.getCreated());
		userDao.edit(oldUSer);

	}
	
	@Override
	public void edit(String fullname, String email, String phone, String username) {
		userDao.edit(fullname, email, phone, username);
	}
	
	@Override
	public boolean changePassword(String email, String newpassword) {
		return userDao.changePassword(email, newpassword);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
		
	}

	@Override
	public User get(int id) {
		return userDao.get(id);
	}

	@Override
	public User get(String username) {
		// TODO Auto-generated method stub
		return userDao.get(username);
	}
	
	//THỐNG KÊ
	//THỐNG KÊ
	@Override
	public List<User> getTop5KH() {
		return userDao.getTop5KH();
	}

}