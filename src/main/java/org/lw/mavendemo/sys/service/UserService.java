package org.lw.mavendemo.sys.service;

import javax.annotation.Resource;

import org.lw.mavendemo.sys.beans.User;
import org.lw.mavendemo.sys.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Resource
	public UserMapper userMapper;

	public User getUser(long id) {
		return userMapper.getUser(id);
	}

	public User getUserByNo(String userNo) {
		return null;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public void insert(User user) {
		userMapper.insert(user);
	}
}
