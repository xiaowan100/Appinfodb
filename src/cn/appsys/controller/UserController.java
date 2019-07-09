package cn.appsys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;
import cn.appsys.service.deve.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource
	public UserService userService;
	
	@RequestMapping("/login")  
	public String toMain() {
		return "devlogin";
	}
	
	@RequestMapping(value = "/userLogin",method = RequestMethod.POST)
	public String doLogin(@RequestParam("devCode") String devCode, @RequestParam("devPassword") String devPassword,
			HttpServletRequest request) {
		DevUser user = userService.Login(devCode,devPassword);
		if (user == null) {
			// 用户名不存在
			request.getSession().setAttribute("error", "用户名或密码错误");
			return "redirect:/user/login";  
		} else {  
			// 登录成功后，将用户名保存到Session作用域去
			request.getSession().setAttribute("devUserSession", user);
			request.getSession().setAttribute("id", user.getId());
			return "developer/main";
		}
	}
	
	@RequestMapping("/logout")
	public String tologout(HttpSession session) {
		session.invalidate();
		return "redirect:/user/login";
	}
}
