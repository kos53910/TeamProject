package com.gt.s.kos.approvalline.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gt.s.kos.approvalline.service.GtApprovallineService;
import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;


@Controller
public class GtApprovalLineController {
	Logger logger = LogManager.getLogger(GtApprovalLineController.class);
	
	@Autowired(required = false)
	private GtApprovallineService gtApprovallineService;
	
	
	@GetMapping("SelectAll")
	public String goatApprovallineSelectAll(GtApprovalLineVO gvo, Model model) {
		logger.info("goatApprovallineSelectAll 함수 진입");
		System.out.println("123");
		
		List<GtApprovalLineVO> list = gtApprovallineService.goatApprovalOCSelectAll();
		
		
		
		logger.info("list.size >>> :" + list.size());
		
		model.addAttribute("list", list);
		
		
		return "select";
		
	} // end of goatProjectSelectAll
	
} // end of class
