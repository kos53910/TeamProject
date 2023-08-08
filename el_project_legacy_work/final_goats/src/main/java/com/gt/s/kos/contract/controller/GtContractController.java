package com.gt.s.kos.contract.controller;

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
import com.gt.s.common.ImgUploadUtil;
import com.gt.s.common.K_Session;
import com.gt.s.common.chabun.service.GtChabunService;
import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.contract.service.GtContractService;
import com.gt.s.kos.contract.vo.GtContractVO;
import com.gt.s.kos.draft.vo.GtDraftVO;
import com.gt.s.kos.employee.service.GtEmployeeService;
import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.spend.vo.GtSpendVO;

@Controller
public class GtContractController {
	
	private String chabun;
	
	Logger log = LogManager.getLogger(GtContractController.class);
	
	@Autowired(required = false)
	private GtContractService gtContractService;
	
	@Autowired(required = false)
	private GtChabunService gtChabunService;

	@Autowired(required = false)
	private GtEmployeeService gtEmployeeService;
	
	// InsertForm
	@GetMapping("gtContractInsertForm")
	public String gtContractInsertForm(Model m, GtEmployeeVO evo, HttpServletRequest req, GtContractVO cvo) {

		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(req);
		if(genum != null) {
			evo.setGenum(genum);
			evo = gtEmployeeService.gecheck(evo);
			String gcname = evo.getGedept() + " " + evo.getGename() + " " + evo.getTitle();
				m.addAttribute("genum", genum);
				m.addAttribute("gcname", gcname);
				return "contract/contractInsertForm";

		}else {
			return "login/loginX";
		}
	}

	// Insert
	@GetMapping("contractInsert")
	@ResponseBody
	public String contractInsert(Model m, GtContractVO gcvo, HttpServletRequest req) {
		
		this.chabun = null;
		this.chabun = gcvo.getGcnum();

		log.info(gcvo.getGcnum());
		log.info(gcvo.getGcsubject());
		log.info(gcvo.getGcsalplace());
		log.info(gcvo.getGcpurchase());
		log.info(gcvo.getGccontent());
		String conform1 = ""; 
		String[] conform = req.getParameterValues("gcconform");
		if(conform != null) {
			for(int i=0; i<conform.length; i++) {
				conform1 += conform[i] + ",";
			}
			gcvo.setGcconform(conform1);
		}
		log.info(gcvo.getGcconform());
		log.info(gcvo.getGcsalitem());
		log.info(gcvo.getGcsalquantity());
		log.info(gcvo.getGcsalamount());
		log.info(gcvo.getGcpuritem());
		log.info(gcvo.getGcpuramount());
		log.info(gcvo.getGcattach());
		log.info(gcvo.getGcsign());
		log.info(gcvo.getWriter());
		log.info(gcvo.getReference());
		log.info(gcvo.getApprover());
		log.info(gcvo.getDept());

		int nCnt = gtContractService.gtContractInsert(gcvo);

		String str = "";

		if (nCnt > 0) {

			str = "OK";
		} else {
			str = "NO";
		}

		return str;
	}

	// Chabun
	@GetMapping("getGtContractChabun")
	@ResponseBody
	public String getGtDraftChabun() {

		String gcnum = ChabunUtil.BIZ_GUBUN_CO.concat(DateFormatUtil.ymdFormats("D"))
				.concat(gtChabunService.getGtContractChabun().getGcnum());

		return gcnum;
	}

	// InsertFile
	@PostMapping("contractInsertFile")
	public String contractInsertFile(@RequestParam("gdrfile") ArrayList<MultipartFile> files) {
		
		log.info("gcnum >>> :" + this.chabun);

		String fileNames = FileUploadUtil.fileupload(files, this.chabun, CommonUtils.CO_FILE_UPLOAD_PATH);
		log.info("fileNames > : " + fileNames);
		GtContractVO gvo = null;
		gvo = new GtContractVO();
		gvo.setGcnum(this.chabun);
		gvo.setGcfile(fileNames);
		log.info("gvo.getGcnum() > : " + gvo.getGcnum());
		log.info("gvo.getGcfile() > : " + gvo.getGcfile());
		
		log.info(gvo.getGcnum());

		int nCnt = gtContractService.gtContractInsertFile(gvo);
		if (nCnt > 0) {
			List<GtContractVO> list = gtContractService.gtContractSelect(gvo);
			gvo = list.get(0);
			String num = gvo.getGcnum();
			String subject = gvo.getGcsubject();
			String writer = gvo.getWriter();
			String date = gvo.getInsertdate();
			log.info("date > : " + date);
			String app = gvo.getApprover();
			String count = gvo.getCount();
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

	// select
	@GetMapping(value = "gtContractSelect")
	public String gtContractSelect(GtApprovalLineVO avo, Model m, HttpServletRequest q) {

		log.info("svo.getGsnum() > : " + avo.getAppnum());
		GtContractVO gcvo = null;
		gcvo = new GtContractVO();
		gcvo.setGcnum(avo.getAppnum());
		List<GtContractVO> list = gtContractService.gtContractSelect(gcvo);
		gcvo = list.get(0);
		m.addAttribute("cvo", gcvo);

		return "contract/contractSelect";
	}

	
	  @GetMapping(value = "gtContractFileDownloadlist", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	  
	  @ResponseBody public String gtContractFileDownloadlist(HttpServletRequest q) {
	  
	  String num = q.getParameter("gcnum"); String reString = ""; // 폴더에 있는 전체 파일
	   try { 
		   File path = new File(CommonUtils.CO_FILE_UPLOAD_PATH + "//" + num); 
		   String[] fileList = path.list(); 
		   
		   for(int i=0; i<fileList.length; i++) {
			   
			   			reString += fileList[i] + ","; } }
	   catch(Exception e) {
	  log.info("파일 리스트 에러 >> : " + e.getMessage()); }
	  
	  
	  return reString;
	  
	  }
	  
	  // 파일 다운로드 처리
	  
	  @GetMapping(value = "gtContractFileDownload") 
	  public void gtContractFileDownload(@RequestParam
	  String file, @RequestParam String num, HttpServletResponse s,
	  HttpServletRequest q) { s.setContentType("text/html; charset=UTF-8");
	  log.info("file > : " + file); log.info("gsnum > : " + num);
	  
	  boolean b = FileUploadUtil.filedownload(s, q, num, file,
	  CommonUtils.CO_FILE_UPLOAD_PATH);
	  
	  log.info("b > : " + b); }
	 

	@PostMapping(value = "gtContractFileupload")
	public String gtContractFileupload(@RequestParam("gcfile") ArrayList<MultipartFile> files) {

		log.info("gtSpendFileupload() >>> : ");

		String fileNames = FileUploadUtil.fileupload(files, this.chabun, CommonUtils.CO_FILE_UPLOAD_PATH);
		log.info("fileNames > : " + fileNames);
		GtContractVO cvo = null;
		cvo = new GtContractVO();
		cvo.setGcnum(this.chabun);
		cvo.setGcfile(fileNames);
		log.info("cvo.getGsnum() > : " + cvo.getGcnum());
		log.info("cvo.getGsfile() > : " + cvo.getGcfile());

		log.info(cvo.getGcnum());

		int nCnt = gtContractService.gtContractInsertFile(cvo);
		if (nCnt > 0) {
			/*
			 * List<GtContractVO> list = gtContractService.gtContractSelect(cvo); cvo =
			 * list.get(0); String num = cvo.getGcnum(); String subject =
			 * cvo.getGcsubject(); String writer = cvo.getWriter(); String date =
			 * cvo.getInsertdate(); log.info("date > : " + date); String app =
			 * cvo.getApprover(); String count = cvo.getCount(); String s =
			 * CodeUtil.edsmcheck(app, Integer.parseInt(count)); if(!s.equals("OK")) {
			 * GtEmployeeVO evo = null; evo = new GtEmployeeVO(); evo.setGename(s); String
			 * email = gtEmployeeService.emailcheck(evo).getGeemail();
			 * CodeUtil.googlemail(num, subject, writer, date, email);
			 */
			/* } */
			return "contract/contractInsert";

		} else {
			return "contract/fail";
		}

	}
		
		// 파일업로드 리스트
	    @GetMapping(value = "gcfileDownloadlist", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	    @ResponseBody
	    public String fileDownloadList(HttpServletRequest q) {
	    
	    	String num = q.getParameter("gcnum");
	    	String reString = "";
	        // 폴더에 있는 전체 파일 목록 가져오기
	    	try {
		        File path = new File(CommonUtils.CO_FILE_UPLOAD_PATH + "//" + num);
		        String[] fileList = path.list();
		        for(int i=0; i<fileList.length; i++) {
		        	reString += fileList[i] + ",";
		        }
	    	}catch(Exception e) {
	    		log.info("파일 리스트 에러 >> : " + e.getMessage());
	    	}
	
	        
	        return reString;
	
	    }
	    
	    
	    // 파일 다운로드 처리
	    @GetMapping(value = "gcfileDownload")
	    public void fileDownload(@RequestParam String file, @RequestParam String num, HttpServletResponse s, HttpServletRequest q) {
	    	s.setContentType("text/html; charset=UTF-8");
	    	log.info("file > : " + file);
	    	log.info("gsnum > : " + num);
	    	
	    	boolean b = FileUploadUtil.filedownload(s, q, num, file, CommonUtils.CO_FILE_UPLOAD_PATH);
	    	
	    	log.info("b > : " + b);
	    }
	    
}
