package com.gt.s.kos.vacation.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.vacation.dao.GtVacationDAO;
import com.gt.s.kos.vacation.vo.GtVacationVO;

@Service
@Transactional
public class GtVacationServiceImpl implements GtVacationService {
	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired(required = false)
 
	private GtVacationDAO gtVacationDAO;
	
	@Override
	public int gtVacationInsert(GtVacationVO gvvo) {
		// TODO Auto-generated method stub
		log.info("gtVacationInsert  진입 > : ");
		return gtVacationDAO.gtVacationInsert(gvvo);
	}

	@Override
	public int gtVacationInsertFile(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		log.info("gtVacationInsertFile  진입 > : ");
		return gtVacationDAO.gtVacationInsertFile(vvo);
	}

	@Override
	public List<GtVacationVO> gtVacationSelectAll(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		log.info("gtVacationSelectAll 진입 > : ");
		return gtVacationDAO.gtVacationSelectAll(vvo);
	}

	@Override
	public List<GtVacationVO> gtVacationSelect(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		log.info("gtVacationSelect 진입 > : ");
		return gtVacationDAO.gtVacationSelect(vvo);
	}

	@Override
	public List<GtVacationVO> gtVacationUpdate(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		log.info("gtVacationUpdate 진입 > : ");
		return gtVacationDAO.gtVacationUpdate(vvo);
	}

	@Override
	public int gtVacationDelete(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		log.info("gtVacationDelete 진입 > : ");
		return gtVacationDAO.gtVacationDelete(vvo);
	}

	@Override
	public List<GtApprovalLineVO> gtVacationAppSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtVacationDAO.gtVacationAppSelectAll(avo);
	}

	@Override
	public List<GtApprovalLineVO> gtVacationRefSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtVacationDAO.gtVacationRefSelectAll(avo);
	}

	@Override
	public List<GtApprovalLineVO> gtDeciVacationSelect(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtVacationDAO.gtDeciVacationSelect(avo);
	}

	@Override
	public List<GtVacationVO> gtVacationSelect_(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		return gtVacationDAO.gtVacationSelect_(vvo);
	}

	
}
