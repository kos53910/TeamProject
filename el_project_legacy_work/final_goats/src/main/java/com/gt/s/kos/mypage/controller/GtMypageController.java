package com.gt.s.kos.mypage.controller;

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


@Controller
public class GtMypageController {
	
	Logger log = LogManager.getLogger(this.getClass());
	

	@Autowired(required = false)
	private GtEmployeeService gtEmployeeService;
	
	@GetMapping("gtMypageSelect")
	public String gtMypageSelect(HttpServletRequest req, Model m, GtEmployeeVO evo) {
		
		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(req);
		
		evo.setGenum(genum);
		
		GtEmployeeVO gevo = gtEmployeeService.gecheck(evo);
	
		System.out.println("asdfasdfasdfasjilfbljk >>> " + gevo.getGenum());
		req.setAttribute("gevo", gevo);
		
		return	"mypage/mypage";	
	}
	
	
	@GetMapping(value = "gtinfupdate")
	public String gtinfupdate(HttpServletRequest req, Model m, GtEmployeeVO evo) {
		
		log.info("이메일 > " + evo.getGeemail());
		log.info("우편번호 > " + evo.getGezone());
		log.info("도로명주소 > " + evo.getGeroad());
		log.info("상세주소> " + evo.getGeroaddetail());
		log.info("지번 > " + evo.getGejibun());
		log.info("전화번호> " + evo.getGehp());
		
		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(req);
		
		evo.setGenum(genum);
		
		int nCnt = gtEmployeeService.gtinfupdate(evo);
		
		
		if(nCnt > 0) {
			
			return "mypage/upsuccess";
			
		}else {
			
			return "mypage/fail";
		}
	
	}
	
	@PostMapping(value = "gtpwCheck")
	@ResponseBody
	public String gtpwCheck(HttpServletRequest req, Model m, GtEmployeeVO evo) {

		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(req);
		evo.setGenum(genum);
		List<GtEmployeeVO> list = gtEmployeeService.gtpwCheck(evo);
		String pw = req.getParameter("gepw");
		if(list != null && list.size() > 0) {
			if(pw.equals(list.get(0).getGepw())) {
				return "OK";
			}else {
				return "NOK";
			}
		}else {
			return "NOK";
		}

	};
	
	@GetMapping(value = "pwfail")
	public String pwfail() {
		
		return "mypage/pwfail";
	}
	
	@PostMapping(value = "pwupok")
	public String pwupok(HttpServletRequest req, GtEmployeeVO evo) {
		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(req);
		String pw = req.getParameter("newpw");
		evo.setGenum(genum);
		evo.setGepw(pw);
		int nCnt = gtEmployeeService.gtpwupdateCheck(evo);
		if(nCnt > 0) {
			return "mypage/upsuccess";
		}else {
			return "mypage/pwfail";
		}
		
		
	}
	
	@PostMapping(value = "gtpwupdateCheck")
	@ResponseBody
	public String pwCheck(HttpServletRequest req, GtEmployeeVO evo) {
		
		boolean a1 = false;
		boolean a2 = false;
		boolean a3 = false;
		boolean a4 = false;
		boolean a5 = false;
		String returnpw = "";
		String pw = req.getParameter("newpw");
		log.info(pw);
		char pwc[] = pw.toCharArray();

		for (int i = 0; i < pwc.length; i++) {

			// 대문자
			if (0x41 <= pwc[i] && pwc[i] <= 0x5A) {

				a1 = true;

			}
			// 소문자
			if (0x61 <= pwc[i] && pwc[i] <= 0x7A) {

				a2 = true;

			}
			// 특수문자
			if (0x21 <= pwc[i] && pwc[i] <= 0x27 || pwc[i] == 0x40) {

				a3 = true;

			}
			// 숫자
			if (0x30 <= pwc[i] && pwc[i] <= 0x39) {
				
				a5 = true;
				
			}
			if (pwc.length >= 8) {

				a4 = true;
			}
		}

		return String.valueOf(a1) + "+" + String.valueOf(a2) + "+" + String.valueOf(a3) + "+" + String.valueOf(a4) + "+" +String.valueOf(a5);
	}
	
	   @GetMapping("mainMap")
	   public String mainMap() {
	      
	      return "main/main-map";
	   }
	
}
