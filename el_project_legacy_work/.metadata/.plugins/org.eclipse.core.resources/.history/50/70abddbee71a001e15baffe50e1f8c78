package com.gt.s.kos.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<GtBusinessVO> gtBusinessSelectAll(GtBusinessVO buvo) {
		// TODO Auto-generated method stub
		return gtBusinessDAO.gtBusinessSelectAll(buvo);
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

}
