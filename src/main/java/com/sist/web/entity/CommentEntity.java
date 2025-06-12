package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.*;
@Entity(name="reactcomment")
@Data
public class CommentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reactcomment_no_seq")
	@SequenceGenerator(name = "reactcomment_no_seq", sequenceName = "reactcomment_no_seq", allocationSize = 1)
	private int no;
	private int fno;
	private String id,name,msg,type;
	@Column(name="regdate", insertable = false, updatable = false)
	private LocalDateTime regdate;
}
