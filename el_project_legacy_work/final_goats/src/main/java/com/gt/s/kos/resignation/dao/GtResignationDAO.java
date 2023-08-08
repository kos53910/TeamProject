package com.gt.s.kos.resignation.dao;

import java.util.List;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.resignation.vo.GtResignationVO;

public interface GtResignationDAO {
	
	public int gtResignationInsert(GtResignationVO rvo);
	
	public int gtResignationInsertFile(GtResignationVO rvo);
	
	public List<GtResignationVO> gtResignationSelectAll();
	
	public List<GtApprovalLineVO> gtResignationAppSelectAll(GtApprovalLineVO avo);
	public List<GtApprovalLineVO> gtResignationRefSelectAll(GtApprovalLineVO avo);
	
	public List<GtResignationVO> gtResignationSelect(GtResignationVO rvo);

}
