package cn.appsys.service.deve.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.deve.UserMapper;
import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.deve.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	public UserMapper userMapper;
	
	public DevUser Login(String id,String pwd) {
		return userMapper.Login(id,pwd);
	}

}
