package com.sist.web.vo;
/*
 * no,fno,id,name,msg,TO_CHAR(regdate, 'yyyy-MM-dd') as dbday,num
 */
public interface CommentVO {
	public int getNo();
	public int getFno();
	public String getId();
	public String getName();
	public String getMsg();
	public String getDbday();
	public int getNum();
}
