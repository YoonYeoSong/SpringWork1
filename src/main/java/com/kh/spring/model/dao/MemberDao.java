package com.kh.spring.model.dao;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.model.vo.Member;

public interface MemberDao {
	
	Member selectMemberOne(SqlSessionTemplate sqlSession, Member m);
}
