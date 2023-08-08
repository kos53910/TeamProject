package com.gt.s.kos.employee.service;

import java.util.List;

import com.gt.s.kos.employee.vo.GtEmployeeVO;


public interface GtEmployeeService {
	
	public GtEmployeeVO genumcheck(GtEmployeeVO evo);
	public GtEmployeeVO goatempidcheck(GtEmployeeVO evo);
	public List<GtEmployeeVO> goatsEmployeeSelect(GtEmployeeVO evo);
	public List<GtEmployeeVO> gtEmployeeIdcheck(GtEmployeeVO evo);
	public int gtEmployeeInsert(GtEmployeeVO evo);
	public int gtEmployeeFileInsert(GtEmployeeVO evo);
	public List<GtEmployeeVO> gtEmployeeDecianotherSelect(GtEmployeeVO evo);
	public GtEmployeeVO gecheck(GtEmployeeVO evo);
	public GtEmployeeVO emailcheck(GtEmployeeVO evo);
	public List<GtEmployeeVO> gtpwCheck(GtEmployeeVO evo);
	public int gtpwupdateCheck(GtEmployeeVO evo);
	public int gtinfupdate(GtEmployeeVO evo);
	public List<GtEmployeeVO> gtEmployeeSelect(GtEmployeeVO evo);
	public int gtEmployeeUpdate(GtEmployeeVO evo);
}
