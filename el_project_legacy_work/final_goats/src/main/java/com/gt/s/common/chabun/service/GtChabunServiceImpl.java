package com.gt.s.common.chabun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.common.chabun.dao.GtChabunDAO;
import com.gt.s.kos.account.vo.GtAccountVO;
import com.gt.s.kos.business.vo.GtBusinessVO;
import com.gt.s.kos.contract.vo.GtContractVO;
import com.gt.s.kos.draft.vo.GtDraftVO;
import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.plan.vo.GtPlanVO;
import com.gt.s.kos.project.vo.GtProjectVO;
import com.gt.s.kos.resignation.vo.GtResignationVO;
import com.gt.s.kos.spend.vo.GtSpendVO;
import com.gt.s.kos.vacation.vo.GtVacationVO;


@Service
@Transactional
public class GtChabunServiceImpl implements GtChabunService {

	@Autowired(required = false)
	private GtChabunDAO gtChabunDAO;
	
	@Override
	public GtVacationVO getGtVacationChabun() {
		// TODO Auto-generated method stub
		return gtChabunDAO.getGtVacationChabun();
	}

	@Override
	public GtBusinessVO getGtBusinessChabun() {
		// TODO Auto-generated method stub
		return gtChabunDAO.getGtBusinessChabun();
	}

	@Override
	public GtSpendVO getGtSpendChabun() {
		// TODO Auto-generated method stub
		return gtChabunDAO.getGtSpendChabun();
	}

	@Override
	public GtProjectVO getGtProjectChabun() {
		// TODO Auto-generated method stub
		return gtChabunDAO.getGtProjectChabun();
	}

	@Override
	public GtDraftVO getGtDraftChabun() {
		// TODO Auto-generated method stub
		return gtChabunDAO.getGtDraftChabun();
	}
	
	@Override
	public GtResignationVO getGtResignationChabun() {
		
		return gtChabunDAO.getGtResignationChabun();
	}
	
	@Override
	public GtEmployeeVO getGtEmployeeChabun() {
		// TODO Auto-generated method stub
		return gtChabunDAO.getGtEmployeeChabun();
	}
	
	@Override	
	public GtContractVO getGtContractChabun() {
		// TODO Auto-generated method stub
		return gtChabunDAO.getGtContractChabun();
	}

	@Override
	public GtPlanVO getGtPlanChabun() {
		// TODO Auto-generated method stub
		return gtChabunDAO.getGtPlanChabun();
	}
		@Override
	public GtAccountVO getGtAccountChabun() {
		// TODO Auto-generated method stub
		return gtChabunDAO.getGtAccountChabun();
	}
}
