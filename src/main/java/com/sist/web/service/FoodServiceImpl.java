package com.sist.web.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.dao.*;
import com.sist.web.entity.FoodEntity;
import com.sist.web.vo.*;

import jakarta.transaction.Transactional;
@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository fDao;
	
	@Override
	public List<FoodVO> foodMainData() {
		// TODO Auto-generated method stub
		return fDao.foodMainData();
	}

	@Override
	public Map foodListData(int page) {
		Map map=new HashMap();
		int rowSize=12;
		int start=(rowSize*page)-(rowSize-1);
		int end=rowSize*page;
		List<FoodVO> list=fDao.foodListData(start, end);
		int count=fDao.recipeCountData();
		int totalpage=(int)(Math.ceil(count/12.0));
		
		final int BLOCK=10;
		int startPage=((page-1)/BLOCK*BLOCK)+1;
		int endPage=((page-1)/BLOCK*BLOCK)+10;
		
		if(endPage>totalpage)
			endPage=totalpage;
		
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		return map;
	}

	@Override
	public FoodEntity foodDetailData(int fno) {
		// TODO Auto-generated method stub
		fDao.foodHitIncrement(fno);
		return fDao.foodDetailData(fno);
	}

}
