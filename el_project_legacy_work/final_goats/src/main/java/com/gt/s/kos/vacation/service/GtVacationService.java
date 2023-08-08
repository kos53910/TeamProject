package com.gt.s.kos.vacation.service;

import java.util.List;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.vacation.vo.GtVacationVO;

public interface GtVacationService {

	public int gtVacationInsert(GtVacationVO vvo);
	public int gtVacationInsertFile(GtVacationVO vvo);
	public List<GtVacationVO> gtVacationSelectAll(GtVacationVO vvo);
	public List<GtVacationVO> gtVacationSelect(GtVacationVO vvo);
	public List<GtVacationVO> gtVacationUpdate(GtVacationVO vvo);
	public int gtVacationDelete(GtVacationVO vvo);
	public List<GtApprovalLineVO> gtVacationAppSelectAll(GtApprovalLineVO avo);
	public List<GtApprovalLineVO> gtVacationRefSelectAll(GtApprovalLineVO avo);
	public List<GtApprovalLineVO> gtDeciVacationSelect(GtApprovalLineVO avo);
	public List<GtVacationVO> gtVacationSelect_(GtVacationVO vvo);

}
