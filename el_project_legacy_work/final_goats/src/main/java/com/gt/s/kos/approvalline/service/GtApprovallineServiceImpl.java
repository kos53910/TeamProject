package com.gt.s.kos.approvalline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.approvalline.dao.GtApprovallineDAO;
import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;




@Service
@Transactional
public class GtApprovallineServiceImpl implements GtApprovallineService {
	
	@Autowired(required = false)
 
	private GtApprovallineDAO gtApprovallineDAO;

	@Override
	public List<GtApprovalLineVO> goatApprovalOCSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("serviceIMPL goatApprovalSelectAll >>>> : 함수진입");
		return gtApprovallineDAO.goatApprovalOCSelectAll();
	}

	@Override
	public List<GtApprovalLineVO> goatApprovalSelect(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GtApprovalLineVO> goatApprovalMemberSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int goatcountup(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtApprovallineDAO.goatcountup(avo);
	}

	@Override
	public List<GtApprovalLineVO> gtemailSelect(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtApprovallineDAO.gtemailSelect(avo);
	}

	@Override
	public int gtJeonCountUp(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtApprovallineDAO.gtJeonCountUp(avo);
	}

	@Override
	public int gtDeciCountUp(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtApprovallineDAO.gtDeciCountUp(avo);
	}

	@Override
	public int gtDelete(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtApprovallineDAO.gtDelete(avo);
	}

	@Override
	public int gtNappCountDown(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtApprovallineDAO.gtNappCountDown(avo);
	} 
	


} // end of interface
