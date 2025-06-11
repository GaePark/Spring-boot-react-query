package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.FoodEntity;
import java.util.*;
import com.sist.web.vo.*;

import jakarta.transaction.Transactional;
@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer>{
	@Query( value = "SELECT fno,name,type,poster,phone,likecount,hit,rownum as num "
			+ "From (SELECT fno,name,type,poster,phone,likecount,hit FROM project_food ORDER BY fno) "
			+ "WHERE rownum <=8",nativeQuery = true)
	public List<FoodVO> foodMainData();
	@Query(value = "SELECT fno,name,type,likecount,poster,phone,hit,num "
			+ "FROM (SELECT fno,name,type,likecount,poster,phone,hit,rownum as num "
			+ "FROM (SELECT /*+ INDEX_ASC(project_food pf_fno_pk)*/ fno,name,type,likecount,poster,phone,hit "
			+ "FROM project_food)) "
			+ "WHERE num BETWEEN :start AND :end", nativeQuery = true)
	public List<FoodVO> foodListData(@Param("start") int start, @Param("end") int end);
	@Query( value = "SELECT COUNT(*) FROM project_food ",nativeQuery = true)
	public int recipeCountData();
	
	@Query(value = "SELECT * FROM project_food WHERE fno=:fno",nativeQuery = true)
	public FoodEntity foodDetailData(@Param("fno") int fno);
	
	@Transactional
	@Modifying
	@Query (value= "UPDATE project_food SET "
			+ "hit = hit+1 WHERE fno=:fno",nativeQuery = true)
	public void foodHitIncrement(@Param("fno") int fno);
	
}
