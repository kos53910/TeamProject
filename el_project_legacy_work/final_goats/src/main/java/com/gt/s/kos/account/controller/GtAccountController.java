package com.gt.s.kos.account.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gt.s.common.ChabunUtil;
import com.gt.s.common.CommonUtils;
import com.gt.s.common.DateFormatUtil;
import com.gt.s.common.K_Session;
import com.gt.s.common.chabun.service.GtChabunService;
import com.gt.s.kos.account.service.GtAccountService;
import com.gt.s.kos.account.vo.GtAccountVO;
import com.gt.s.kos.business.contoller.GtBusinessController;
import com.gt.s.kos.employee.service.GtEmployeeService;
import com.gt.s.kos.employee.vo.GtEmployeeVO;

@Controller
public class GtAccountController {

	Logger log = LogManager.getLogger(GtBusinessController.class);
	
	private String ganum = "";
	
	@Autowired(required = false)
	private GtAccountService gtAccountService;
	
	@Autowired(required = false)
	private GtChabunService gtChabunService;
	
	@Autowired(required = false)
	private GtEmployeeService gtEmployeeService;
	
	@GetMapping("accountInsertForm")
	public String gtAccountInsertForm(HttpServletRequest q, GtEmployeeVO evo, GtAccountVO gvo, Model m) {		
		
		K_Session ks = K_Session.getInstance();
		String genum = ks.getSession(q);
		if(genum != null) {
			evo.setGenum(genum);
			evo = gtEmployeeService.gecheck(evo);
			String gsname = evo.getGename() + "/" + evo.getGedept() + "/" + evo.getTitle();
			log.info("gsname : " + gsname);
				m.addAttribute("gsname", gsname);
				return "account/accountInsertForm";
		}	
		return "login/loginX";
	}
	
	@GetMapping("accountInsert")
	public String gtAccountInsert(GtAccountVO gvo) {
					
			int nCnt = gtAccountService.gtAccountInsert(gvo);
			
			if(nCnt > 0) {
				
				return "account/accountInsert";
			}
		
		return "account/accountInsertForm";
	}
	
	@GetMapping("AccountChabun")
	@ResponseBody
	public String gtAccountChabun() {
		
		String ganum = ChabunUtil.BIZ_GUBUN_AC.concat(DateFormatUtil.ymdFormats("D")).concat(gtChabunService.getGtAccountChabun().getGanum());
		
		return ganum;
	}
	
	@GetMapping("accountSelectAll")
	public String gtAccountSelectAll(GtAccountVO gvo, Model m) {
		
		int pageSize = CommonUtils.ACCOUNT_PAGE_SIZE;
		int groupSize = CommonUtils.ACCOUNT_GROUP_SIZE;
		int curPage = CommonUtils.ACCOUNT_CUR_PAGE; // curPage : 현재페이지
		int totalCount = CommonUtils.ACCOUNT_TOTAL_COUNT;
		
		if (gvo.getCurPage() !=null) {
			curPage = Integer.parseInt(gvo.getCurPage());
		}
		
		gvo.setPageSize(String.valueOf(pageSize));
		gvo.setGroupSize(String.valueOf(groupSize));
		gvo.setCurPage(String.valueOf(curPage));
		gvo.setTotalCount(String.valueOf(totalCount));
		
		List<GtAccountVO> listA = gtAccountService.gtAccountSelectAll(gvo);

		int nCnt = listA.size();
		
		if(nCnt > 0) {
			
			m.addAttribute("pagingGVO", gvo);
			m.addAttribute("listA", listA);
		
			return "account/accountSelectAll";			
		}
		return "account/accountSelectAll";
	}

}