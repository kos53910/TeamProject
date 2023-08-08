package com.gt.s.kos.approvalline.service;

import java.util.List;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;


public interface GtApprovallineService {
	
	public List<GtApprovalLineVO> goatApprovalOCSelectAll();
	
	public List<GtApprovalLineVO> goatApprovalMemberSelectAll();
	
	public List<GtApprovalLineVO> goatApprovalSelect(GtApprovalLineVO avo);
	
	public int goatcountup(GtApprovalLineVO avo);
	
	public int gtJeonCountUp(GtApprovalLineVO avo);
	
	public List<GtApprovalLineVO> gtemailSelect(GtApprovalLineVO avo);
	
	public int gtDeciCountUp(GtApprovalLineVO avo);
	
	public int gtDelete(GtApprovalLineVO avo);
	
	public int gtNappCountDown(GtApprovalLineVO avo);
	
	
} // end of interface
