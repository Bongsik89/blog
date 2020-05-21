package org.bongsik.blog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.bongsik.blog.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	public SqlSession sqlSession;
	
	public List<BoardVO> getBoardList(){
		return sqlSession.selectList("getBoardList");
	}
	
	public int boardwrite(BoardVO boardVO) {
		return sqlSession.insert("boardwrite", boardVO);
	}

}
