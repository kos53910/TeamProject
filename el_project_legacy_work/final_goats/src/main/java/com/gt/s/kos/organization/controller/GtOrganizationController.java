package com.gt.s.kos.organization.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.organization.service.GtOrganizationService;
import com.gt.s.kos.organization.vo.GtOrganizationVO;

@Controller
public class GtOrganizationController {

	Logger log = LogManager.getLogger(GtOrganizationController.class);

	@Autowired(required = false)
	private GtOrganizationService gtOrganizationService;

	@GetMapping("gtOrganizationSelectAll")
	public String gtOrganizationSelectAll(HttpServletRequest req, Model model, GtEmployeeVO evo) {

//		List<GtEmployeeVO> aList = gtOrganizationService.gtOrganizationSelectAll();

//		log.info("쿼리 갔다왔음");
//
//		if (aList.size() > 0) {
//
//			model.addAttribute("aList", aList);
			return "organization/organizationSelectAll";
//		} else {
//			return "organization/fail";
//		}
	}
	
	@GetMapping(value = "gtAdminSelectAll")
	public String gtAdminSelectAll() {
		
		
		
		return "organization/gtAdminSelectAll";
	}
	
	 @ResponseBody
	 @GetMapping("gtOrganizationSelectAll2") 
	 public Map<String, Object> gtOrganizationSelectAll2(HttpServletRequest req, Model m, GtEmployeeVO evo) {
		Map<String, Object> map = new HashMap<String, Object>();
  	 	Logger log = LogManager.getLogger(GtOrganizationController.class);
  	 	List<GtEmployeeVO> aList =  gtOrganizationService.gtOrganizationSelectAll(evo);
	 	map.put("aList", aList);	  
	 	return map; 
	 }
	
}
