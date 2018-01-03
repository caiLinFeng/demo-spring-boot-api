package com.clf.dao;

import org.apache.ibatis.annotations.Mapper;

import com.clf.domain.User;

@Mapper
public interface UserMapper {
	
	User getUser(int id);
}
