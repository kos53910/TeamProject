package com.gt.s.kos.plan.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.plan.vo.GtPlanVO;

@Repository
public class GtPlanDAOImpl implements GtPlanDAO {
	
	@Autowired(required = false)
 
	private SqlSessionTemplate sqlSession;

	@Override
	public int gtPlanInsert(GtPlanVO pvo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("gtPlanInsert", pvo);
	}
}
