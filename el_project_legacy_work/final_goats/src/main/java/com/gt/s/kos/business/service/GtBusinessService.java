package com.gt.s.kos.business.service;

import java.util.List;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.business.vo.GtBusinessVO;


public interface GtBusinessService {
	
	public int gtBusinessInsert(GtBusinessVO buvo);
	public int gtBusinessInsertFile(GtBusinessVO buvo);
	public List<GtApprovalLineVO> gtBusinessAppSelectAll(GtApprovalLineVO avo);
	public List<GtApprovalLineVO> gtBusinessRefSelectAll(GtApprovalLineVO avo);
	public List<GtBusinessVO> gtBusinessSelectAll(GtBusinessVO buvo);
	public List<GtBusinessVO> gtBusinessSelect(GtBusinessVO buvo);
	public int gtBusinessUpdate(GtBusinessVO buvo);
	public List<GtApprovalLineVO> gtDeciBusinessSelect(GtApprovalLineVO avo);

}
