package com.gt.s.kos.draft.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.draft.vo.GtDraftVO;

@Repository
public class GtDraftDAOImpl implements GtDraftDAO {

	@Autowired(required = false)
 
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int gtDraftInsert(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("gtDraftInsert", gdvo);
	}

	@Override
	public List<GtDraftVO> gtDraftSelect(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtDraftSelect", gdvo);
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
	public int gtDraftInsertFile(GtDraftVO gdvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("gtDraftInsertFile", gdvo);
	}

	@Override
	public List<GtApprovalLineVO> draftAppSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("draftAppSelectAll", avo);
	}

	@Override
	public List<GtApprovalLineVO> draftRefSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("draftRefSelectAll", avo);
	}



}
