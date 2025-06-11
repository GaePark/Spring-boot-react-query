package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

/*
 *  NO	NUMBER
POSTER	VARCHAR2(4000 BYTE)
TITLE	VARCHAR2(1000 BYTE)
CHEF	VARCHAR2(1000 BYTE)
CHEF_POSTER	VARCHAR2(1000 BYTE)
CHEF_PROFILE	VARCHAR2(1000 BYTE)
INFO1	VARCHAR2(100 BYTE)
INFO2	VARCHAR2(100 BYTE)
INFO3	VARCHAR2(100 BYTE)
CONTENT	VARCHAR2(4000 BYTE)
FOODMAKE	CLOB
DATA	CLOB 

 */
@Entity(name="RECIPEDETAIL")
@Data
public class RecipeDetailEntity {
   @Id
   private int no;
   private String poster,title,chef,chef_poster,chef_profile,info1,info2,info3,
           content;
   @Lob 
   @Column(name = "foodmake", columnDefinition = "CLOB")
   private String foodmake;
   @Lob 
   @Column(name = "data", columnDefinition = "CLOB")
   private String data;
}