package com.gt.s.kos.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.business.dao.GtBusinessDAO;
import com.gt.s.kos.business.vo.GtBusinessVO;

@Service
@Transactional
public class GtBusinessServiceImpl implements GtBusinessService {

	@Autowired(required = false)
 
	private GtBusinessDAO gtBusinessDAO;
	
	@Override
	public int gtBusinessInsert(GtBusinessVO buvo) {
		// TODO Auto-generated method stub
		return gtBusinessDAO.gtBusinessInsert(buvo);
	}

	@Override
	public int gtBusinessInsertFile(GtBusinessVO buvo) {
		// TODO Auto-generated method stub
		return gtBusinessDAO.gtBusinessInsertFile(buvo);
	}

	@Override
	public List<GtApprovalLineVO> gtBusinessAppSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtBusinessDAO.gtBusinessAppSelectAll(avo);
	}

	@Override
	public List<GtBusinessVO> gtBusinessSelect(GtBusinessVO buvo) {
		// TODO Auto-generated method stub
		return gtBusinessDAO.gtBusinessSelect(buvo);
	}

	@Override
	public int gtBusinessUpdate(GtBusinessVO buvo) {
		// TODO Auto-generated method stub
		return gtBusinessDAO.gtBusinessUpdate(buvo);
	}

	@Override
	public List<GtBusinessVO> gtBusinessSelectAll(GtBusinessVO buvo) {
		// TODO Auto-generated method stub
		return gtBusinessDAO.gtBusinessSelectAll(buvo);
	}

	@Override
	public List<GtApprovalLineVO> gtBusinessRefSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtBusinessDAO.gtBusinessRefSelectAll(avo);
	}

	@Override
	public List<GtApprovalLineVO> gtDeciBusinessSelect(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtBusinessDAO.gtDeciBusinessSelect(avo);
	}

}
