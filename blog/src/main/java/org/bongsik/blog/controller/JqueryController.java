package org.bongsik.blog.controller;

import org.bongsik.blog.service.BoardService;
import org.bongsik.blog.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("jquery/*")
public class JqueryController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "jquery/boardwrite", method = RequestMethod.POST)
	@ResponseBody
	public int boardwrite(BoardVO boardVO) {
		int result = 0;
		result = boardService.boardwrite(boardVO);
		return result;
	}

}
