package org.bongsik.blog.controller;

import javax.servlet.http.HttpSession;

import org.bongsik.blog.service.BoardService;
import org.bongsik.blog.service.UserService;
import org.bongsik.blog.vo.BoardVO;
import org.bongsik.blog.vo.MembersVO;
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
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "jquery/boardwrite", method = RequestMethod.POST)
	@ResponseBody
	public int boardwrite(BoardVO boardVO) {
		int result = 0;
		result = boardService.boardwrite(boardVO);
		return result;
	}
	
	@RequestMapping("jquery/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginUser");
		return "user/login";
	}
	
	@RequestMapping(value = "jquery/login",method = RequestMethod.POST)
	@ResponseBody
	public int login(MembersVO membersVO,HttpSession session) {
		int result = 0;
		String col = null;
		col = "userId";
		MembersVO userIdCheck = userService.getUserOne(membersVO.getUserId(),col);
		if(userIdCheck == null) {
			result=2;
		}else {
			if(membersVO.getUserId().equals(userIdCheck.getUserId())) {
				//ID OK
				if(membersVO.getPassword().equals(userIdCheck.getPassword())) {
					//PW OK
					session.setAttribute("loginUser", userIdCheck);
					result = 3;
				} else {
					result = 2;
				}
			} else {
				//ID not OK
				result = 2;
			}
		}
		return result;
	}
	
	@RequestMapping(value = "jquery/signUp",method = RequestMethod.POST)
	@ResponseBody
	public int signUp(MembersVO membersVO) {
		int result = 0;
		String col = null;
		
		col = "userId";
		MembersVO userIdCheck = userService.getUserOne(membersVO.getUserId(),col);
		if(userIdCheck != null) {
		result = 2; 
		}
		
		col = "nickname";
		MembersVO userNicknameCheck = userService.getUserOne(membersVO.getNickname(),col);
		if(userNicknameCheck != null) { result = 3; }	
		
		if(result < 2) {
		result = userService.userJoin(membersVO);	
		}
		
		
		return result;
	}

}
