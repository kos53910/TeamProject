package com.gt.s.kos.account.dao;

import java.util.List;

import com.gt.s.kos.account.vo.GtAccountVO;

public interface GtAccountDAO {

	public int gtAccountInsert(GtAccountVO gvo);
	
	public List<GtAccountVO> gtAccountSelectAll(GtAccountVO gvo);
	
	public List<GtAccountVO> gtAccountSelectAll2();
	
	public List<GtAccountVO> gtAccountSelect(GtAccountVO gvo);
	
}
