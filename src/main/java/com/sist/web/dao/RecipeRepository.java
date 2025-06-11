package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.RecipeEntity;
import java.util.*;
import com.sist.web.vo.*;

import jakarta.transaction.Transactional;
@Repository

public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {
	@Query(value = "SELECT no,title,poster,chef,hit,likecount,num "
			+ "FROM (SELECT no,title,poster,chef,hit,likecount,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(project_foodrecipe_no_pk)*/ no,title,poster,chef,hit,likecount "
			+ "FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail))) "
			+ "WHERE num BETWEEN :start AND :end ", nativeQuery = true)
	public List<RecipeVO> recipeListData(@Param("start") int start, @Param("end") int end);
	
	@Query( value = "SELECT COUNT(*) FROM recipe "
			+ "WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)",nativeQuery = true)
	public int recipeCountData();
	
	@Query(value = "SELECT no,title,poster,chef,hit,likecount,rownum as num "
			+ "FROM (SELECT no,title,poster,chef,hit,likecount "
			+ "FROM recipe WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail) "
			+ "ORDER BY no ASC) "
			+ "WHERE rownum <=8",nativeQuery = true) 
	public List<RecipeVO> recipeMainData();
	
	
	@Transactional
	@Modifying
	@Query(value= "UPDATE recipe SET "
			+ "hit=hit+1 WHERE no=:no ")
	public void recipeHitIncrement(@Param("no") int no);
}
