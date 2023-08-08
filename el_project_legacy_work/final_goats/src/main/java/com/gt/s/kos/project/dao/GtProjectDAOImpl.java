package com.gt.s.kos.project.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.project.vo.GtProjectVO;

@Repository
public class GtProjectDAOImpl implements GtProjectDAO {
	Logger log = LogManager.getLogger(this.getClass());
	
	@Autowired(required = false)
 
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int gtProjectInsert(GtProjectVO pvo) {
		// TODO Auto-generated method stub
		
		return sqlSession.insert("gtProjectInsert", pvo);
		
	} // end of gtProjectInsert

	@Override
	public List<GtProjectVO> gtProjectSelectAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtProjectSelectAll");
	}

	@Override
	public List<GtEmployeeVO> gtEmployeeSelectAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtEmployeeSelectAll");
	}

	@Override
	public List<GtEmployeeVO> gtEmployeeSelect2(GtEmployeeVO evo) {
		// TODO Auto-generated method stub
		log.info("GtProjectDAOImpl.gtEmployeeSelect2 함수진입");
		return sqlSession.selectList("gtEmployeeSelect2", evo);
	}

	@Override
	public int gtProjectInsertFile(GtProjectVO pvo) {
		// TODO Auto-generated method stub
		return sqlSession.update("gtProjectInsertFile", pvo);
	}

	@Override
	public List<GtProjectVO> gtProjectsubject(GtProjectVO pvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtProjectsubject", pvo);
	}
	@Override
	public List<GtProjectVO> gtProjectSelect(GtProjectVO pvo) {
		log.info("GtProjectDAOImpl.gtProjectSelect 함수진입");
		return sqlSession.selectOne("gtProjectSelect", pvo);
	}

} // end of class
