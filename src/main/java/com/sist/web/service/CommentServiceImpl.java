package com.sist.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;
@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository cDao;
	@Override
	public Map commentListData(int fno, String type, int page) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		int rowSize=10;
		int start = (page*rowSize)-(rowSize-1);
		int end = (page*rowSize);
		
		int totalpage=cDao.commentTotalPage(fno, type);
		List<CommentVO> list = cDao.commentListData(fno, type, start, end);
		map.put("totalpage", totalpage);
		map.put("list", list);
		return map;
	}
	@Override
	public void commentInsert(CommentEntity vo) {
		// TODO Auto-generated method stub
		cDao.save(vo);
	}
	@Override
	public void commentDelete(int no) {
		// TODO Auto-generated method stub
		cDao.deleteById(no);
	}

}
