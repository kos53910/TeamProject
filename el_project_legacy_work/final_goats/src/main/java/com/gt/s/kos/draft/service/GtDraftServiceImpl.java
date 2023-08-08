package com.gt.s.kos.draft.service;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.draft.dao.GtDraftDAO;
import com.gt.s.kos.draft.vo.GtDraftVO;

@Service
@Transactional
public class GtDraftServiceImpl implements GtDraftService {
	
	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired(required = false)
 
	private GtDraftDAO gtDraftDAO;

	@Override
	public int gtDraftInsert(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		log.info("인서트 서비스 >>>>>>>>>>>> 다오 간다~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return gtDraftDAO.gtDraftInsert(gdvo);
	}
	
	@Override
	public int gtDraftInsertFile(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		return gtDraftDAO.gtDraftInsertFile(gdvo);
	}

	@Override
	public List<GtDraftVO> gtDraftSelect(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		return gtDraftDAO.gtDraftSelect(gdvo);
	}

	@Override
	public List<GtDraftVO> gtDraftSelectAll(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int gtDraftUpdate(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GtApprovalLineVO> draftAppSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtDraftDAO.draftAppSelectAll(avo);
	}

	@Override
	public List<GtApprovalLineVO> draftRefSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return gtDraftDAO.draftRefSelectAll(avo);
	}


}
