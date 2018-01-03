package com.clf.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.clf.domain.User;
import com.clf.service.UserService;
@Api(value="用户",description="用户模块")
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@Value("${server.port}")
	private String port;
	
	@ApiOperation(value="获用户信息", notes="根据用户ID获取信息")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "int",paramType = "path")
	@RequestMapping(value="user/{id}", method=RequestMethod.GET)
    public User helloWorld(@PathVariable("id") Integer id) {
		System.out.println(port);
        return userService.getUser(id);
    }
	
	@Autowired
	private Environment env;
	
	@Value("${profile}")
	private String profile;
	
	@RequestMapping(value="test", method=RequestMethod.GET)
	public String test(){
		return env.getProperty("profile")+"--"+profile+"--"+port;
	}
	
}
