package com.gt.s.kos.organization.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.organization.vo.GtOrganizationVO;

@Repository
public class GtOrganizationDAOImpl implements GtOrganizationDAO {

	
	@Autowired(required = false)
 
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<GtEmployeeVO> gtOrganizationSelectAll(GtEmployeeVO evo) {
		// TODO Auto-generated method stub
		System.out.println("goatsOrganizationSelectAll impl 들어옴 >>> :");
		
		return sqlSession.selectList("gtOrganizationSelectAll",evo);
	}

}
