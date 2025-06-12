package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.*;
import com.sist.web.vo.*;
import java.util.*;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
	@Query(value = "SELECT no,fno,id,name,msg,TO_CHAR(regdate, 'yyyy-MM-dd') as dbday,num "
			+ "FROM (SELECT no,fno,id,name,msg,regdate,rownum as num "
			+ "FROM (SELECT /*+INDEX_DESC(reactcomment comment_no_pk)*/ no,fno,id,name,msg,regdate "
			+ "FROM reactcomment WHERE fno=:fno AND type=:type)) "
			+ "WHERE num BETWEEN :start AND :end", nativeQuery = true)
	public List<CommentVO> commentListData(@Param("fno") int fno, @Param("type") String type, @Param("start") int start, @Param("end") int end);
	
	@Query(value="SELECT CEIL(COUNT(*)/10.0) FROM reactcomment WHERE fno=:fno AND type=:type", nativeQuery = true)
	public int commentTotalPage(@Param("fno") int fno, @Param("type") String type);
}
