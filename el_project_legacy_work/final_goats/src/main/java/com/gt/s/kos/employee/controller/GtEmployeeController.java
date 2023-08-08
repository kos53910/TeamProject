package com.gt.s.kos.employee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gt.s.common.ChabunUtil;
import com.gt.s.common.CommonUtils;
import com.gt.s.common.DateFormatUtil;
import com.gt.s.common.FileUploadUtil;
import com.gt.s.common.ImgUploadUtil;
import com.gt.s.common.chabun.service.GtChabunService;
import com.gt.s.kos.contract.vo.GtContractVO;
import com.gt.s.kos.employee.service.GtEmployeeService;
import com.gt.s.kos.employee.vo.GtEmployeeVO;


@Controller
public class GtEmployeeController {
	
	Logger log = LogManager.getLogger(GtEmployeeController.class);
	String chabun;
	
	@Autowired(required = false)
	private GtEmployeeService gtEmployeeService;
	
	@Autowired(required = false)
	private GtChabunService gtChabunService;
	
	
	@GetMapping(value = "goatsEmployeeSelect", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String goatsEmployeeSelect(@RequestParam("dept")String dept, GtEmployeeVO evo) {

		String row = "";
		String total = "";
		evo.setGedept(dept);
		
		System.out.println("detp >>> : " + dept);
	
		System.out.println("evo.getDept(dept) >>> : " + evo.getGedept());
		
		
		List<GtEmployeeVO> list = gtEmployeeService.goatsEmployeeSelect(evo);
		
		
		
		for(int i = 0 ; i < list.size() ; i++) {
			
			GtEmployeeVO evo_ = list.get(i);
			
			row = evo_.getGename()+","+evo_.getTitle()+","+evo_.getGedept();
			
			total += row + "/";
			
			
			
		}
		
		System.out.println("total >> >: "+ total);

		return total;
		
		
	} // end of goatsEmployeeSelect
	
	@GetMapping("employeeInsertForm")
	public String gtEmployeeInsertForm() {
		
		return "employee/employeeInsertForm";
	}
	
	
	@GetMapping("gtEmployeeIdcheck")
	@ResponseBody
	public String gtEmployeeIdcheck(GtEmployeeVO evo) {
		List<GtEmployeeVO> list = gtEmployeeService.gtEmployeeIdcheck(evo);
		
		String id = "";
		if (list.size() > 0 ) {
			id = "ID_NO";
			return id;
		}
		
		id = "ID_YES";
		
			return id;
	}
	
	@GetMapping("getGtEmployeeChabun")
	@ResponseBody
	public String getGtEmployeeChabun(GtEmployeeVO evo) {
		
		String genum = ChabunUtil.BIZ_GUBUN_GE.concat(DateFormatUtil.ymdFormats("D")).concat(gtChabunService.getGtEmployeeChabun().getGenum());

		
		return genum;
	}
	
	
	@GetMapping("gtEmployeeInsert")
	@ResponseBody
	public String gtEmployeeInsert(GtEmployeeVO evo, HttpServletRequest req, Model m) {
		
		this.chabun = null;
		this.chabun = evo.getGenum();
		
		
		int nCnt = gtEmployeeService.gtEmployeeInsert(evo);
		
		if(nCnt > 0) {
			
			
			return "OK";
		}
		
			return "NO";
	}
	
	
	@PostMapping("gtEmployeeFileInsert")
	public String gtEmployeeFileInsert(@RequestParam("gephoto") ArrayList<MultipartFile> files) {
		
		log.info("genum >>> :" + this.chabun);

		String fileNames = FileUploadUtil.fileupload(files, this.chabun, CommonUtils.GE_FILE_UPLOAD_PATH);
		log.info("fileNames > : " + fileNames);
		GtEmployeeVO evo = null;
		evo = new GtEmployeeVO();
		evo.setGenum(this.chabun);
		evo.setGephoto(fileNames);
		log.info("gvo.getGcnum() > : " + evo.getGenum());
		log.info("gvo.getGcfile() > : " + evo.getGephoto());
		
		log.info(evo.getGenum());

		int nCnt = gtEmployeeService.gtEmployeeFileInsert(evo);
		if (nCnt > 0) {

			return "employee/employeeInsertForm";

		} else {
			return "employee/employeeInsertForm";
		}
		
	}
	
	@GetMapping(value = "gtEmployeeDecianotherSelect", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String gtEmployeeDecianotherSelect(@RequestParam("dept")String dept,@RequestParam("genum")String genum, GtEmployeeVO evo) {
		
		String row = "";
		String total = "";
		evo.setGedept(dept);
		evo.setGenum(genum);
		
		System.out.println("detp >>> : " + dept);
	
		System.out.println("evo.getDept(dept) >>> : " + evo.getGedept());
		
		
		List<GtEmployeeVO> list = gtEmployeeService.gtEmployeeDecianotherSelect(evo);
		
		
		
		for(int i = 0 ; i < list.size() ; i++) {
			
			GtEmployeeVO evo_ = list.get(i);
			
			row = evo_.getGename()+","+evo_.getTitle()+","+evo_.getGedept();
			
			total += row + "/";
			
			
		}
		
		System.out.println("total >> >: "+ total);

		return total;
	}
	
	@GetMapping(value = "gtEmployeeSelect")
	public String gtEmployeeSelect(GtEmployeeVO evo, Model m) {
		log.info(evo.getGenum());
		
		List<GtEmployeeVO> list = gtEmployeeService.gtEmployeeSelect(evo);
		if(list != null && list.size() > 0) {
			log.info("list.size() > : " + list.size());
			m.addAttribute("list", list);
			return "employee/gtEmployeeSelect";
		}else {
			return "employee/fail";
		}
	}

	@GetMapping(value = "gtEmployeeUpdate")
	public String gtEmployeeUpdate(GtEmployeeVO evo) {
		log.info("gtEmployeeUpdate() >>> : ");
		if(evo.getNotiyn() == null) {
			evo.setNotiyn("N");
		}
		if(evo.getApryn() == null) {
			evo.setApryn("N");
		}
		log.info("evo.getApryn() >>> : " + evo.getApryn());
		log.info("evo.getNotiyn() >>> : " + evo.getNotiyn());
		log.info("evo.getSalary() >>> : " + evo.getSalary());
		int nCnt = gtEmployeeService.gtEmployeeUpdate(evo);
		if(nCnt > 0) {
			return "employee/updateOK";
		}else {
			return "employee/updateX";
		}
	}
	
}
