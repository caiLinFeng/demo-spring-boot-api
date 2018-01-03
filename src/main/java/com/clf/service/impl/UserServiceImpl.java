package com.clf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clf.dao.UserMapper;
import com.clf.domain.User;
import com.clf.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUser(int id) {
		if(id<100){
			throw new IllegalArgumentException("参数异常");
		}
		return userMapper.getUser(id);
	}

}
