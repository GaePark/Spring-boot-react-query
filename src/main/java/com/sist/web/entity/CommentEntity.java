package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


import java.util.*;
@Entity(name="reactcomment")
@Data
public class CommentEntity {
	@Id
	private int no;
	private int fno;
	private String id,name,msg,type;
	private Date regdate;
}
