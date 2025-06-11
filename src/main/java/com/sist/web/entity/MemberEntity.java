package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.*;
/*
ID	VARCHAR2(20 BYTE)
PWD	VARCHAR2(10 BYTE)
NAME	VARCHAR2(51 BYTE)
SEX	CHAR(6 BYTE)
EMAIL	VARCHAR2(100 BYTE)
BIRTHDAY	DATE
ADDRESS	VARCHAR2(100 BYTE)
REGDATE	DATE
 */
@Entity(name="member")
@Data
public class MemberEntity {
	@Id
	private String id;
	private String pwd,name,sex,email,address;
	private Date birthday,regdate;
	
}
