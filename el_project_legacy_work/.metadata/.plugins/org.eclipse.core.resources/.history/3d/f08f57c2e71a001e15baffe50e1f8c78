package com.gt.s.kos.dept.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.dept.vo.GtDeptVO;



@Repository
public class GtDeptDAOImpl implements GtDeptDAO {
	
	@Autowired(required = false)
	private SqlSession sqlSession;
	
	@Override
	public List<GtDeptVO> goatsDeptSelectAll() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("goatsDeptSelectAll");
	}

}
