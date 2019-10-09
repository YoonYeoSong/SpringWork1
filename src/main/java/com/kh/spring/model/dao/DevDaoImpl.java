package com.kh.spring.model.dao;



import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.model.vo.Dev;

@Repository
public class DevDaoImpl implements DevDao {

	@Override
	public int insertDev(SqlSessionTemplate sqlSession, Dev dev) {
		
		return sqlSession.insert("dev.insertDev", dev);
	}
	
	@Override
	public List<Dev> selectDevList(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectList("dev.selectDevList");
	}
	
	@Override
	public int updateEnd(SqlSessionTemplate sqlSession, Dev dev) {
		
		return sqlSession.update("dev.updateEnd", dev);
	}
	
	@Override
	public int deleteDev(SqlSessionTemplate sqlSession, int devNo) {
		
		return sqlSession.delete("dev.deleteDev", devNo);
	}

}
