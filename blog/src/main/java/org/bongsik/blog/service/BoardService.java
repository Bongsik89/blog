package org.bongsik.blog.service;

import java.util.List;

import org.bongsik.blog.vo.BoardVO;

public interface BoardService {
	
	List getBoardList();
	int boardwrite(BoardVO boardVO);
	BoardVO getBoardDetail(int id);
	void viewsUpdate(int id);

}
