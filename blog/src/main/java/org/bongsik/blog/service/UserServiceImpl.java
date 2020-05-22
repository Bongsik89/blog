package org.bongsik.blog.service;

import org.bongsik.blog.dao.UserDAO;
import org.bongsik.blog.vo.MembersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;

	@Override
	public MembersVO getUserOne(String common, String col) {		
		return userDAO.getUserOne(common, col);
	}

	@Override
	public int userJoin(MembersVO membersVO) {
		return userDAO.userJoin(membersVO);
	}

}
