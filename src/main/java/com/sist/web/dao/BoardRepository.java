package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.entity.BoardEntity;
import com.sist.web.vo.*;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
	
	@Query(value = "SELECT no,name,subject,hit,TO_CHAR(regdate, 'yyyy-MM-dd') as dbday,num "
			+ "FROM (SELECT no,name,subject,hit,regdate,rownum as num "
			+ "FROM (SELECT no,name,subject,hit,regdate "
			+ "FROM reactboard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN :start AND :end", nativeQuery = true)
	public List<BoardVO> boardListData(@Param("start") int start,@Param("end") int end);
	
	
	@Query(value = "SELECT no,name,subject,hit,TO_CHAR(regdate,'yyyy-MM-dd') as dbday,content,id "
			+ " FROM reactboard WHERE no=:no", nativeQuery = true)
	public BoardDetailVO boardDetailData(@Param("no") int no);
	@Query(value="SELECT * FROM reactboard WHERE no=:no", nativeQuery = true)
	public BoardEntity boardDetail(@Param("no") int no);
	
	@Query(value="SELECT no,name,subject,hit,TO_CHAR(regdate,'yyyy-MM-dd') as dbday,num "
			+ "FROM (SELECT no,name,subject,hit,regdate,rownum as num "
			+ "FROM (SELECT no,name,subject,hit,regdate "
			+ "FROM reactboard ORDER BY no DESC)) "
			+ "WHERE num <=4 ", nativeQuery = true)
	public List<BoardVO> boardMainList();
}
