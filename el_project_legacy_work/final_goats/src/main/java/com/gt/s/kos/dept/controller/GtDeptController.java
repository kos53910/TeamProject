package com.gt.s.kos.dept.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gt.s.kos.dept.service.GtDeptService;
import com.gt.s.kos.dept.vo.GtDeptVO;



@Controller
public class GtDeptController {
	Logger logger = LogManager.getLogger(GtDeptController.class);
	
	@Autowired(required = false)
	private GtDeptService gtDeptService;
	
	
	@PostMapping(value = "goatsDeptSelectAll", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String goatsDeptSelectAll(GtDeptVO dvo, Model model) {
		logger.info("goatsDeptSelectAll 함수 진입");
		System.out.println("123");
		String ret = "";
		List<GtDeptVO> alist = gtDeptService.goatsDeptSelectAll();
		
		if(alist != null && alist.size() > 0) {
			logger.info("alist.size >>> :" + alist.size());
			for(int i=0; i<alist.size(); i++) {
				dvo = alist.get(i);
				ret += dvo.getDeptname() + ",";
			}
			
			model.addAttribute("list", alist);
			
			return ret;
		}else {
			return "";
		}
		
		
	} // end of goatProjectSelectAll
	
} // end of class
