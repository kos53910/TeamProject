package com.gt.s.kos.resignation.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.resignation.vo.GtResignationVO;

@Repository
public class GtResignationDAOImpl implements GtResignationDAO {
	
	Logger logger = LogManager.getLogger(GtResignationDAOImpl.class);
	
	@Autowired(required=false)
 
	private SqlSession sqlSession;
	
	@Override
	public int gtResignationInsert(GtResignationVO rvo) {
		
		logger.info(">>> gtResignationInsert() In");
		
		return sqlSession.insert("gtResignationInsert");		
	}
	
	@Override
	public int gtResignationInsertFile(GtResignationVO rvo) {
	
		logger.info(">>> gtResignationInsertFile() In");
		
		return sqlSession.update("gtResignationInsertFile");
	}

	@Override
	public List<GtResignationVO> gtResignationSelectAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtResignationSelectAll");
	}

	@Override
	public List<GtApprovalLineVO> gtResignationAppSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtResignationAppSelectAll", avo);
	}

	@Override
	public List<GtApprovalLineVO> gtResignationRefSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtResignationRefSelectAll", avo);
	}
	
	@Override
	public List<GtResignationVO> gtResignationSelect(GtResignationVO rvo) {
		return sqlSession.selectList("gtResignationSelect", rvo);
	}

}
