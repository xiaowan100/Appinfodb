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
			// �û���������
			request.getSession().setAttribute("error", "�û������������");
			return "redirect:/user/login";  
		} else {  
			// ��¼�ɹ��󣬽��û������浽Session������ȥ
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
