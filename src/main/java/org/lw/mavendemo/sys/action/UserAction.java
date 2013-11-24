package org.lw.mavendemo.sys.action;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lw.mavendemo.sys.beans.User;
import org.lw.mavendemo.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserAction {
	private static  Log log = LogFactory.getLog(UserAction.class);

	@Resource
	private UserService service;

	@RequestMapping("/user/add")
	public String add(User user){
		String result ="";
		return result;
	}
	
	@RequestMapping("/user/delete")
	public String delete(User user){
		String result ="";
		return result;
	}
	
	@RequestMapping("/user/update")
	public String update(User user){
		String result ="";
		return result;
	}
	
	@RequestMapping("/user/selAll")
	public String selAll(User user){
		String result ="";
		return result;
	}
	
	
	@RequestMapping("/user/login")
	public String login(String uName) {
		String result = null;
		System.out.println(uName);
		result = "hello";
		return result;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
}
