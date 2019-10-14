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
	
	@Override
	public int memberEnrollEnd(SqlSessionTemplate sqlSession, Member m) {
		// TODO Auto-generated method stub
		return sqlSession.insert("member.memberEnrollEnd", m);
	}

}
