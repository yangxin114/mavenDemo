package org.lw.mavendemo.sys.service;

import org.lw.mavendemo.sys.beans.User;
import org.lw.mavendemo.sys.mapper.UserMapper;

public class UserService {
	public UserMapper dao;

	public User getUser(long id) {
		return dao.getUser(id);
	}

	public UserMapper getDao() {
		return dao;
	}

	public void setDao(UserMapper dao) {
		this.dao = dao;
	}
	
	public void insert(User user){
		dao.insert(user);
	}
}
