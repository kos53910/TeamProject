package com.gt.s.kos.spend.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.spend.vo.GtSpendVO;

@Repository
public class GtSpendDAOImpl implements GtSpendDAO {

	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired(required = false)
 
	private SqlSessionTemplate sqlSession;

	@Override
	public int gtSpendInsert(GtSpendVO svo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("gtSpendInsert", svo);
	}

	@Override
	public int gtSpendInsertFile(GtSpendVO svo) {
		// TODO Auto-generated method stub
		return sqlSession.update("gtSpendInsertFile", svo);
	}

	@Override
	public List<GtSpendVO> gtSpendSelectAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtSpendSelectAll");
	}

	@Override
	public List<GtApprovalLineVO> gtSpendAppSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtSpendAppSelectAll", avo);
	}

	@Override
	public List<GtApprovalLineVO> gtSpendRefSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtSpendRefSelectAll", avo);
	}

	@Override
	public List<GtSpendVO> gtSpendSelect(GtSpendVO svo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtSpendSelect", svo);
	}
	
	
}
