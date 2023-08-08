package com.gt.s.kos.project.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.project.dao.GtProjectDAO;
import com.gt.s.kos.project.vo.GtProjectVO;


@Service
@Transactional
public class GtProjectServiceImpl implements GtProjectService {
	Logger log = LogManager.getLogger(this.getClass());
	
	
	@Autowired(required = false)
 
	private GtProjectDAO gtProjectDAO;
	
	@Override
	public int gtProjectInsert(GtProjectVO pvo) {
		// TODO Auto-generated method stub
		log.info("GtProjectServiceImpl.gtProjectInsert 함수진입");
		return gtProjectDAO.gtProjectInsert(pvo);
		
	} // end of gtProjectInsert

	@Override
	public List<GtProjectVO> gtProjectSelectAll() {
		// TODO Auto-generated method stub
		return gtProjectDAO.gtProjectSelectAll();
	}

	@Override
	public List<GtEmployeeVO> gtEmployeeSelectAll() {
		// TODO Auto-generated method stub
		return gtProjectDAO.gtEmployeeSelectAll();
	}

	@Override
	public List<GtEmployeeVO> gtEmployeeSelect2(GtEmployeeVO evo) {
		// TODO Auto-generated method stub
		log.info("GtProjectServiceImpl.gtEmployeeSelect2 함수진입");
		return gtProjectDAO.gtEmployeeSelect2(evo);
	}

	@Override
	public int gtProjectInsertFile(GtProjectVO pvo) {
		// TODO Auto-generated method stub
		return gtProjectDAO.gtProjectInsertFile(pvo);
	}

	@Override
	public List<GtProjectVO> gtProjectsubject(GtProjectVO pvo) {
		// TODO Auto-generated method stub
		return gtProjectDAO.gtProjectsubject(pvo);
	}
	@Override
	public List<GtProjectVO> gtProjectSelect(GtProjectVO pvo) {
		// TODO Auto-generated method stub
		return gtProjectDAO.gtProjectSelect(pvo);
	}

} //  end of class
