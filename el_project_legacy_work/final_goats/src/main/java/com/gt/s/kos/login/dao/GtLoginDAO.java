package com.gt.s.kos.login.dao;

import java.util.List;

import com.gt.s.kos.employee.vo.GtEmployeeVO;

public interface GtLoginDAO {
	
	public List<GtEmployeeVO> logincheck(GtEmployeeVO evo);

}
