package com.gt.s.kos.schedule.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.schedule.vo.GtScheduleVO;

@Repository
public class GtScheduleDAOImpl implements GtScheduleDAO {
	
	@Autowired(required = false)
 
	private SqlSession sqlSession;
	
	@Override
	public List<GtScheduleVO> gtScheduleSelectAll(GtScheduleVO svo) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<GtScheduleVO> gtScheduleSelectVa(GtScheduleVO svo) { 
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtScheduleSelectVa", svo);
	}


	@Override
	public List<GtScheduleVO> gtScheduleSelectBu(GtScheduleVO svo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtScheduleSelectBu", svo);
	}

}
