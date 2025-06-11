package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;
@RestController
@CrossOrigin(origins = "*")
public class BoardRestController {
	@Autowired
	private BoardService bService;
	
	@GetMapping("/board/list/{page}")
	public ResponseEntity<Map> board_list(@PathVariable("page") int page)
	{
		Map map = new HashMap();
		try {
			map=bService.boardListData(page);
		}catch(Exception ex)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/board/detail/{no}")
	public ResponseEntity<BoardDetailVO> board_detail(@PathVariable("no") int no)
	{
		BoardDetailVO vo = null;
		try {
			vo=bService.boardDetailData(no);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}
	
	@PostMapping("/board/insert")
	public ResponseEntity<String> board_insert(@RequestBody BoardEntity vo)
	{
		try {
			bService.boardInsert(vo);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("YES",HttpStatus.OK);
	}
	@DeleteMapping("/board/delete/{no}")
	public ResponseEntity<String> board_delete(@PathVariable("no") int no)
	{
		try {
			bService.boardDelete(no);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>("YES",HttpStatus.OK);
	}
	
	@GetMapping("/board/update/{no}")
	public ResponseEntity<BoardDetailVO> board_update(@PathVariable("no") int no)
	{
		BoardDetailVO vo =null;
		try {
			vo =bService.boardUpdate(no);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}
	
}
