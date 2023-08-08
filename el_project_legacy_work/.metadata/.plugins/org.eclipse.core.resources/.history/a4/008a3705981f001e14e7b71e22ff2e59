package com.gt.s.kos.draft.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.draft.dao.GtDraftDAO;
import com.gt.s.kos.draft.vo.GtDraftVO;

@Service
@Transactional
public class GtDraftServiceImpl implements GtDraftService {
	
	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired(required = false)
	private GtDraftDAO gtDraftDAO;

	@Override
	public int draftInsert(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		log.info("인서트 서비스 >>>>>>>>>>>> 다오 간다~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return gtDraftDAO.draftInsert(gdvo);
	}
	
	@Override
	public int draftInsertFile(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		return gtDraftDAO.draftInsertFile(gdvo);
	}

	@Override
	public List<GtDraftVO> draftSelect(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GtDraftVO> draftSelectAll(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int draftUpdate(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
