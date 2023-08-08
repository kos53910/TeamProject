package com.gt.s.kos.draft.service;

import java.util.List;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.draft.vo.GtDraftVO;

public interface GtDraftService {

	public int gtDraftInsert(GtDraftVO gdvo);
	
	public int gtDraftInsertFile(GtDraftVO gdvo);
	
	public List<GtDraftVO> gtDraftSelect(GtDraftVO gdvo);
	
	public List<GtApprovalLineVO> draftAppSelectAll(GtApprovalLineVO avo);
	public List<GtApprovalLineVO> draftRefSelectAll(GtApprovalLineVO avo);
	
	public List<GtDraftVO> gtDraftSelectAll(GtDraftVO gdvo);
	
	public int gtDraftUpdate(GtDraftVO gdvo);
	
}