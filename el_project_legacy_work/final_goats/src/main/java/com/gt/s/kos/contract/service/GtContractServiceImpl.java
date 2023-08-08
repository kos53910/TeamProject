package com.gt.s.kos.contract.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.contract.dao.GtContractDAO;
import com.gt.s.kos.contract.vo.GtContractVO;

@Service
@Transactional
public class GtContractServiceImpl implements GtContractService {
	
	@Autowired(required = false)
 
	private GtContractDAO gtContractDAO;
	
	@Override
	public int gtContractInsert(GtContractVO cvo) {
		// Insert
		return gtContractDAO.gtContractInsert(cvo);
	}

	@Override
	public int gtContractInsertFile(GtContractVO cvo) {
		// InsertFile
		return gtContractDAO.gtContractInsertFile(cvo);
	}

	@Override
	public List<GtContractVO> gtContractSelectAll(GtContractVO cvo) {
		// TODO Auto-generated method stub
		return gtContractDAO.gtContractSelectAll(cvo);
	}

	@Override
	public List<GtApprovalLineVO> gtContractAppSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtContractDAO.gtContractAppSelectAll(avo);
	}

	@Override
	public List<GtApprovalLineVO> gtContractRefSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtContractDAO.gtContractRefSelectAll(avo);
	}

	@Override
	public List<GtContractVO> gtContractSelect(GtContractVO cvo) {
		// TODO Auto-generated method stub
		return gtContractDAO.gtContractSelect(cvo);
	}
}
