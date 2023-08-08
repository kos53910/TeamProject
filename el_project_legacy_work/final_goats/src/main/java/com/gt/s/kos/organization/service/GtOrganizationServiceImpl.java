package com.gt.s.kos.organization.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.organization.dao.GtOrganizationDAO;
import com.gt.s.kos.organization.vo.GtOrganizationVO;

@Service
@Transactional
public class GtOrganizationServiceImpl implements GtOrganizationService {

	
	@Autowired(required = false)
 
	private GtOrganizationDAO gtOrganizationDAO;
	
	@Override
	public List<GtEmployeeVO> gtOrganizationSelectAll(GtEmployeeVO evo) {
		// TODO Auto-generated method stub
		System.out.println("GtOrganizationServiceImpl.gtOrganizationSelect 함수 진입");
		return gtOrganizationDAO.gtOrganizationSelectAll(evo);
	}

}
