package com.gt.s.kos.organization.service;

import java.util.List;

import com.gt.s.kos.employee.vo.GtEmployeeVO;
import com.gt.s.kos.organization.vo.GtOrganizationVO;

public interface GtOrganizationService {

	public List<GtEmployeeVO> gtOrganizationSelectAll(GtEmployeeVO evo);
}
