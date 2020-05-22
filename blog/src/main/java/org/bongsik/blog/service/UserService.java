package org.bongsik.blog.service;

import org.bongsik.blog.vo.MembersVO;

public interface UserService {
	
	MembersVO getUserOne(String common, String col);
	
	int userJoin(MembersVO members);

}
