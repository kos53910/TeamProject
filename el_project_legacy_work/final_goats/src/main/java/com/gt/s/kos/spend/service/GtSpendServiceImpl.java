package com.gt.s.kos.spend.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.spend.dao.GtSpendDAO;
import com.gt.s.kos.spend.vo.GtSpendVO;

@Service
@Transactional
public class GtSpendServiceImpl implements GtSpendService {

	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired(required = false)
 
	private GtSpendDAO gtSpendDAO;

	@Override
	public int gtSpendInsert(GtSpendVO svo) {
		// TODO Auto-generated method stub
		log.info("svo.getReference() > : " + svo.getReference());
		return gtSpendDAO.gtSpendInsert(svo);
	}

	@Override
	public int gtSpendInsertFile(GtSpendVO svo) {
		// TODO Auto-generated method stub
		return gtSpendDAO.gtSpendInsertFile(svo);
	}

	@Override
	public List<GtSpendVO> gtSpendSelectAll() {
		// TODO Auto-generated method stub
		return gtSpendDAO.gtSpendSelectAll();
	}

	@Override
	public List<GtApprovalLineVO> gtSpendAppSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtSpendDAO.gtSpendAppSelectAll(avo);
	}

	@Override
	public List<GtApprovalLineVO> gtSpendRefSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtSpendDAO.gtSpendRefSelectAll(avo);
	}

	@Override
	public List<GtSpendVO> gtSpendSelect(GtSpendVO svo) {
		// TODO Auto-generated method stub
		return gtSpendDAO.gtSpendSelect(svo);
	}
}
