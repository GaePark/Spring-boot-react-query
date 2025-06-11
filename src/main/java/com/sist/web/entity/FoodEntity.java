package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity(name="project_food")
@Data
public class FoodEntity {
	@Id
	private int fno;
	private int hit,jjimcount,likecount,replycount;
	private double score;
	private String name,type,phone,address,poster,images,time,parking,price,rdays;
	 @Lob 
	 @Column(name = "theme", columnDefinition = "CLOB")
	private String theme;
	 @Lob 
	 @Column(name = "content", columnDefinition = "CLOB")
	 private String content;
}
