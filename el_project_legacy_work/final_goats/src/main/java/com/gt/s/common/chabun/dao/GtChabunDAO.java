package com.gt.s.common.chabun.dao;

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

public interface GtChabunDAO {

	public GtVacationVO getGtVacationChabun();
	public GtBusinessVO getGtBusinessChabun();
	public GtSpendVO getGtSpendChabun();
	public GtProjectVO getGtProjectChabun();
	public GtResignationVO getGtResignationChabun();
	public GtEmployeeVO getGtEmployeeChabun();
	public GtDraftVO getGtDraftChabun();
	public GtContractVO getGtContractChabun();
	public GtPlanVO getGtPlanChabun();
	public GtAccountVO getGtAccountChabun();
}
