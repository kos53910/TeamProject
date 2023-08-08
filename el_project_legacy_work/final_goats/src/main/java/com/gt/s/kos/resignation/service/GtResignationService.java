package com.gt.s.kos.resignation.service;

import java.util.List;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.resignation.vo.GtResignationVO;

public interface GtResignationService {
	
	public int gtResignationInsert(GtResignationVO rvo);
	
	public int gtResignationInsertFile(GtResignationVO rvo);
	
	public List<GtResignationVO> gtResignationSelectAll();
	
	public List<GtApprovalLineVO> gtResignationAppSelectAll(GtApprovalLineVO avo);
	public List<GtApprovalLineVO> gtResignationRefSelectAll(GtApprovalLineVO avo);
	public List<GtResignationVO> gtResignationSelect(GtResignationVO rvo);
}
