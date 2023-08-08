package com.gt.s.kos.project.dao;

import java.util.List;

import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.project.vo.GtProjectVO;

public interface GtProjectDAO {
	
	public int gtProjectInsert(GtProjectVO pvo);
	
	public List<GtProjectVO> gtProjectSelectAll();
	
	public List<GtProjectVO> gtProjectSelect(GtProjectVO pvo);
	
	public List<GtEmployeeVO> gtEmployeeSelectAll();
	
	public List<GtEmployeeVO> gtEmployeeSelect2(GtEmployeeVO evo);
	
	public int gtProjectInsertFile(GtProjectVO pvo);
	
	public List<GtProjectVO> gtProjectsubject(GtProjectVO pvo);
	
}// end of inter
