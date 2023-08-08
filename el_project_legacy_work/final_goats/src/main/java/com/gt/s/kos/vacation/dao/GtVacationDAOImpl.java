package com.gt.s.kos.vacation.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.approvalline.vo.GtApprovalLineVO;
import com.gt.s.kos.vacation.vo.GtVacationVO;

@Repository
public class GtVacationDAOImpl implements GtVacationDAO {
	Logger log = LogManager.getLogger(this.getClass());
	

	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int gtVacationInsert(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		log.info("gtVacationInsert 진입 > : ");
		return sqlSession.insert("gtVacationInsert", vvo);
	}

	@Override
	public int gtVacationInsertFile(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		log.info("gtVacationInsertFile 진입 > : ");
		return sqlSession.update("gtVacationInsertFile", vvo);
	}

	@Override
	public List<GtVacationVO> gtVacationSelectAll(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		log.info("gtVacationSelectAll > 진입 : ");
		return sqlSession.selectList("gtVacationSelectAll", vvo);
	}

	@Override
	public List<GtVacationVO> gtVacationSelect(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		log.info("gtVacationSelect > 진입 : ");
		return sqlSession.selectList("gtVacationSelect", vvo);
	}

	@Override
	public List<GtVacationVO> gtVacationUpdate(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		log.info("gtVacationUpdate > 진입 : ");
		return sqlSession.selectList("gtVacationUpdate", vvo); 
	}

	@Override
	public int gtVacationDelete(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		log.info("gtVacationDelete > 진입 : ");
		return  sqlSession.delete("gtVacationDelete", vvo);
	}

	@Override
	public List<GtApprovalLineVO> gtVacationAppSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtVacationAppSelectAll", avo);
	}

	@Override
	public List<GtApprovalLineVO> gtVacationRefSelectAll(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtVacationRefSelectAll", avo);
	}

	@Override
	public List<GtApprovalLineVO> gtDeciVacationSelect(GtApprovalLineVO avo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtDeciVacationSelect", avo);
	}

	@Override
	public List<GtVacationVO> gtVacationSelect_(GtVacationVO vvo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("gtVacationSelect_", vvo);
	}

}
