package com.gt.s.kos.schedule.dao;

import java.util.List;



import com.gt.s.kos.schedule.vo.GtScheduleVO;


public interface GtScheduleDAO {
	
	public List<GtScheduleVO> gtScheduleSelectAll(GtScheduleVO svo);
	
	public List<GtScheduleVO> gtScheduleSelectVa(GtScheduleVO svo);
	
	public List<GtScheduleVO> gtScheduleSelectBu(GtScheduleVO svo);

} // end of interface
