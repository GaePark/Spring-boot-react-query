package com.sist.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.*;
import com.sist.web.entity.*;
import com.sist.web.vo.BoardDetailVO;
import com.sist.web.vo.BoardVO;

import jakarta.transaction.Transactional;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardRepository bDao;
	@Override
	public Map boardListData(int page) {
		Map map = new HashMap();
		int rowSize = 10;
		int start= (rowSize*page)-(rowSize-1);
		int end=(rowSize*page);
		List<BoardVO> list = bDao.boardListData(start, end);
		int count = (int) bDao.count();
		int totalpage= (int)(Math.ceil(count/10.0));
		
		map.put("list", list);
		map.put("totalpage", totalpage);
		
		return map;
	}

	@Transactional
	@Override
	public BoardDetailVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		BoardEntity vo = bDao.boardDetail(no);
		vo.setHit(vo.getHit()+1);
		
		bDao.save(vo);
		
		return bDao.boardDetailData(no);
	}

	@Override
	public void boardInsert(BoardEntity vo) {
		bDao.save(vo);
		
	}

	@Override
	public void boardDelete(int no) {
		// TODO Auto-generated method stub
		bDao.deleteById(no);
	}

	@Override
	public BoardDetailVO boardUpdate(int no) {
		// TODO Auto-generated method stub
		return bDao.boardDetailData(no);
	}

	@Override
	public List<BoardVO> boardMainList() {
		// TODO Auto-generated method stub
		return bDao.boardMainList();
	}
	
}
