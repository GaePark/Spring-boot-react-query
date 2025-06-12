package com.sist.web.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.vo.*;
import com.sist.web.entity.*;

public interface BoardService {
	public Map boardListData(@Param("page") int page);
	public BoardDetailVO boardDetailData(@Param("no") int no);
	public void boardInsert(BoardEntity vo);
	public void boardDelete(int no);
	public BoardDetailVO boardUpdate(int no);
	public List<BoardVO> boardMainList();
}
