package com.gt.s.kos.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.login.dao.GtLoginDAO;

@Service
@Transactional
public class GtLoginServiceImpl implements GtLoginService {

	@Autowired(required = false)
 
	private GtLoginDAO gtLoginDAO;

	@Override
	public List<GtEmployeeVO> logincheck(GtEmployeeVO evo) {
		// TODO Auto-generated method stub
		return gtLoginDAO.logincheck(evo);
	}
}
