package com.gt.s.kos.contract.service;

import java.util.List;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.contract.vo.GtContractVO;

public interface GtContractService {

	public int gtContractInsert(GtContractVO cvo);
	public int gtContractInsertFile(GtContractVO cvo);
	public List<GtContractVO> gtContractSelectAll(GtContractVO cvo);
	public List<GtApprovalLineVO> gtContractAppSelectAll(GtApprovalLineVO avo);
	public List<GtApprovalLineVO> gtContractRefSelectAll(GtApprovalLineVO avo);
	public List<GtContractVO> gtContractSelect(GtContractVO cvo);
}
