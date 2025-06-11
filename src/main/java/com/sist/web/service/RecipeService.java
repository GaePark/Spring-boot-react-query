package com.sist.web.service;

import java.util.*;

import org.springframework.data.repository.query.Param;

import com.sist.web.vo.RecipeDetailVO;
import com.sist.web.vo.RecipeVO;

public interface RecipeService {
	public List<RecipeVO> recipeMainData();
	public Map recipeListData(int page);
	public Map recipeDetailData(@Param("no") int no);
}
