package com.sist.web.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.CommentEntity;
import com.sist.web.vo.CommentVO;

public interface CommentService {
	public Map commentListData(int fno, String type, int page);
	public void commentInsert(CommentEntity vo);
	public void commentDelete(int no);
}
