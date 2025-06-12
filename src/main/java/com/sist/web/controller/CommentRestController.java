package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.sist.web.service.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;

@RestController
@CrossOrigin(origins = "*")
public class CommentRestController {
	@Autowired
	private CommentService cService;
	
	@GetMapping("/comment/list/{fno}/{type}/{page}")
	public ResponseEntity<Map> comment_list(@PathVariable("fno") int fno,@PathVariable("type") String type, @PathVariable("page") int page)
	{
		Map map =new HashMap();
		try
		{
			map=cService.commentListData(fno, type, page);
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@PostMapping("/comment/insert")
	public ResponseEntity<String> comment_insert(@RequestBody CommentEntity vo)
	{
		try
		{
			cService.commentInsert(vo);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
		return new ResponseEntity<>("YES",HttpStatus.OK);
	}
	
	@PutMapping("/comment/update")
	public ResponseEntity<String> comment_update(@RequestBody CommentEntity vo)
	{
		try
		{
			cService.commentInsert(vo);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
		return new ResponseEntity<>("YES",HttpStatus.OK);
	}
	
	@DeleteMapping("/comment/delete/{no}")
	public ResponseEntity<String> comment_delete(@PathVariable("no") int no)
	{
		try
		{
			cService.commentDelete(no);
		}catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			// TODO: handle exception
		}
		return new ResponseEntity<>("YES",HttpStatus.OK);
	}
}
