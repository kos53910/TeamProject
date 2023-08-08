package com.gt.s.kos.spend.controller;



import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.web.servlet.ModelAndView;

import com.gt.s.common.ChabunUtil;
import com.gt.s.common.CodeUtil;
import com.gt.s.common.CommonUtils;
import com.gt.s.common.DateFormatUtil;
import com.gt.s.common.FileUploadUtil;
import com.gt.s.common.K_Session;
import com.gt.s.common.chabun.service.GtChabunService;
import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.business.vo.GtBusinessVO;
import com.gt.s.kos.employee.service.GtEmployeeService;
import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.project.service.GtProjectService;
import com.gt.s.kos.project.vo.GtProjectVO;
import com.gt.s.kos.spend.service.GtSpendService;
import com.gt.s.kos.spend.vo.GtSpendVO;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

@Controller
public class GtSpendController {
	
	private String gsnum = "";

	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired(required = false)
	private GtSpendService gtSpendService;
	
	@Autowired(required = false)
	private GtChabunService gtChabunService;
	
	@Autowired(required = false)
	private GtEmployeeService gtEmployeeService;
	
	@Autowired(required = false)
	private GtProjectService gtProjectService;
	
	@GetMapping(value = "spendInsertForm")
	public String spendInsertForm(HttpServletRequest q, GtSpendVO gvo, Model m, GtEmployeeVO evo) {
		
		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(q);
		if(genum != null) {
			evo.setGenum(genum);
			evo = gtEmployeeService.gecheck(evo);
			String gsname = evo.getGedept() + " " + evo.getGename() + " " + evo.getTitle();
			String gsnum = ChabunUtil.BIZ_GUBUN_SP + DateFormatUtil.ymdFormat() + gtChabunService.getGtSpendChabun().getGsnum();
			log.info("gsnum >> : " + gsnum);
				m.addAttribute("genum", genum);
				m.addAttribute("gsnum", gsnum);
				m.addAttribute("gsname", gsname);
				return "spend/spendinsertForm";

		}else {
			return "login/loginX";
		}
	}
		
		
		@GetMapping(value = "gtSpendInsert")
		@ResponseBody
		public String gtSpendInsert(GtSpendVO svo, Model m, HttpServletRequest req) {
			
			this.gsnum = null;
			
			this.gsnum = svo.getGsnum();
			svo.setGenum(req.getParameter("genum"));
			log.info("svo.getGenum() >>> : " + svo.getGenum());
			log.info("svo.getGsnum() > : " + svo.getGsnum());
			log.info("svo.getGssubject() > : " + svo.getGssubject());
			log.info("svo.getGpnum() > : " + svo.getGpnum());
			log.info("svo.getGsdate() > : " + svo.getGsdate());
			log.info("svo.getGsgubun() > : " + svo.getGsgubun());
			log.info("svo.getGsaccount() > : " + svo.getGsaccount());
			log.info("svo.getGsinfo() > : " + svo.getGsinfo());
			log.info("svo.getGscount() > : " + svo.getGscount());
			log.info("svo.getGscost() > : " + svo.getGscost());
			log.info("svo.getGenum() > : " + svo.getGenum());
			log.info("svo.getWriter() > : " + svo.getWriter());
			log.info("svo.getReference() > : " + svo.getReference());
			log.info("svo.getApprover() > : " + svo.getApprover());
			log.info("svo.getDept() > : " + svo.getDept());
			
			svo.setGsfile("123");

			
			int nCnt = gtSpendService.gtSpendInsert(svo);
			
			String str = "";
			
			  if(nCnt > 0 ) { 
			 
			  	str = "OK";
			 }else {
				 str = "NO";
			 }
			 		
			return str;
		}
	
		@PostMapping(value = "gtSpendFileupload")
		public String gtSpendFileupload(@RequestParam("gsfile") ArrayList<MultipartFile> files) {

			log.info("gtSpendFileupload() >>> : ");

			String fileNames = FileUploadUtil.fileupload(files, this.gsnum, CommonUtils.SP_FILE_UPLOAD_PATH);
			log.info("fileNames > : " + fileNames);
			GtSpendVO svo = null;
			svo = new GtSpendVO();
			svo.setGsnum(this.gsnum);
			svo.setGsfile(fileNames);
			log.info("svo.getGsnum() > : " + svo.getGsnum());
			log.info("svo.getGsfile() > : " + svo.getGsfile());
			
			log.info(svo.getGsnum());
			
			int nCnt = gtSpendService.gtSpendInsertFile(svo);
			if (nCnt > 0) {
				List<GtSpendVO> list = gtSpendService.gtSpendSelect(svo);
				svo = list.get(0);
				String num = svo.getGsnum();
				String subject = svo.getGssubject();
				String writer = svo.getWriter();
				String date = svo.getInsertdate();
				log.info("date > : " + date);
				String app = svo.getApprover();
				String count = svo.getCount();
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
		
		@GetMapping(value = "gtSpendSelect")
		public String gtSpendSelect(GtApprovalLineVO avo, Model m, HttpServletRequest q) {
			
			log.info("svo.getGsnum() > : " + avo.getAppnum());
			GtSpendVO svo = null;
			svo = new GtSpendVO();
			svo.setGsnum(avo.getAppnum());
			List<GtSpendVO> list = gtSpendService.gtSpendSelect(svo);
			svo = list.get(0);
			GtProjectVO pvo = new GtProjectVO();
			pvo.setGpnum(svo.getGpnum());
			List<GtProjectVO> list_P = gtProjectService.gtProjectsubject(pvo);
			svo.setGpnum(list_P.get(0).getGpname());
			m.addAttribute("svo", svo);
			
			return "spend/spendselect";
		}
		
	    @GetMapping(value = "fileDownloadlist", produces = "application/x-www-form-urlencoded;charset=UTF-8")
	    @ResponseBody
	    public String fileDownloadList(HttpServletRequest q) {
	    	
	    	String num = q.getParameter("gsnum");
	    	String reString = "";
	        // 폴더에 있는 전체 파일 목록 가져오기
	    	try {
		        File path = new File(CommonUtils.SP_FILE_UPLOAD_PATH + "//" + num);
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
	    @GetMapping(value = "fileDownload")
	    public void fileDownload(@RequestParam String file, @RequestParam String num, HttpServletResponse s, HttpServletRequest q) {
	    	s.setContentType("text/html; charset=UTF-8");
	    	log.info("file > : " + file);
	    	log.info("gsnum > : " + num);
	    	
	    	boolean b = FileUploadUtil.filedownload(s, q, num, file, CommonUtils.SP_FILE_UPLOAD_PATH);
	    	
	    	log.info("b > : " + b);
	    }
	    
	    @GetMapping(value = "testdownload")
	    public String testdownload() {
	    	
	    	log.info("testdownload() > : ");
	    	
	    	return "spend/spendselect";
	    }
}
