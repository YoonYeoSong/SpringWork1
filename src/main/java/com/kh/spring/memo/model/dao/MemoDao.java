package com.kh.spring.memo.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.kh.spring.memo.model.vo.Memo;

public interface MemoDao {
	List<Memo> selectMemoList(SqlSessionTemplate session);

}
