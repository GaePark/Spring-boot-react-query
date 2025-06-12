package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.vo.*;
import com.sist.web.service.*;
@RestController
@CrossOrigin(origins = "*")
public class MainRestController {
	@Autowired
	private RecipeService rService;
	
	@Autowired
	private FoodService fService;
	
	@Autowired
	private BoardService bService;
	
	@GetMapping("/main")
	public ResponseEntity<Map> main_data()
	{
		Map map=new HashMap();
		try
		{
			List<RecipeVO> rList=rService.recipeMainData();
			List<FoodVO> fList=fService.foodMainData();
			List<BoardVO> bList=bService.boardMainList();
			map.put("rList", rList);
			map.put("fList", fList);
			map.put("bList", bList);
			
		}catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
