package com.gt.s.kos.business.contoller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.gt.s.common.CodeUtil;
import com.gt.s.common.CommonUtils;
import com.gt.s.common.DateFormatUtil;
import com.gt.s.common.FileUploadUtil;
import com.gt.s.common.K_Session;
import com.gt.s.common.chabun.service.GtChabunService;
import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.business.service.GtBusinessService;
import com.gt.s.kos.business.vo.GtBusinessVO;
import com.gt.s.kos.employee.service.GtEmployeeService;
import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.project.service.GtProjectService;
import com.gt.s.kos.project.vo.GtProjectVO;



@Controller
public class GtBusinessController {

	private String gbtnum;
	
	Logger log = LogManager.getLogger(GtBusinessController.class);
	
	@Autowired(required = false)
	private GtBusinessService gtBusinessService;
	
	@Autowired(required = false)
	private GtEmployeeService gtEmployeeService;
	

	@Autowired(required = false)
	private GtChabunService gtChabunService;
	
	@Autowired(required = false)
	private GtProjectService gtProjectService;
	
	@GetMapping("gtBusinessInsertForm")
	public String gtBusinessInsertForm(HttpServletRequest req, Model m, GtEmployeeVO evo) {
		
		K_Session ks = K_Session.getInstance();
		
		String kID = ks.getSession(req);
		
		log.info("kID >>>>> : "+kID);
		
		if(kID != null) {
		
		evo.setGenum(kID);
		
		GtEmployeeVO list = gtEmployeeService.gecheck(evo);
		
		m.addAttribute("gename", list.getGename());
		m.addAttribute("dept", list.getGedept());
		m.addAttribute("title", list.getTitle());
		m.addAttribute("genum", kID);
		
		return "business/businessInsertForm";
		
		}else {
			
			return  "login/loginX";
			
		}
		
	}
	
	@GetMapping("gtBusinessInsert")
	@ResponseBody
	public String gtBusinessInsert(GtBusinessVO buvo, Model m, HttpServletRequest req) {
		
		this.gbtnum = null;
		
		this.gbtnum = buvo.getGbtnum();
		
		String gdr_approver1 = req.getParameter("approver1");
		String gdr_approver2 = req.getParameter("approver2");
		String gdr_approver3 = req.getParameter("approver3");
		String gdr_approver4 = req.getParameter("approver4");
		String gdr_approver5 = req.getParameter("approver5");
		
		String gdr_approver = gdr_approver1 + "/" + gdr_approver2 + "/" + gdr_approver3 + "/" + gdr_approver4 + "/" + gdr_approver5 + "/"; 
		
		String gdr_dept1 = req.getParameter("dept1");
		String gdr_dept2 = req.getParameter("dept2");
		String gdr_dept3 = req.getParameter("dept3");
		String gdr_dept4 = req.getParameter("dept4");
		String gdr_dept5 = req.getParameter("dept5");
		
		String gdr_dept = gdr_dept1 + "/" + gdr_dept2 + "/" + gdr_dept3 + "/" + gdr_dept4 + "/" + gdr_dept5 + "/"; 
		log.info(gdr_approver);
		
		
		buvo.setApprover(gdr_approver);
		buvo.setDept(gdr_dept);
		
		log.info(" >>> : " + gdr_approver);
		log.info(">>> : " + buvo.getGenum());
		log.info(">>>:"+  buvo.getGbtnum());
		log.info(">>>:"+  buvo.getGbtname());
		log.info(">>>> : " + buvo.getGbttotalprice());
		log.info(">>> : " + buvo.getReference());
		log.info(">>> : " + buvo.getWriter());
		
		int nCnt = gtBusinessService.gtBusinessInsert(buvo);
		
		String str = "";
		
		  if(nCnt > 0 ) { 
		 
		  	str = "OK";
		 }else {
			 str = "NO";
		 }
		 		
		return str;
	}
	
	@GetMapping("gtBusinessChanbun")
	@ResponseBody
	public String gtBusinessChanbun() {
		
		String gbt_num = ChabunUtil.BIZ_GUBUN_BU.concat(DateFormatUtil.ymdFormats("D")).concat(gtChabunService.getGtBusinessChabun().getGbtnum());
		
		return gbt_num;
	}
	
	@PostMapping("gtBusinessInsertFile")
	public String gtBusinessInsertFile(@RequestParam("gbtfile") ArrayList<MultipartFile> files) {
		
		log.info("gtBusinessInsertFile() >>> : ");

		String fileNames = FileUploadUtil.fileupload(files, this.gbtnum, CommonUtils.BU_FILE_UPLOAD_PATH);
		log.info("fileNames > : " + fileNames);
		GtBusinessVO buvo = null;
		buvo = new GtBusinessVO();
		buvo.setGbtnum(this.gbtnum);
		buvo.setGbtfile(fileNames);
		log.info("svo.getGsnum() > : " + buvo.getGbtnum());
		log.info("svo.getGsfile() > : " + buvo.getGbtfile());
				
		int nCnt = gtBusinessService.gtBusinessInsertFile(buvo);
		if (nCnt > 0) {
			List<GtBusinessVO> list = gtBusinessService.gtBusinessSelect(buvo);
			buvo = list.get(0);
			String num = buvo.getGbtnum();
			String subject = buvo.getGbtname();
			String writer = buvo.getWriter();
			String date = buvo.getInsertdate();
			log.info("date > : " + date);
			String app = buvo.getApprover();
			String count = buvo.getCount();
			String s = CodeUtil.edsmcheck(app, Integer.parseInt(count));
			if(!s.equals("OK")) {
				GtEmployeeVO evo = null;
				evo = new GtEmployeeVO();
				evo.setGename(s);
				String email = gtEmployeeService.emailcheck(evo).getGeemail();
				CodeUtil.googlemail(num, subject, writer, date, email);
			}
			return "business/businessInsert";
			
		}else {
			return "business/fail";
		}
		
	}
	
	@GetMapping("gtBusinessSelectAll")
	public String gtBusinessSelectAll(HttpServletRequest req, Model m, GtBusinessVO buvo) {
		GtBusinessVO _buvo = new GtBusinessVO();

		 _buvo.setKeyword(buvo.getKeyword());
		 _buvo.setSearchfilter(buvo.getSearchfilter());
		 
		
		List<GtBusinessVO> aList = gtBusinessService.gtBusinessSelectAll(buvo);
		List<GtBusinessVO> aListBU = new ArrayList<GtBusinessVO>();
		List<GtProjectVO> aListPRB = new ArrayList<GtProjectVO>();
		log.info(aList.size());
		String gpnum = "";
		
		for(int i = 0; i < aList.size(); i++) {
			
			GtBusinessVO bvo = aList.get(i);
			GtProjectVO pvo = null;
			pvo = new GtProjectVO();
			
			GtProjectVO _pvo = null;
			_pvo = new GtProjectVO();

			System.out.println(i);
			if(Integer.parseInt(bvo.getCount()) >= 10 ) {
				
				gpnum = bvo.getGpnum();
				
				pvo.setGpnum(gpnum);
				log.info("gbt num >>>> " + bvo.getGbtnum());
				
				List<GtProjectVO> aListPR = gtProjectService.gtProjectSelect(pvo);
				_pvo = aListPR.get(0);
				
				aListBU.add(bvo);
				aListPRB.add(_pvo);
				
			}else if(CodeUtil.edsmcheck(bvo.getApprover(), 
										Integer.parseInt(bvo.getCount())).equals("OK") || CodeUtil.edsmcheck(bvo.getApprover(), 
										Integer.parseInt(bvo.getCount())).equals("-")) {
				
				log.info("gbt num >>>> " + bvo.getGbtnum());
				
				
				gpnum = bvo.getGpnum();
				log.info("gpnum >>>> : " + gpnum);
				
				pvo.setGpnum(gpnum);
				log.info("gbt num >>>> " + bvo.getGbtnum());
				
				List<GtProjectVO> aListPR = gtProjectService.gtProjectSelect(pvo);
				
				_pvo = aListPR.get(0);
				
				aListBU.add(bvo);
				aListPRB.add(_pvo);
				
			}	
			
			
		}	
		
		if (aListBU != null) {
			
			m.addAttribute("aListBU", aListBU);
			m.addAttribute("_buvo", buvo);
			m.addAttribute("aListPRB", aListPRB);
			return "business/businessSelectAll";
			
		}else {
			
			return "business/fail";
		}
		
	}
	
	@GetMapping("gtBusinessSelect")
	public String gtBusinessSelect(HttpServletRequest req, Model m, GtApprovalLineVO avo) {
		
		GtBusinessVO buvo = null;
		buvo= new GtBusinessVO();

		buvo.setGbtnum(avo.getAppnum());
		
		List<GtBusinessVO> list = gtBusinessService.gtBusinessSelect(buvo);
		log.info(list.get(0).getGpnum());
		
		if(list.size() > 0) {
				
			buvo = list.get(0);
			GtProjectVO pvo = new GtProjectVO();
			pvo.setGpnum(buvo.getGpnum());
			List<GtProjectVO> list_P = gtProjectService.gtProjectsubject(pvo);
			buvo.setGpnum(list_P.get(0).getGpname());
			log.info("결재일 >>>> : " + buvo.getProval());
			m.addAttribute("buvo",buvo);
			
			return "business/businessSelect";

		}else {
			
			return "business/fail";
		}
		
	}
	
	
	@GetMapping("gtBusinessUpdate")
	public String gtBusinessUpdate(HttpServletRequest req, Model model, GtBusinessVO buvo) {
		
		int nCnt = gtBusinessService.gtBusinessUpdate(buvo);
		
		if(nCnt > 0) {
			
			return "business/sellectAll";
			
		}else {
			
			return "business/fail";
		}

	}
	
	@GetMapping(value="busineesfileDownloadList", produces="application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String fileDownloadList(HttpServletRequest q) {
		
		
		String num = q.getParameter("gbtnum");
		log.info(num);
		String reString = "";
		
		try {
			
			File path = new File(CommonUtils.BU_FILE_UPLOAD_PATH + "//" + num);
			String[] fileList = path.list();
			for(int i=0; i<fileList.length; i++) {
				reString += fileList[i] + ",";
			}
			
		} catch (Exception e) {
			log.info("파일 리스트 에러 >>> : " + e.getMessage());
			// TODO: handle exception
		}
		
		return reString;
	}
	
	@GetMapping("businessfileDownload")
	public void fileDownload(@RequestParam String file, @RequestParam String num, HttpServletRequest q, HttpServletResponse s) {
		s.setContentType("text/html; charset=UTF-8");
		log.info("file > :" + file);
		log.info("gbtnum > :" + num);
		
		boolean b = FileUploadUtil.filedownload(s, q, num, file, CommonUtils.BU_FILE_UPLOAD_PATH);
		
	}
	
}
