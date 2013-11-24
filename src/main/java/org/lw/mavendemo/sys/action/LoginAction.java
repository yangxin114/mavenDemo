package org.lw.mavendemo.sys.action;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.lw.mavendemo.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginAction {
	private static  Log log = LogFactory.getLog(LoginAction.class);
	
	@Resource
	private UserService service;

	public static Log getLog() {
		return log;
	}

	public static void setLog(Log log) {
		LoginAction.log = log;
	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}
}
