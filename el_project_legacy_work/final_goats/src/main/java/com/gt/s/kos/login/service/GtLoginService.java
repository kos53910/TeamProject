package com.gt.s.kos.login.service;

import java.util.List;

import com.gt.s.kos.employee.vo.GtEmployeeVO;

public interface GtLoginService {

	public List<GtEmployeeVO> logincheck(GtEmployeeVO evo);
	
}
