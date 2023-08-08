package com.gt.s.kos.account.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.account.vo.GtAccountVO;

@Repository
public class GtAccountDAOImpl implements GtAccountDAO {

	@Autowired(required = false)
 
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int gtAccountInsert(GtAccountVO gvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("gtAccountInsert", gvo);
	}

	@Override
	public List<GtAccountVO> gtAccountSelectAll(GtAccountVO gvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtAccountSelectAll", gvo);
	}

	@Override
	public List<GtAccountVO> gtAccountSelect(GtAccountVO gvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtAccountSelect", gvo);
	}

	@Override
	public List<GtAccountVO> gtAccountSelectAll2() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtAccountSelectAll2");
	}

}
