package com.kh.spring.memo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring.memo.model.vo.Memo;

@Repository
public class MemoDaoImpl implements MemoDao{
	@Override
	public List<Memo> selectMemoList(SqlSessionTemplate session) {
		
		return session.selectList("memo.selectMemoList");
	}

}
