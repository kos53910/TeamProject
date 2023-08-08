package com.gt.s.kos.account.service;

import java.util.List;

import com.gt.s.kos.account.vo.GtAccountVO;

public interface GtAccountService {

	public int gtAccountInsert(GtAccountVO gvo);
	
	public List<GtAccountVO> gtAccountSelectAll(GtAccountVO gvo);
	
	public List<GtAccountVO> gtAccountSelectAll2();
	
	public List<GtAccountVO> gtAccountSelect(GtAccountVO gvo);
	
}
