package com.gt.s.kos.vacation.controller;

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
import com.gt.s.kos.employee.service.GtEmployeeService;
import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.spend.vo.GtSpendVO;
import com.gt.s.kos.vacation.service.GtVacationService;
import com.gt.s.kos.vacation.vo.GtVacationVO;

@Controller
public class GtVacationController {
	
	Logger log = LogManager.getLogger(this.getClass());
	
	private String chabun;
	
	@Autowired(required = false)
	private GtVacationService gtVacationService;
	
	@Autowired(required = false)
	private GtChabunService gtChabunService;
	
	@Autowired(required = false)
	private GtEmployeeService gtEmployeeService;
	Process pro = null;
	@GetMapping("gtVacationChanbun")
	@ResponseBody
	public String gtVacationChanbun() {
		
		log.info("test >> :");
		
		String gbt_num = ChabunUtil.BIZ_GUBUN_VA.concat(DateFormatUtil.ymdFormats("D")).concat(gtChabunService.getGtVacationChabun().getGvnum());
		
		return gbt_num;
	}
	
	  @PostMapping("gtVacationInsertFile") // < 파일을 먼저 넣는다. public String
	  public String gtVacationInsertFile(@RequestParam("gvfile") ArrayList<MultipartFile> files) { // 함수는 xml 연결
		  
		  
		  log.info("gtVacationFileupload > : 진입");
		  
		  String fileNames = FileUploadUtil.fileupload(files, this.chabun, CommonUtils.VA_FILE_UPLOAD_PATH);
			log.info("fileNames > : " + fileNames);
			GtVacationVO vvo = null;
			vvo = new GtVacationVO();
			vvo.setGvnum(this.chabun);
			vvo.setGvfile(fileNames);
			log.info("vvo.getGvnum() > : " + vvo.getGvnum());
			log.info("vvo.getGvfile() > : " + vvo.getGvfile());
			
			log.info(vvo.getGvnum());
		  
		  int nCnt = gtVacationService.gtVacationInsertFile(vvo);
			if (nCnt > 0) {
				List<GtVacationVO> list = gtVacationService.gtVacationSelect(vvo);
				vvo = list.get(0);
				String num = vvo.getGvnum();
				String subject = vvo.getGvsubject();
				String writer = vvo.getWriter();
				String date = vvo.getInsertdate();
				log.info("date > : " + date);
				String app = vvo.getApprover();
				String count = vvo.getCount();
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
	
	@GetMapping("gtVacationSelect")
	public String gtVacationSelect(HttpServletRequest req, Model m, GtApprovalLineVO avo) {
		
		GtVacationVO vvo = null;

		avo.getAppnum();
		vvo = new GtVacationVO();
		vvo.setGvnum(avo.getAppnum());
		log.info("로그 >> : " + vvo.getGvnum());	
		List<GtVacationVO> aList = gtVacationService.gtVacationSelect(vvo);
		vvo = aList.get(0);
		System.out.println("셀렉트 조회합니더ㅏ @@@@@@@@@@@@@@@@" + vvo.getGvnum());
		m.addAttribute("vvo", vvo);
			return "vacation/vacationSelect";	
	}
	
	
    @GetMapping(value = "gvfileDownloadlist", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    @ResponseBody
    public String fileDownloadList(HttpServletRequest q) {
    	
    	String num = q.getParameter("gvnum");
    	log.info("num @#@@@@@@@@@@ " + num);
    	String reString = "";
        // 폴더에 있는 전체 파일 목록 가져오기
    	try {
	        File path = new File(CommonUtils.VA_FILE_UPLOAD_PATH + "//" + num);
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
    @GetMapping(value = "gvfileDownload")
    public void fileDownload(@RequestParam String file, @RequestParam String num, HttpServletResponse s, HttpServletRequest q) {
       s.setContentType("text/html; charset=UTF-8");
       log.info("file > : " + file);
       log.info("gsnum > : " + num);
       
       boolean b = FileUploadUtil.filedownload(s, q, num, file, CommonUtils.VA_FILE_UPLOAD_PATH);
       
       log.info("b > : " + b);
    }
	
	@GetMapping("gtVacationUpdate")
	public String gtVacationUpdate(HttpServletRequest req, Model m, GtVacationVO vvo) {
			
			vvo.getGvnum(); 
		
			log.info("로그 >> : " + vvo.getGvnum());

			List<GtVacationVO> aList = gtVacationService.gtVacationSelect(vvo);
			
			aList.get(0).getGvreasons();
			aList.get(0).getGvsubject();
			log.info("로그 >> : " + aList.get(0).getGvreasons());
			log.info("로그 >> : " + aList.get(0).getGvsubject());
			if(aList.size() > 0) {
				
				m.addAttribute("aList", aList);
				return "vacation/vacationUpdate";
			}else {
				return "vacation/fail";
			}
			
		}
		
	

		@GetMapping("gtVacationDelete") 
		public String gtVacationDelete(HttpServletRequest req, GtVacationVO vvo) {
			
			int nCnt = gtVacationService.gtVacationDelete(vvo);
			
			if(nCnt > 0) {
				return "vacation/vacationDelete";
				
			}else {
				return "vacation/fail";
				
			}
		}

	
	@GetMapping("gtVacationInsert")
	@ResponseBody
	public String gtVacationInsert(GtVacationVO vvo, HttpServletRequest req) {
		
		log.info("chabunInsert 진입 > ㅣ:");
		
		this.chabun = null;
		
		this.chabun = vvo.getGvnum();
		
		// VO에 이름이 없어서 req/getParameter해서 값을 세팅해줬다.
		String gvapprover1 = req.getParameter("approver1");
		String gvapprover2 = req.getParameter("approver2");
		String gvapprover3 = req.getParameter("approver3");
		String gvapprover4 = req.getParameter("approver4");
		String gvapprover5 = req.getParameter("approver5");
		// String gehp = req.getParameter("gehp");
		

		String gvapprover = gvapprover1 + "/" + gvapprover2 + "/" + gvapprover3 + "/" + gvapprover4 + "/" + gvapprover5;
		
		log.info(gvapprover);
		String gvdept1 = req.getParameter("dep1");
		String gvdept2 = req.getParameter("dep2");
		String gvdept3 = req.getParameter("dep3");
		String gvdept4 = req.getParameter("dep4");
		String gvdept5 = req.getParameter("dep5");
		
		String gvdetp = gvdept1 + "/" + gvdept2 + "/" + gvdept3 + "/" + gvdept4 + "/" + gvdept5;
		
		String gvwriter = req.getParameter("writer");
		log.info(gvwriter);

		
		// 연락처
		String gvgehp = req.getParameter("gehp");
		log.info("연락처 > : " + gvgehp);
		

		vvo.setApprover(gvapprover);
		vvo.setDept(gvdetp);

		log.info(" >>> : " + gvapprover);
		log.info(" >>> : " + gvdetp);
		
		// 제목, 사유, 구분, 비고
		String gvsubject = vvo.getGvsubject();
		String gvreasons = vvo.getGvreasons();
		String gvtype = vvo.getGvtype();
		String gvmemo = vvo.getGvmemo();
		String gvdays = vvo.getGvdays();
		
		log.info("제목 > : " + gvsubject);
		log.info("사유 > : " + gvreasons);
		log.info("구분 > : " + gvtype);
		log.info("비고 > : " + gvmemo);
		log.info("기간 > : " + gvdays);
		
		
		
		// String 변수 명= vvo.get가져오고싶은 값();
		int nCnt = gtVacationService.gtVacationInsert(vvo);
		
		log.info("nCnt : " + nCnt);

		if(nCnt > 0) {
			// ajax return은 return에 사용한 값이 나옴
			// 원래는 return에 view 페이지 명을 찾아서 갔었음
			
			return "OK";
			
		}else {
			
			return "NO";
		}
		
		
		
	}
	
	@GetMapping("gtVacationSelectAll")
	public String gtVacationSelectAll(Model model,  GtVacationVO gvvo) {
		log.info(">>> gtVacationSelectAll() In");
		
		int pageSize = CommonUtils.VACATION_PAGE_SIZE;
		int groupSize = CommonUtils.VACATION_GROUP_SIZE;
		int curPage = CommonUtils.VACATION_CUR_PAGE;
		int totalCount = CommonUtils.VACATION_TOTAL_COUNT;
		
		if (gvvo.getCurPage() !=null){
			curPage = Integer.parseInt(gvvo.getCurPage());
		}
		
		gvvo.setPageSize(String.valueOf(pageSize));
		gvvo.setGroupSize(String.valueOf(groupSize));
		gvvo.setCurPage(String.valueOf(curPage));
		gvvo.setTotalCount(String.valueOf(totalCount));
		
		List<GtVacationVO> aList = gtVacationService.gtVacationSelectAll(gvvo);
		List<GtVacationVO> list = new ArrayList<GtVacationVO>();
		
		// 결재 완료건만
		for(int i = 0; i < aList.size(); i++) {
			GtVacationVO rvo = aList.get(i);
			System.out.println(i);
			if(Integer.parseInt(rvo.getCount()) >= 10 ) {
				
				log.info("gbt num >>>> " + rvo.getGvnum());
				
				list.add(rvo);
				
			}else if(CodeUtil.edsmcheck(rvo.getApprover(),Integer.parseInt(rvo.getCount())).equals("OK")) {
				log.info("gbt num >>>> " + rvo.getGvnum());
				
				list.add(rvo);
			}	
		}
		
		// 휴가일수 합치기
		for(int j=0; j<list.size(); j++) {
			List<Integer> delList = new ArrayList<>();
			for(int k=j+1; k<list.size(); k++) {
				// 포맷부분
				String str01 = list.get(j).getGenum(); 
				String str02 = list.get(k).getGenum();
				String strDays01 = list.get(j).getGvdays();
				String strDays02 = list.get(k).getGvdays();
				int day01 = Integer.parseInt(strDays01.replace("일", ""));
				int day02 = Integer.parseInt(strDays02.replace("일", ""));
				// 순차적으로 비교해서 같으면 합
				if(str01.equals(str02)) {
					log.info(">>> days : " + (day01+day02));
					String sumDays = String.valueOf(day01+day02);
					list.get(j).setGvdays(sumDays);
					delList.add(k);
				}
			}
			// 같은 사원의 정보 삭제
			int l=0;
			for(int s:delList) {
				list.remove(s+(l--));
			}
		}
		
			
			model.addAttribute("aList", list);
			model.addAttribute("pagingVVO", gvvo);
			
			return "vacation/vacationSelectAll";
			
	} // end of gtVactionSelectAll()
	
	@GetMapping(value = "gtVacationInsertForm")
	public String gtVacationInsertForm(HttpServletRequest q, GtVacationVO vvo, Model m, GtEmployeeVO evo) {
		
		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(q);
		
		
		if(genum != null) {
			evo.setGenum(genum);
			evo = gtEmployeeService.gecheck(evo);
			String gename = evo.getGedept() + " " + evo.getGename() + " " + evo.getTitle();
			String gehp = evo.getGehp();
			
			
			log.info(gename);
			log.info(evo.getGename());
			log.info(evo.getGedept());
			log.info(evo.getTitle());
			log.info(evo.getGehp());
			
			m.addAttribute("gename", gename);
			m.addAttribute("gehp", gehp);
			m.addAttribute("genum", genum);
			
			return "vacation/vacationInsertForm";
		}else {
			return "vacation/fail";
		}
		
	
	}
	@GetMapping("gtVacationSelect_")
	public String gtVacationSelect(HttpServletRequest req, Model model, GtVacationVO gvvo, GtApprovalLineVO avo) {
		log.info(">>> gtVacationSelect() In");
		
		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(req);
		gvvo.setGenum(genum);
	
	
		int pageSize = CommonUtils.VACATION_PAGE_SIZE;
		int groupSize = CommonUtils.VACATION_GROUP_SIZE;
		int curPage = CommonUtils.VACATION_CUR_PAGE;
		int totalCount = CommonUtils.VACATION_TOTAL_COUNT;
		
		if (gvvo.getCurPage() !=null){
			curPage = Integer.parseInt(gvvo.getCurPage());
		}
		
		gvvo.setPageSize(String.valueOf(pageSize));
		gvvo.setGroupSize(String.valueOf(groupSize));
		gvvo.setCurPage(String.valueOf(curPage));
		gvvo.setTotalCount(String.valueOf(totalCount));
		
		List<GtVacationVO> aList = gtVacationService.gtVacationSelect_(gvvo);
		List<GtVacationVO> list = new ArrayList<GtVacationVO>();
		
		for(int i = 0; i < aList.size(); i++) {
			
			GtVacationVO rvo = aList.get(i);
			if(Integer.parseInt(rvo.getCount()) > 0) {
				if(Integer.parseInt(rvo.getCount()) >= 10 ) {					
					list.add(rvo);					
				}else if(CodeUtil.edsmcheck(rvo.getApprover(), 
					Integer.parseInt(rvo.getCount())).equals("OK")) {
					log.info("gbt num >>>> " + rvo.getGvnum());					
					list.add(rvo);
				}	
			}
		}
		
		if(aList.size() > 0 ) {
			
			model.addAttribute("aList", list);
			model.addAttribute("pagingVVO", gvvo);
			
			return "vacation/vacationSelect_";
			
		}else {
			return "vacation/vacationSelect_";
		}
	} // end of gtVactionSelectAll()
	
}
