package com.kh.spring.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.model.vo.Member;

@Repository
public class MemberDaoImpl implements MemberDao {

	
	
	@Override
	public Member selectMemberOne(SqlSessionTemplate sqlSession, Member m) {
		
		return sqlSession.selectOne("member.selectMemberOne", m);
	}

}
