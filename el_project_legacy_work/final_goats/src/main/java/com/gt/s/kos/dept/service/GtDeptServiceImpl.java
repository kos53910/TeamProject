package com.gt.s.kos.dept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.dept.dao.GtDeptDAO;
import com.gt.s.kos.dept.vo.GtDeptVO;



@Service
@Transactional
public class GtDeptServiceImpl implements GtDeptService {
	
	@Autowired(required = false)
 
	private GtDeptDAO gtDeptDAO;
	
	@Override
	public List<GtDeptVO> goatsDeptSelectAll() {
		// TODO Auto-generated method stub
		return gtDeptDAO.goatsDeptSelectAll();
	} 

}
