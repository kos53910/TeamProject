package com.gt.s.kos.contract.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.contract.vo.GtContractVO;

@Repository
public class GtContractDAOImpl implements GtContractDAO {

	@Autowired(required = false)
 
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int gtContractInsert(GtContractVO cvo) {
		// Insert
		return sqlSession.insert("gtContractInsert", cvo);
	}
	
	@Override
	public int gtContractInsertFile(GtContractVO cvo) {
		// Insert File
		return sqlSession.update("gtContractInsertFile", cvo);
	}

	@Override
	public List<GtContractVO> gtContractSelectAll(GtContractVO cvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtContractSelectAll");
	}

	@Override
	public List<GtApprovalLineVO> gtContractAppSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtContractAppSelectAll", avo);
	}

	@Override
	public List<GtApprovalLineVO> gtContractRefSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtContractRefSelectAll", avo);
	}

	@Override
	public List<GtContractVO> gtContractSelect(GtContractVO cvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtContractSelect", cvo);
	}

}
