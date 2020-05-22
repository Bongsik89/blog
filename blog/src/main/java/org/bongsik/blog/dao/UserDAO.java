package org.bongsik.blog.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.bongsik.blog.vo.MembersVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	@Autowired
	public SqlSession sqlSession;
	
	public MembersVO getUserOne(String common, String col) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		if(col.equals("userId")) {
			map.put("userId",common);
		}else if(col.equals("nickname")) {
			map.put("nickname",common);
		}
		return sqlSession.selectOne("getUserOne",map);
	}

	public int userJoin(MembersVO membersVO) {
		return sqlSession.insert("userJoin",membersVO);
	}

}
