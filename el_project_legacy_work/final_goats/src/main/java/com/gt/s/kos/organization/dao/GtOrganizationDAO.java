package com.gt.s.kos.organization.dao;

import java.util.List;

import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.organization.vo.GtOrganizationVO;

public interface GtOrganizationDAO {

	public List<GtEmployeeVO> gtOrganizationSelectAll(GtEmployeeVO evo);
}
