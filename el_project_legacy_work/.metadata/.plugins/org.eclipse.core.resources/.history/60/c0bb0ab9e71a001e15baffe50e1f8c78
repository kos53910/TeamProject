package com.gt.s.kos.approvalline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;



@Repository
public class GtApprovallineDAOImpl implements GtApprovallineDAO {
	
	private SqlSession sqlSession;
	
	@Override
	public List<GtApprovalLineVO> goatApprovalOCSelectAll() {
		// TODO Auto-generated method stub
		System.out.println("DAOIMP goatApprovalOCSelectAll >>>> : 함수진입");
		return sqlSession.selectList("goatApprovalOCSelectAll");
		
	} // end of goatProjectSelectAll

	@Override
	public List<GtApprovalLineVO> goatApprovalSelect(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GtApprovalLineVO> goatApprovalMemberSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

} // end of class
