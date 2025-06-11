package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.entity.*;

@RestController
@CrossOrigin(origins = "*")
public class MemberRestComtroller {
	@Autowired
	private MemberService mService;
	@GetMapping("/member/login/{id}/{pwd}")
	public ResponseEntity<Map> memberData(@PathVariable("id") String id,@PathVariable("pwd") String pwd)
	{
		Map map = new HashMap();
		try
		{
			map=mService.memberDetailData(id, pwd);
			
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
