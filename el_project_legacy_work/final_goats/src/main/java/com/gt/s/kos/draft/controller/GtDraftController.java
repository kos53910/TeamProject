package com.gt.s.kos.draft.controller;

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
import com.gt.s.kos.contract.vo.GtContractVO;
import com.gt.s.kos.draft.service.GtDraftService;
import com.gt.s.kos.draft.vo.GtDraftVO;
import com.gt.s.kos.employee.service.GtEmployeeService;
import com.gt.s.kos.employee.vo.GtEmployeeVO;

@Controller
public class GtDraftController {

	String chabun = "";
	
	Logger log = LogManager.getLogger(this.getClass());
	
	private String gdrnum = "";
	
	@Autowired(required = false)
	private GtDraftService gtDraftService;
	
	@Autowired(required = false)
	private GtChabunService gtChabunService;
	
	@Autowired(required = false)
	private GtEmployeeService gtEmployeeService;
	
	@GetMapping("draftInsertForm")
	public String draftInsertForm(HttpServletRequest q, GtEmployeeVO evo, GtDraftVO gvo, Model m) {
		
		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(q);
		if(genum != null) {
			evo.setGenum(genum);
			evo = gtEmployeeService.gecheck(evo);
			String gsname = evo.getGedept() + " " + evo.getGename() + " " + evo.getTitle();
			log.info("gsname : " + gsname);
			log.info("genum : " + genum);
				m.addAttribute("gsname", gsname);
				m.addAttribute("genum", genum);
				return "draft/draftInsertForm";
		}	
		return "login/loginX";
	}

	
	@GetMapping("draftInsert")
	@ResponseBody
	public String draftInsert(Model m, GtDraftVO gvo, HttpServletRequest req) {
							
		this.gdrnum = null;

		this.gdrnum = gvo.getGdrnum();

		
		String insertdate = req.getParameter("insertdate");
		
		String gdrapprover1 = req.getParameter("gdrapprover1");
		String gdrapprover2 = req.getParameter("gdrapprover2");
		String gdrapprover3 = req.getParameter("gdrapprover3");
		String gdrapprover4 = req.getParameter("gdrapprover4");
		String gdrapprover5 = req.getParameter("gdrapprover5");	
		
		String approver = gdrapprover1 + "/" + gdrapprover2 + "/" + gdrapprover3 + "/" + gdrapprover4 + "/" + gdrapprover5 + "/"; 
		
		String gdrdept1 = req.getParameter("gdrdept1");
		String gdrdept2 = req.getParameter("gdrdept2");
		String gdrdept3 = req.getParameter("gdrdept3");
		String gdrdept4 = req.getParameter("gdrdept4");
		String gdrdept5 = req.getParameter("gdrdept5");
		
		String dept = gdrdept1 + "/" + gdrdept2 + "/" + gdrdept3 + "/" + gdrdept4 + "/" + gdrdept5 + "/"; 
		log.info("dept : " + dept);
	
		gvo.setApprover(approver);
		gvo.setDept(dept);
		gvo.setInsertdate(insertdate);
				
		int nCnt = gtDraftService.gtDraftInsert(gvo);
		
		String str = "";
			
			if (nCnt > 0) {
				
				str = "OK";
			}else {
				str = "NO";
			}
		
		return str;
	}

	@GetMapping("DraftChanbun")
	@ResponseBody
	public String gtDraftChanbun() {
			
		String gdrnum = ChabunUtil.BIZ_GUBUN_DR.concat(DateFormatUtil.ymdFormats("D")).concat(gtChabunService.getGtDraftChabun().getGdrnum());
			
		return gdrnum;
		}
	
	
	@PostMapping("draftInsertFile")
	public String gtDraftInsertFile(@RequestParam("gdrfile") ArrayList<MultipartFile> files) {
			
		log.info("gdrnum >>> :" + this.gdrnum);

		String fileNames = FileUploadUtil.fileupload(files, this.gdrnum, CommonUtils.DR_FILE_UPLOAD_PATH);
		log.info("fileNames > : " + fileNames);
		GtDraftVO gvo = null;
		gvo = new GtDraftVO();
		gvo.setGdrnum(this.gdrnum);
		gvo.setGdrfile(fileNames);
		log.info("gvo.getGdrnum() > : " + gvo.getGdrnum());
		log.info("gvo.getGdrfile() > : " + gvo.getGdrfile());
		
		log.info(gvo.getGdrnum());
		
		int nCnt = gtDraftService.gtDraftInsertFile(gvo);
		if (nCnt > 0) {
			List<GtDraftVO> list = gtDraftService.gtDraftSelect(gvo);
			gvo = list.get(0);
			String num = gvo.getGdrnum();
			String subject = gvo.getGdrsubject();
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
	
	@GetMapping("gtDraftSelect")
	public String gtDraftSelect(GtApprovalLineVO gavo, Model m, HttpServletRequest req) {
		
		GtDraftVO gdvo = null;
		gdvo = new GtDraftVO();
		gdvo.setGdrnum(gavo.getAppnum());
		List<GtDraftVO> list = gtDraftService.gtDraftSelect(gdvo);
		gdvo = list.get(0);
		m.addAttribute("gdvo", gdvo);
		
		return "draft/draftSelect";
	}
	
    @GetMapping(value = "fileDownloadlistdr", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    @ResponseBody
    public String fileDownloadList(HttpServletRequest q) {
    	
    	String num = q.getParameter("gdrnum");
    	String reString = "";
        // ������ �ִ� ��ü ���� ��� ��������
    	try {
	        File path = new File(CommonUtils.DR_FILE_UPLOAD_PATH + "//" + num);
	        String[] fileList = path.list();
	        for(int i=0; i<fileList.length; i++) {
	        	reString += fileList[i] + ",";
	        }
    	}catch(Exception e) {
    		log.info("���� ����Ʈ ���� >> : " + e.getMessage());
    	}    
        return reString;

    }
    // ���� �ٿ�ε� ó��
    @GetMapping("fileDownloaddr")
    public void fileDownload(@RequestParam String file, @RequestParam String num, HttpServletResponse s, HttpServletRequest q) {
    	s.setContentType("text/html; charset=UTF-8");
    	log.info("file > : " + file);
    	log.info("gdrnum > : " + num);
    	
    	boolean b = FileUploadUtil.filedownload(s, q, num, file, CommonUtils.DR_FILE_UPLOAD_PATH);
    	
    	log.info("b > : " + b);
    }
    
}
