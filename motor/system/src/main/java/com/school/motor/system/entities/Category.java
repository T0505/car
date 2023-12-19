package com.school.motor.system.entities;

import java.sql.Timestamp;
public class Category extends BaseEntity{
	private long serialVersionUID=1702446595886L;
	private String categoryName;
	private Integer categoryDel;
	private Timestamp createTime;
	private Timestamp updateTime;
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public String getCategoryName(){
		return this.categoryName;
	}
	public void setCategoryName(String categoryName){
		this.categoryName=categoryName;
	}
	public Integer getCategoryDel(){
		return this.categoryDel;
	}
	public void setCategoryDel(Integer categoryDel){
		this.categoryDel=categoryDel;
	}
	public Timestamp getCreateTime(){
		return this.createTime;
	}
	public void setCreateTime(Timestamp createTime){
		this.createTime=createTime;
	}
	public Timestamp getUpdateTime(){
		return this.updateTime;
	}
	public void setUpdateTime(Timestamp updateTime){
		this.updateTime=updateTime;
	}
}