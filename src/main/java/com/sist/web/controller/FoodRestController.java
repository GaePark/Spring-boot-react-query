package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.sist.web.entity.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;
@RestController
@CrossOrigin(origins = "*")
public class FoodRestController {
	@Autowired
	private FoodService fService;
	
	@GetMapping("/food/list/{page}")
	public ResponseEntity<Map> food_list(@PathVariable("page") int page)
	{
		Map map = new HashMap();
		try {
			map = fService.foodListData(page);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	@GetMapping("/food/detail/{fno}")
	public ResponseEntity<FoodEntity> food_detail(@PathVariable(value = "fno",required = false) int fno)
	{
		FoodEntity vo = new FoodEntity();
		
		try {
			
			vo = fService.foodDetailData(fno);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(vo,HttpStatus.OK);
	}
}
