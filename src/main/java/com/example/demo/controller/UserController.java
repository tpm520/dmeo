package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("user")
@Api(value="用户管理",tags = "用户管理api")
public class UserController {

	@Autowired
	private UserService us;

	/*
	 * @Value("${com.spring.name}") private String name;
	 * 
	 * @Value("${com.spring.num}") private Integer num;
	 * 
	 * @Value("${com.spring.value}") private String value;
	 * 
	 * @Value("${com.spring.rand}") private Integer rand;
	 * 
	 * @RequestMapping("getName") public String getName() { return name; }
	 * 
	 * @RequestMapping("getRand") public String rand() { return "随机数：" + num +
	 * "随机值：" + value + "范围随机：" + rand; }
	 */
	
	@ApiOperation("查询所有用户")
	@PostMapping("getUserAll")
	public List<User> getUserAll() {
		System.out.println(12345);
		return us.findUserAll();
	}
	
	/**
	 * paramType：表示参数放在哪个地方
		    header-->请求参数的获取：@RequestHeader(代码中接收注解)
		    query-->请求参数的获取：@RequestParam(代码中接收注解)
		    path（用于restful接口）-->请求参数的获取：@PathVariable(代码中接收注解)
		    body-->请求参数的获取：@RequestBody(代码中接收注解)
		    form（不常用）
	 */
	@ApiOperation(value="添加用户",notes="更具用户名创建用户")
	@PostMapping("addUser")
	public Integer addUser(@RequestBody @ApiParam("用户对象") User user) {

		System.out.println(user);
		/*
		 * User user = new User(); user.setUsername(username);
		 */
		 Integer info = us.addUser(user);
		 
		return info;
	}
}
