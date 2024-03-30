package com.sam.app.insa.mapper;

import java.util.List;

import com.sam.app.common.Paging;
import com.sam.app.insa.service.DepartmentsVO;

public interface DepartmentsMapper {

	List<DepartmentsVO> getDeptList(Paging pvo);
}
