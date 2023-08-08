package com.gt.s.kos.plan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.plan.dao.GtPlanDAO;
import com.gt.s.kos.plan.vo.GtPlanVO;

@Service
@Transactional
public class GtPlanServiceImpl implements GtPlanService{

	@Autowired(required = false)
 
	private GtPlanDAO gtPlanDAO;

	@Override
	public int gtPlanInsert(GtPlanVO pvo) {
		// TODO Auto-generated method stub
		return gtPlanDAO.gtPlanInsert(pvo);
	}
}
