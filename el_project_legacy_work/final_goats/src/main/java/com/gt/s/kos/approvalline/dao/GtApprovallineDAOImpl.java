package com.gt.s.kos.approvalline.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;



@Repository
public class GtApprovallineDAOImpl implements GtApprovallineDAO {
	
	@Autowired(required = false)
 
	private SqlSessionTemplate sqlSession;
	
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

	@Override
	public int goatcountup(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.update("goatcountup", avo);
	}

	@Override
	public List<GtApprovalLineVO> gtemailSelect(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtemailSelect", avo);
	}

	@Override
	public int gtJeonCountUp(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.update("gtJeonCountUp", avo);
	}

	@Override
	public int gtDeciCountUp(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.update("gtDeciCountUp", avo);
	}

	@Override
	public int gtDelete(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.update("gtDelete", avo);
	}

	@Override
	public int gtNappCountDown(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.update("gtNappCountDown", avo);
	}

} // end of class
