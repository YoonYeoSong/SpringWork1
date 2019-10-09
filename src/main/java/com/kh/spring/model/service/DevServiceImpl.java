package com.kh.spring.model.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.model.dao.DevDao;
import com.kh.spring.model.vo.Dev;

@Service
public class DevServiceImpl implements DevService {
	
	@Autowired
	DevDao dao;
	
	@Autowired
	SqlSessionTemplate sqlSession;

	@Override
	public int insertDev(Dev dev) {
		
		return dao.insertDev(sqlSession, dev);
	}
	
	@Override
	public List<Dev> selectDevList() {
		// TODO Auto-generated method stub
		return dao.selectDevList(sqlSession);
	}

}
