package com.sist.web.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.*;
import com.sist.web.entity.*;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberRepository mDao;
	

	@Override
	public Map memberDetailData(String id, String pwd) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int result = mDao.idCount(id, pwd);
		if(result!=1)
		{
			map.put("msg", "NO");
			return map;
		}
		MemberEntity vo = mDao.memberDetailData(id);
		map.put("msg", "YES");
		map.put("name", vo.getName());
		map.put("id", vo.getId());
		return map;
	}
	

}
