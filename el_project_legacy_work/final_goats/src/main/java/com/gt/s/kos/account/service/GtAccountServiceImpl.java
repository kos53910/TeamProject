package com.gt.s.kos.account.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.account.dao.GtAccountDAO;
import com.gt.s.kos.account.vo.GtAccountVO;
import com.gt.s.kos.business.contoller.GtBusinessController;

@Service
@Transactional
public class GtAccountServiceImpl implements GtAccountService {
	
	Logger log = LogManager.getLogger(GtBusinessController.class);

	@Autowired(required = false)
	private GtAccountDAO gtAccountDAO;
	
	@Override
	public int gtAccountInsert(GtAccountVO gvo) {
		// TODO Auto-generated method stub
			log.info("ㅡㅡㅡㅡㅡㅡ인서트ㅡㅡㅡㅡㅡ");
		return gtAccountDAO.gtAccountInsert(gvo);
	}

	@Override
	public List<GtAccountVO> gtAccountSelectAll(GtAccountVO gvo) {
		// TODO Auto-generated method stub
		return gtAccountDAO.gtAccountSelectAll(gvo);
	}

	@Override
	public List<GtAccountVO> gtAccountSelect(GtAccountVO gvo) {
		// TODO Auto-generated method stub
		return gtAccountDAO.gtAccountSelect(gvo);
	}

	@Override
	public List<GtAccountVO> gtAccountSelectAll2() {
		// TODO Auto-generated method stub
		return gtAccountDAO.gtAccountSelectAll2();
	}

}
