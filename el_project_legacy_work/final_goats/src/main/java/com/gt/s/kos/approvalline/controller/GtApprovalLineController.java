package com.gt.s.kos.approvalline.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gt.s.common.ChabunUtil;
import com.gt.s.common.CodeUtil;
import com.gt.s.common.DateFormatUtil;
import com.gt.s.common.K_Session;
import com.gt.s.common.chabun.service.GtChabunService;
import com.gt.s.kos.approvalline.service.GtApprovallineService;
import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.business.service.GtBusinessService;
import com.gt.s.kos.business.vo.GtBusinessVO;
import com.gt.s.kos.contract.service.GtContractService;
import com.gt.s.kos.contract.vo.GtContractVO;
import com.gt.s.kos.draft.service.GtDraftService;
import com.gt.s.kos.draft.vo.GtDraftVO;
import com.gt.s.kos.employee.service.GtEmployeeService;
import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.plan.service.GtPlanService;
import com.gt.s.kos.plan.vo.GtPlanVO;
import com.gt.s.kos.resignation.service.GtResignationService;
import com.gt.s.kos.resignation.vo.GtResignationVO;
import com.gt.s.kos.spend.service.GtSpendService;
import com.gt.s.kos.spend.vo.GtSpendVO;
import com.gt.s.kos.vacation.service.GtVacationService;
import com.gt.s.kos.vacation.vo.GtVacationVO;

@Controller
public class GtApprovalLineController {
	Logger log = LogManager.getLogger(GtApprovalLineController.class);

	@Autowired(required = false)
	private GtApprovallineService gtApprovallineService;
	@Autowired(required = false)
	private GtContractService gtContractService;
	@Autowired(required = false)
	private GtDraftService gtDraftService;
	@Autowired(required = false)
	private GtBusinessService gtBusinessService;
	@Autowired(required = false)
	private GtVacationService gtVacationService;
	@Autowired(required = false)
	private GtSpendService gtSpendService;
	@Autowired(required = false)
	private GtResignationService gtResignationService;
	@Autowired(required = false)
	private GtEmployeeService gtEmployeeService;
	@Autowired(required = false)
	private GtPlanService gtPlanService;
	@Autowired(required = false)
	private GtChabunService gtChabunService;

	@GetMapping("SelectAll")
	public String goatApprovallineSelectAll(GtApprovalLineVO gvo, Model model) {
		log.info("goatApprovallineSelectAll 함수 진입");
		System.out.println("123");

		List<GtApprovalLineVO> list = gtApprovallineService.goatApprovalOCSelectAll();

		log.info("list.size >>> :" + list.size());

		model.addAttribute("list", list);

		return "select";

	}

	@GetMapping(value = "gtsidebarcheck")
	@ResponseBody
	public String gtsidebarcheck(HttpServletRequest q, GtApprovalLineVO avo) {
		avo.setApp("app");
		log.info("document_approve() >> : ");
		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(q);
		log.info("genum >>> : " + genum);
		GtEmployeeVO evo = new GtEmployeeVO();
		evo.setGenum(genum);
		evo = gtEmployeeService.goatempidcheck(evo);
		String gename = evo.getGename();
		String apryn = evo.getApryn();
		log.info("apryn >> : " + apryn);
		log.info("gename >>> : " + gename);
		avo.setGename(gename);
		if(avo.getS_appnum() == null) {
			avo.setS_appnum("");
		}
		if(avo.getSubject()==(null)) {
			avo.setSubject("");
		}
		if(avo.getS_writer()==(null)) {
			avo.setS_writer("");
		}
		if(avo.getFormname()==(null)) {
			avo.setFormname("");
		}
		if(avo.getAppstartdate()==(null)) {
			avo.setAppstartdate("");
		}
		if(avo.getAppenddate()==(null)) {
			avo.setAppenddate("");
		}
		log.info("avo.getS_appnum() >> : " + avo.getS_appnum());
		log.info("avo.getSubject() >> : " + avo.getSubject());
		log.info("avo.getWriter() >> : " + avo.getS_writer());
		log.info("avo.getFormname() >> : " + avo.getFormname());
		log.info("avo.getAppstartdate() >> : " + avo.getAppstartdate());
		log.info("avo.getAppenddate() >> : " + avo.getAppenddate());
		

		List<GtApprovalLineVO> list_Deci_1 = gtBusinessService.gtDeciBusinessSelect(avo);
		List<GtApprovalLineVO> list_Deci_2 = gtVacationService.gtDeciVacationSelect(avo);
		List<GtApprovalLineVO> list_ = new ArrayList<GtApprovalLineVO>();
		List<GtApprovalLineVO> list_Deci = new ArrayList<GtApprovalLineVO>();
		for (int i = 0; i < list_Deci_1.size(); i++) {
			GtApprovalLineVO avo_ = list_Deci_1.get(i);
			list_.add(avo_);
		}
		log.info("list_Deci_1.size() >>> : " + list_Deci_1.size());
		for (int i = 0; i < list_Deci_2.size(); i++) {
			GtApprovalLineVO avo_ = list_Deci_2.get(i);
			list_.add(avo_);
		}
		log.info("list_Deci_2.size() >>> : " + list_Deci_2.size());
		log.info("list_.size() >>> : " + list_.size());
		if (list_.size() > 0) {
			for (int i = 0; i < list_.size(); i++) {
				GtApprovalLineVO avo_ = list_.get(i);
				String writer = avo_.getWriter().split(" ")[1];
				log.info("writer >>> : " + writer);
				avo_.setGename(writer);
				avo_.setApp("app");
				if(avo_.getS_appnum() == null) {
					avo_.setS_appnum("");
				}
				if(avo_.getSubject()==(null)) {
					avo_.setSubject("");
				}
				if(avo_.getS_writer()==(null)) {
					avo_.setS_writer("");
				}
				if(avo_.getFormname()==(null)) {
					avo_.setFormname("");
				}
				if(avo_.getAppstartdate()==(null)) {
					avo_.setAppstartdate("");
				}
				if(avo_.getAppenddate()==(null)) {
					avo_.setAppenddate("");
				}
				List<GtApprovalLineVO> list_C = gtContractService.gtContractAppSelectAll(avo_);
				List<GtApprovalLineVO> list_D = gtDraftService.draftAppSelectAll(avo_);
				List<GtApprovalLineVO> list_B = gtBusinessService.gtBusinessAppSelectAll(avo_);
				List<GtApprovalLineVO> list_V = gtVacationService.gtVacationAppSelectAll(avo_);
				List<GtApprovalLineVO> list_S = gtSpendService.gtSpendAppSelectAll(avo_);
				List<GtApprovalLineVO> list_R = gtResignationService.gtResignationAppSelectAll(avo_);
				for (int ii = 0; ii < list_C.size(); ii++) {
					GtApprovalLineVO cvo = null;
					cvo = list_C.get(ii);
					String app = cvo.getApprover();
					int count = Integer.parseInt(cvo.getCount());
					if (count >= 0) {
						String jeon = CodeUtil.edsmjeoncheck(app, count);
						String s = CodeUtil.edsmcheck(app, count);
						if ((jeon.equals("") && s.equals(writer))) {
							list_Deci.add(cvo);
						}
					}
				}

				for (int ii = 0; ii < list_D.size(); ii++) {
					GtApprovalLineVO dvo = null;
					dvo = list_D.get(ii);
					String app = dvo.getApprover();
					int count = Integer.parseInt(dvo.getCount());
					if (count >= 0) {
						String jeon = CodeUtil.edsmjeoncheck(app, count);
						String s = CodeUtil.edsmcheck(app, count);
						if ((jeon.equals("") && s.equals(writer))) {
							list_Deci.add(dvo);
						}
					}
				}

				for (int ii = 0; ii < list_B.size(); ii++) {
					GtApprovalLineVO bvo = null;
					bvo = list_B.get(ii);
					String app = bvo.getApprover();
					int count = Integer.parseInt(bvo.getCount());
					if (count >= 0) {
						String jeon = CodeUtil.edsmjeoncheck(app, count);
						String s = CodeUtil.edsmcheck(app, count);
						if ((jeon.equals("") && s.equals(writer))) {
							list_Deci.add(bvo);
						}
					}
				}

				for (int ii = 0; ii < list_V.size(); ii++) {
					GtApprovalLineVO vvo = null;
					vvo = list_V.get(ii);
					String app = vvo.getApprover();
					int count = Integer.parseInt(vvo.getCount());
					if (count >= 0) {
						String jeon = CodeUtil.edsmjeoncheck(app, count);
						String s = CodeUtil.edsmcheck(app, count);
						if ((jeon.equals("") && s.equals(writer))) {
							list_Deci.add(vvo);
						}
					}
				}

				for (int ii = 0; ii < list_S.size(); ii++) {
					GtApprovalLineVO svo = null;
					svo = list_S.get(ii);
					String app = svo.getApprover();
					int count = Integer.parseInt(svo.getCount());
					if (count >= 0) {
						String jeon = CodeUtil.edsmjeoncheck(app, count);
						String s = CodeUtil.edsmcheck(app, count);
						if ((jeon.equals("") && s.equals(writer))) {
							list_Deci.add(svo);
						}
					}
				}

				for (int ii = 0; ii < list_R.size(); ii++) {
					GtApprovalLineVO rvo = null;
					rvo = list_R.get(ii);
					String app = rvo.getApprover();
					int count = Integer.parseInt(rvo.getCount());
					if (count >= 0) {
						String jeon = CodeUtil.edsmjeoncheck(app, count);
						String s = CodeUtil.edsmcheck(app, count);
						if ((jeon.equals("") && s.equals(writer))) {
							list_Deci.add(rvo);
						}
					}
				}
			}
		}
		List<GtApprovalLineVO> list = new ArrayList<GtApprovalLineVO>();
		List<GtApprovalLineVO> list_C = gtContractService.gtContractAppSelectAll(avo);
		List<GtApprovalLineVO> list_D = gtDraftService.draftAppSelectAll(avo);
		List<GtApprovalLineVO> list_B = gtBusinessService.gtBusinessAppSelectAll(avo);
		List<GtApprovalLineVO> list_V = gtVacationService.gtVacationAppSelectAll(avo);
		List<GtApprovalLineVO> list_S = gtSpendService.gtSpendAppSelectAll(avo);
		List<GtApprovalLineVO> list_R = gtResignationService.gtResignationAppSelectAll(avo);
		
		for (int i = 0; i < list_C.size(); i++) {
			GtApprovalLineVO cvo = null;
			cvo = list_C.get(i);
			String app = cvo.getApprover();
			int count = Integer.parseInt(cvo.getCount());
			if (count >= 0) {
				String jeon = CodeUtil.edsmjeoncheck(app, count);
				String s = CodeUtil.edsmcheck(app, count);
				if (jeon.equals("") && s.equals(gename)) {
					list.add(cvo);
				}
			}
		}

		for (int i = 0; i < list_D.size(); i++) {
			GtApprovalLineVO dvo = null;
			dvo = list_D.get(i);
			String app = dvo.getApprover();
			int count = Integer.parseInt(dvo.getCount());
			if (count >= 0) {
				String jeon = CodeUtil.edsmjeoncheck(app, count);
				String s = CodeUtil.edsmcheck(app, count);
				if (jeon.equals("") && s.equals(gename)) {
					list.add(dvo);
				}
			}
		}

		for (int i = 0; i < list_B.size(); i++) {
			GtApprovalLineVO bvo = null;
			bvo = list_B.get(i);
			String app = bvo.getApprover();
			int count = Integer.parseInt(bvo.getCount());
			if (count >= 0) {
				String jeon = CodeUtil.edsmjeoncheck(app, count);
				String s = CodeUtil.edsmcheck(app, count);
				if (jeon.equals("") && s.equals(gename)) {
					list.add(bvo);
				}
			}
		}

		for (int i = 0; i < list_V.size(); i++) {
			GtApprovalLineVO vvo = null;
			vvo = list_V.get(i);
			String app = vvo.getApprover();
			int count = Integer.parseInt(vvo.getCount());
			if (count >= 0) {
				String jeon = CodeUtil.edsmjeoncheck(app, count);
				String s = CodeUtil.edsmcheck(app, count);
				if (jeon.equals("") && s.equals(gename)) {
					list.add(vvo);
				}
			}
		}

		for (int i = 0; i < list_S.size(); i++) {
			GtApprovalLineVO svo = null;
			svo = list_S.get(i);
			String app = svo.getApprover();
			int count = Integer.parseInt(svo.getCount());
			if (count >= 0) {
				String jeon = CodeUtil.edsmjeoncheck(app, count);
				String s = CodeUtil.edsmcheck(app, count);
				if (jeon.equals("") && s.equals(gename)) {
					list.add(svo);
				}
			}
		}

		for (int i = 0; i < list_R.size(); i++) {
			GtApprovalLineVO rvo = null;
			rvo = list_R.get(i);
			String app = rvo.getApprover();
			int count = Integer.parseInt(rvo.getCount());
			if (count >= 0) {
				String jeon = CodeUtil.edsmjeoncheck(app, count);
				String s = CodeUtil.edsmcheck(app, count);
				if (jeon.equals("") && s.equals(gename)) {
					list.add(rvo);
				}
			}
		}
		list.sort(Comparator.comparing(GtApprovalLineVO::getDate));
		list_Deci.sort(Comparator.comparing(GtApprovalLineVO::getDate));

		log.info("list.size() > : " + list.size());
		log.info("list_Deci.size() >>> : " + list_Deci.size());

		if (list.size() > 0 || list_Deci.size() > 0) {
			return "OK";
		} else {
			return "NOK";
		}
	}

	@PostMapping(value = "edsmcountup")
	public String edsmcountup(GtApprovalLineVO avo, HttpServletRequest q) {
		avo.setAppnum(q.getParameter("appnum"));
		log.info("avo.getAppnum() >>> : " + avo.getAppnum());
		avo.setTablename(CodeUtil.tablename(avo.getAppnum()));
		avo.setNumname(CodeUtil.numname(avo.getAppnum()));
		log.info("avo.getAppnum() >> : " + avo.getAppnum());
		log.info("avo.getTablename() >>> : " + avo.getTablename());
		log.info("avo.getNumname() >>> : " + avo.getNumname());
		int nCnt = gtApprovallineService.goatcountup(avo);
		if (nCnt > 0) {
			GtApprovalLineVO vo = new GtApprovalLineVO();
			vo.setNumname(CodeUtil.numname(avo.getAppnum()));
			vo.setSubjectname(CodeUtil.subjectname(avo.getAppnum()));
			vo.setAppnum(avo.getAppnum());
			vo.setTablename(CodeUtil.tablename(avo.getAppnum()));
			log.info(vo.getNumname());
			log.info(vo.getSubjectname());
			log.info(vo.getAppnum());
			log.info(vo.getTablename());
			List<GtApprovalLineVO> list = gtApprovallineService.gtemailSelect(vo);
			String num = list.get(0).getAppnum();
			String subject = list.get(0).getSubject();
			String writer = list.get(0).getWriter();
			String date = list.get(0).getInsertdate();
			log.info("date > : " + date);
			String app = list.get(0).getApprover();
			String count = list.get(0).getCount();
			String s = CodeUtil.edsmcheck(app, Integer.parseInt(count));
			if(!s.equals("OK")) {
				GtEmployeeVO evo = null;
				evo = new GtEmployeeVO();
				evo.setGename(s);
				String email = gtEmployeeService.emailcheck(evo).getGeemail();
				CodeUtil.googlemail(num, subject, writer, date, email);
				}else {
					if(num.substring(0, 2).equals("VA")) {
						GtVacationVO vvo = new GtVacationVO();
						vvo.setGvnum(num);
						List<GtVacationVO> list_V = gtVacationService.gtVacationSelect(vvo);
						vvo = list_V.get(0);
						GtPlanVO pvo = new GtPlanVO();
						String gpnum = ChabunUtil.BIZ_GUBUN_SC + DateFormatUtil.ymdFormat() + gtChabunService.getGtPlanChabun().getGpnum();
						pvo.setGpnum(gpnum);
						pvo.setGpsubject(vvo.getGvsubject());
						pvo.setGppnum(vvo.getGvnum());
						pvo.setWriter(vvo.getWriter());
						pvo.setGptype(vvo.getGvtype());
						pvo.setGpmemo(vvo.getGvmemo());
						pvo.setGplocation("-");
						pvo.setGpstart(vvo.getGvstartdate());
						pvo.setGpend(vvo.getGvenddate());
						gtPlanService.gtPlanInsert(pvo);
					}
					if(num.substring(0, 2).equals("BU")) {
						GtBusinessVO bvo = new GtBusinessVO();
						bvo.setGbtnum(num);
						List<GtBusinessVO> list_V = gtBusinessService.gtBusinessSelect(bvo);
						bvo = list_V.get(0);
						GtPlanVO pvo = new GtPlanVO();
						String gpnum = ChabunUtil.BIZ_GUBUN_SC + DateFormatUtil.ymdFormat() + gtChabunService.getGtPlanChabun().getGpnum();
						pvo.setGpnum(gpnum);
						pvo.setGpsubject(bvo.getGbtname());
						pvo.setGppnum(bvo.getGbtnum());
						pvo.setWriter(bvo.getWriter());
						pvo.setGptype("-");
						pvo.setGpmemo("-");
						pvo.setGplocation("-");
						pvo.setGpstart(bvo.getGbtstart());
						pvo.setGpend(bvo.getGbtend());
						gtPlanService.gtPlanInsert(pvo);
					}
				}
			

			return "approvalline/countupOK";
		} else {
			return "approvalline/countupX";
		}
	}
	
	@PostMapping(value = "edsmjeoncountup")
	public String edsmjeoncountup(GtApprovalLineVO avo, HttpServletRequest q) {
		
		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(q);
		GtEmployeeVO evo = null;
		evo = new GtEmployeeVO();
		evo.setGenum(genum);
		String gename = gtEmployeeService.goatempidcheck(evo).getGename();
		
		avo.setTablename(CodeUtil.tablename(avo.getAppnum()));
		avo.setNumname(CodeUtil.numname(avo.getAppnum()));
		avo.setSubjectname(CodeUtil.subjectname(avo.getAppnum()));
		log.info("gename >>> : " + gename);
		log.info("avo.getAppnum() >> : " + avo.getAppnum());
		log.info("avo.getTablename() >>> : " + avo.getTablename());
		log.info("avo.getNumname() >>> : " + avo.getNumname());
		List<GtApprovalLineVO> list = gtApprovallineService.gtemailSelect(avo);
		String app = list.get(0).getApprover();
		String count = list.get(0).getCount();
		int count_ = CodeUtil.jeoncountup(gename, app, Integer.parseInt(count)) + 10;
		log.info("count_ >>> : " + count_);
		avo.setCount(Integer.toString(count_));
		log.info("avo.getCount() >>> : " + avo.getCount());
		int nCnt = gtApprovallineService.gtJeonCountUp(avo);
		if (nCnt > 0) {
			return "approvalline/countupOK";
		}else {
			return "approvalline/countupX";
		}
	}
	
	@RequestMapping(value = "deciapp", method = {RequestMethod.GET, RequestMethod.POST})
	public String deciapp(GtApprovalLineVO avo, HttpServletRequest q) throws Exception {
		q.setCharacterEncoding("UTF-8");
		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(q);
		GtEmployeeVO evo = null;
		evo = new GtEmployeeVO();
		evo.setGenum(genum);
		GtEmployeeVO evo_ = gtEmployeeService.goatempidcheck(evo);
		String gename = evo_.getGename();
		String title = evo_.getTitle();
		log.info("gename >>> : " + gename);
		String num = avo.getAppnum();
		log.info("num >>> : " + num);
		if((num.substring(0, 2).toUpperCase()).equals("BU")) {
			GtBusinessVO bvo = null;
			bvo = new GtBusinessVO();
			bvo.setGbtnum(avo.getAppnum());
			List<GtBusinessVO> list = gtBusinessService.gtBusinessSelect(bvo);
			String approver = list.get(0).getApprover();
			String count = list.get(0).getCount();
			log.info("approver >>> : " + approver);
			log.info("count >>> : " + count);
			log.info("avo.getDeciwriter() >>> : " + avo.getDeciwriter());
			int i = CodeUtil.jeoncountup(avo.getDeciwriter(), approver, Integer.parseInt(count));
			log.info("i >>> : " + i);
			String[] app = approver.split("/");
			app[i+1] += " " + gename + " " + title + "(대결)";
			log.info("app["+i+"] >>> : " + app[i]);
			approver = "";
			for(int z=0; z<app.length; z++) {
				approver += app[z] + "/";
			}
			log.info("approver >>> : " + approver);
			GtApprovalLineVO avo_ = new GtApprovalLineVO();
			avo_.setApprover(approver);
			avo_.setTablename(CodeUtil.tablename(num));
			avo_.setNumname(CodeUtil.numname(num));
			avo_.setAppnum(num);
			gtApprovallineService.gtDeciCountUp(avo_);
			
		}
		if((num.substring(0, 2).toUpperCase()).equals("VA")) {
			GtVacationVO vvo = null;
			vvo = new GtVacationVO();
			vvo.setGvnum(avo.getAppnum());
			List<GtVacationVO> list = gtVacationService.gtVacationSelect(vvo);
			String approver = list.get(0).getApprover();
			String count = list.get(0).getCount();
			log.info("approver >>> : " + approver);
			log.info("count >>> : " + count);
			log.info("avo.getDeciwriter() >>> : " + avo.getDeciwriter());
			int i = CodeUtil.jeoncountup(avo.getDeciwriter(), approver, Integer.parseInt(count));
			log.info("i >>> : " + i);
			String[] app = approver.split("/");
			app[i+1] += " " + gename + " " + title + "(대결)";
			log.info("app["+i+"] >>> : " + app[i]);
			approver = "";
			for(int z=0; z<app.length; z++) {
				approver += app[z] + "/";
			}
			log.info("approver >>> : " + approver);
			GtApprovalLineVO avo_ = new GtApprovalLineVO();
			avo_.setApprover(approver);
			avo_.setTablename(CodeUtil.tablename(num));
			avo_.setNumname(CodeUtil.numname(num));
			avo_.setAppnum(num);
			gtApprovallineService.gtDeciCountUp(avo_);
		}
		if((num.substring(0, 2).toUpperCase()).equals("SP")) {
			GtSpendVO svo = null;
			svo = new GtSpendVO();
			svo.setGsnum(avo.getAppnum());
			List<GtSpendVO> list = gtSpendService.gtSpendSelect(svo);
			String approver = list.get(0).getApprover();
			String count = list.get(0).getCount();
			log.info("approver >>> : " + approver);
			log.info("count >>> : " + count);
			log.info("avo.getDeciwriter() >>> : " + avo.getDeciwriter());
			int i = CodeUtil.jeoncountup(avo.getDeciwriter(), approver, Integer.parseInt(count));
			log.info("i >>> : " + i);
			String[] app = approver.split("/");
			app[i+1] += " " + gename + " " + title + "(대결)";
			log.info("app["+i+"] >>> : " + app[i]);
			approver = "";
			for(int z=0; z<app.length; z++) {
				approver += app[z] + "/";
			}
			log.info("approver >>> : " + approver);
			GtApprovalLineVO avo_ = new GtApprovalLineVO();
			avo_.setApprover(approver);
			avo_.setTablename(CodeUtil.tablename(num));
			avo_.setNumname(CodeUtil.numname(num));
			avo_.setAppnum(num);
			gtApprovallineService.gtDeciCountUp(avo_);
		}
		if((num.substring(0, 2).toUpperCase()).equals("DR")) {
			GtDraftVO dvo = null;
			dvo = new GtDraftVO();
			dvo.setGdrnum(avo.getAppnum());
			List<GtDraftVO> list = gtDraftService.gtDraftSelect(dvo);
			String approver = list.get(0).getApprover();
			String count = list.get(0).getCount();
			log.info("approver >>> : " + approver);
			log.info("count >>> : " + count);
			log.info("avo.getDeciwriter() >>> : " + avo.getDeciwriter());
			int i = CodeUtil.jeoncountup(avo.getDeciwriter(), approver, Integer.parseInt(count));
			log.info("i >>> : " + i);
			String[] app = approver.split("/");
			app[i+1] += " " + gename + " " + title + "(대결)";
			log.info("app["+i+"] >>> : " + app[i]);
			approver = "";
			for(int z=0; z<app.length; z++) {
				approver += app[z] + "/";
			}
			log.info("approver >>> : " + approver);
			GtApprovalLineVO avo_ = new GtApprovalLineVO();
			avo_.setApprover(approver);
			avo_.setTablename(CodeUtil.tablename(num));
			avo_.setNumname(CodeUtil.numname(num));
			avo_.setAppnum(num);
			gtApprovallineService.gtDeciCountUp(avo_);
		}
		if((num.substring(0, 2).toUpperCase()).equals("CO")) {
			GtContractVO cvo = null;
			cvo = new GtContractVO();
			cvo.setGcnum(avo.getAppnum());
			List<GtContractVO> list = gtContractService.gtContractSelect(cvo);
			String approver = list.get(0).getApprover();
			String count = list.get(0).getCount();
			log.info("approver >>> : " + approver);
			log.info("count >>> : " + count);
			log.info("avo.getDeciwriter() >>> : " + avo.getDeciwriter());
			int i = CodeUtil.jeoncountup(avo.getDeciwriter(), approver, Integer.parseInt(count));
			log.info("i >>> : " + i);
			String[] app = approver.split("/");
			app[i+1] += " " + gename + " " + title + "(대결)";
			log.info("app["+i+"] >>> : " + app[i]);
			approver = "";
			for(int z=0; z<app.length; z++) {
				approver += app[z] + "/";
			}
			log.info("approver >>> : " + approver);
			GtApprovalLineVO avo_ = new GtApprovalLineVO();
			avo_.setApprover(approver);
			avo_.setTablename(CodeUtil.tablename(num));
			avo_.setNumname(CodeUtil.numname(num));
			avo_.setAppnum(num);
			gtApprovallineService.gtDeciCountUp(avo_);
		}
		if((num.substring(0, 2).toUpperCase()).equals("RE")) {
			GtResignationVO rvo = null;
			rvo = new GtResignationVO();
			rvo.setGrnum(avo.getAppnum());
			List<GtResignationVO> list = gtResignationService.gtResignationSelect(rvo);
			String approver = list.get(0).getApprover();
			String count = list.get(0).getCount();
			log.info("approver >>> : " + approver);
			log.info("count >>> : " + count);
			log.info("avo.getDeciwriter() >>> : " + avo.getDeciwriter());
			int i = CodeUtil.jeoncountup(avo.getDeciwriter(), approver, Integer.parseInt(count));
			log.info("i >>> : " + i);
			String[] app = approver.split("/");
			app[i+1] += " " + gename + " " + title + "(대결)";
			log.info("app["+i+"] >>> : " + app[i]);
			approver = "";
			for(int z=0; z<app.length; z++) {
				approver += app[z] + "/";
			}
			log.info("approver >>> : " + approver);
			GtApprovalLineVO avo_ = new GtApprovalLineVO();
			avo_.setApprover(approver);
			avo_.setTablename(CodeUtil.tablename(num));
			avo_.setNumname(CodeUtil.numname(num));
			avo_.setAppnum(num);
			gtApprovallineService.gtDeciCountUp(avo_);
		}
			GtApprovalLineVO vo = new GtApprovalLineVO();
			vo.setNumname(CodeUtil.numname(avo.getAppnum()));
			vo.setSubjectname(CodeUtil.subjectname(avo.getAppnum()));
			vo.setAppnum(avo.getAppnum());
			vo.setTablename(CodeUtil.tablename(avo.getAppnum()));
			log.info(vo.getNumname());
			log.info(vo.getSubjectname());
			log.info(vo.getAppnum());
			log.info(vo.getTablename());
			List<GtApprovalLineVO> list = gtApprovallineService.gtemailSelect(vo);
			String num1 = list.get(0).getAppnum();
			String subject = list.get(0).getSubject();
			String writer = list.get(0).getWriter();
			String date = list.get(0).getInsertdate();
			log.info("date > : " + date);
			String app = list.get(0).getApprover();
			String count = list.get(0).getCount();
			String s = CodeUtil.edsmcheck(app, Integer.parseInt(count));
			if(!s.equals("OK")) {
				GtEmployeeVO evo1 = null;
				evo1 = new GtEmployeeVO();
				evo1.setGename(s);
				String email = gtEmployeeService.emailcheck(evo1).getGeemail();
				CodeUtil.googlemail(num1, subject, writer, date, email);
			}
		
		return "approvalline/countupOK";
	}
	
	@PostMapping(value = "gtDelete")
	public String gtDelete(GtApprovalLineVO avo) {
		log.info("@@@@@@@@@@ > : " + avo.getAppnum());
		avo.setTablename(CodeUtil.tablename(avo.getAppnum()));
		avo.setNumname(CodeUtil.numname(avo.getAppnum()));
		int nCnt = gtApprovallineService.gtDelete(avo);
		if(nCnt > 0) {
			return "approvalline/deleteOK";
		}else {
			return "approvalline/deleteX";
		}		
	}
	
	@PostMapping(value = "gtnappcountdown", produces = "text/html; charset=UTF-8", consumes = "application/x-www-form-urlencoded; charset=UTF-8")
	public String gtnappcountdown(GtApprovalLineVO avo, HttpServletRequest q) throws UnsupportedEncodingException {
		q.setCharacterEncoding("UTF-8");
		log.info("appnum >>> : " + avo.getAppnum());
		avo.setTablename(CodeUtil.tablename(avo.getAppnum()));
		avo.setNumname(CodeUtil.numname(avo.getAppnum()));
		avo.setSubjectname(CodeUtil.subjectname(avo.getAppnum()));
		int nCnt = gtApprovallineService.gtNappCountDown(avo);
		if(nCnt > 0) {
			List<GtApprovalLineVO> list = gtApprovallineService.gtemailSelect(avo);
			GtApprovalLineVO avo_ = list.get(0);
			String writer = avo_.getWriter().split(" ")[1];
			log.info("writer >>> : " + writer);
			GtEmployeeVO evo = new GtEmployeeVO();
			evo.setGename(writer);
			String geemail = gtEmployeeService.emailcheck(evo).getGeemail();
			CodeUtil.nappGoogleEmail(avo_.getAppnum(), avo_.getSubject(), 
									 avo_.getInsertdate(), geemail);
			
			return "approvalline/nappcountdown";
		}else {
			return "approvalline/countupX";
		}
	}
}