package com.gt.s.kos.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gt.s.common.K_Session;
import com.gt.s.kos.employee.service.GtEmployeeService;
import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.login.service.GtLoginService;

@Controller
public class GtLoginController {
	
	Logger log = LogManager.getLogger(this.getClass());

	@Autowired(required = false)
	private GtLoginService loginService;
	
	@Autowired(required = false)
	private GtEmployeeService gtEmployeeService;
	
	@GetMapping(value = "loginForm")
	public String loginForm() {
		
		return "login/loginForm";
	}
	
	@GetMapping(value = "loginx")
	public String loginx() {
		
		return "login/loginX";
	}
	
	@PostMapping(value = "login")
	public String login(GtEmployeeVO evo, HttpServletRequest q, Model m) {
		
		System.out.println(evo.getGeid());
		System.out.println(evo.getGepw());
		
		List<GtEmployeeVO> list = loginService.logincheck(evo);
		if(list != null && list.size() > 0) {
			log.info("list.size() > : " + list.size());
			if(list.size() == 1) {
				
				K_Session ks = K_Session.getInstance();
				String kID = ks.getSession(q);
				evo = gtEmployeeService.genumcheck(evo);
				if (kID !=null && kID.equals(evo.getGenum())){				
					log.info("KosmoLoginController login >>> : 로그인 중 >>> : 메인 페이지로 이동 하기 >>> : " + kID);
					m.addAttribute("listLogin", list);
					return "login/loginOK";
				}else {
					ks.setSession(q, evo.getGenum());
					log.info("KosmoLoginController login >>> : 세션부여 하기  >>> : " + evo.getGenum());
					
					m.addAttribute("listLogin", list);
					return "login/loginOK";
				}
			}
			
		}
		return "login/loginfail";
	}
	
	@GetMapping(value = "logincheck", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String logincheck(HttpServletRequest q, GtEmployeeVO evo) {
		
		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(q);
		if(genum != null) {
			evo.setGenum(genum);
			String gename = gtEmployeeService.goatempidcheck(evo).getGename();
			
			return gename;
		}else {
			return "loginx";
		}
	}
	
	@GetMapping(value = "logout")
	public String logout(HttpServletRequest q) {
		
		K_Session ks = K_Session.getInstance();
		
		ks.killSession(q);
		
		
		return "login/logout";
	}

}
