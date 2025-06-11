package com.sist.web.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.entity.MemberEntity;

public interface MemberService {
	public Map memberDetailData(String id,String pwd);
}
