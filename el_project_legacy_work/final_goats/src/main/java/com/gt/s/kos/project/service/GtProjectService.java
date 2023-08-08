package com.gt.s.kos.project.service;
import java.util.List;

import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.project.vo.GtProjectVO;

public interface GtProjectService {
	
	public int gtProjectInsert(GtProjectVO pvo);
	
	public List<GtProjectVO> gtProjectSelectAll();
	
	public List<GtEmployeeVO> gtEmployeeSelectAll();
	
	public List<GtEmployeeVO> gtEmployeeSelect2(GtEmployeeVO evo);
	
	public int gtProjectInsertFile(GtProjectVO pvo);
	
	public List<GtProjectVO> gtProjectsubject(GtProjectVO pvo);
	public List<GtProjectVO> gtProjectSelect(GtProjectVO pvo);
	
} // end of interface
