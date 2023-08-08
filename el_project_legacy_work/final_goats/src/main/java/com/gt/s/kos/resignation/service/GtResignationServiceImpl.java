package com.gt.s.kos.resignation.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.resignation.dao.GtResignationDAO;
import com.gt.s.kos.resignation.vo.GtResignationVO;

@Service
@Transactional
public class GtResignationServiceImpl implements GtResignationService {
	
	Logger logger = LogManager.getLogger(GtResignationServiceImpl.class);
	
	@Autowired(required=false)
 
	private GtResignationDAO gtResignationDAO;
	
	@Override
	public int gtResignationInsert(GtResignationVO rvo) {
	
		logger.info(">>> gtResignationInsert() In");
		
		return gtResignationDAO.gtResignationInsert(rvo);		
	}
	
	@Override
	public int gtResignationInsertFile(GtResignationVO rvo) {
		
		logger.info(">>> gtResignationInsertFile() In");
		
		return gtResignationDAO.gtResignationInsertFile(rvo);
	}

	@Override
	public List<GtResignationVO> gtResignationSelectAll() {
		// TODO Auto-generated method stub
		return gtResignationDAO.gtResignationSelectAll();
	}

	@Override
	public List<GtApprovalLineVO> gtResignationAppSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtResignationDAO.gtResignationAppSelectAll(avo);
	}

	@Override
	public List<GtApprovalLineVO> gtResignationRefSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtResignationDAO.gtResignationRefSelectAll(avo);
	}
	
	@Override
	public List<GtResignationVO> gtResignationSelect(GtResignationVO rvo) {
		return gtResignationDAO.gtResignationSelect(rvo);
	}

}
