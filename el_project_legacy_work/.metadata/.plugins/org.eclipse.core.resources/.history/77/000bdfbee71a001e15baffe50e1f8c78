package com.gt.s.kos.business.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.business.vo.GtBusinessVO;

@Repository
public class GtBusinessDAOImpl implements GtBusinessDAO {

	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int gtBusinessInsert(GtBusinessVO buvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("gtBusinessInsert", buvo);
	}

	@Override
	public int gtBusinessInsertFile(GtBusinessVO buvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("gtBusinessInsertFile", buvo);
	}

	@Override
	public List<GtBusinessVO> gtBusinessSelectAll(GtBusinessVO buvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtBusinessSelectAll", buvo);
	}

	@Override
	public List<GtBusinessVO> gtBusinessSelect(GtBusinessVO buvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtBusinessSelect", buvo);
	}

	@Override
	public int gtBusinessUpdate(GtBusinessVO buvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("gtBusinessUpdate",buvo);
	}



}
