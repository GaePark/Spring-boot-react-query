package com.sist.web.entity;
/*
 * NO	NUMBER
SUBJECT	VARCHAR2(200 BYTE)
REGDATE	DATE
CONTENT	VARCHAR2(4000 BYTE)
ID	VARCHAR2(20 BYTE)
NAME	VARCHAR2(51 BYTE)
HIT	NUMBER
 */
import java.time.LocalDateTime; 
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
/*
 * no int AI PK 
name text 
subject text 
content text 
pwd text 
regdate datetime 
hit int
 */
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
@Entity(name = "reactboard")
@Data
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reactboard_no_seq")
	@SequenceGenerator(name = "reactboard_no_seq", sequenceName = "reactboard_no_seq", allocationSize = 1)
	private int no;
	private String name,subject,id,content;
    private LocalDateTime regdate;
	private int hit;
}
