package org.bongsik.blog.service;

import java.util.List;

import org.bongsik.blog.dao.BoardDAO;
import org.bongsik.blog.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO boardDAO;

	@Override
	public List<BoardVO> getBoardList() {
		return boardDAO.getBoardList();
	}

	@Override
	public int boardwrite(BoardVO boardVO) {		
		return boardDAO.boardwrite(boardVO);
	}

	@Override
	public BoardVO getBoardDetail(int id) {
		return boardDAO.getBoardDetail(id);
	}

	@Override
	public void viewsUpdate(int id) {
		boardDAO.viewUpdate(id);
	}

}
