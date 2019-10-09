package com.kh.spring.model.service;

import java.util.List;

import com.kh.spring.model.vo.Dev;

public interface DevService {
	
	int insertDev(Dev dev);
	List<Dev> selectDevList();

}
