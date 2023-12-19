package com.school.motor.system.entities;

import java.io.Serial;
import java.sql.Timestamp;
import com.school.motor.system.annotation.Table;
@Table("")
public class Category extends BaseEntity{
	@Serial
	private final static long serialVersionUID=1702987676298L;
	private String categoryName;
	private Integer categoryDelete;
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
	public Integer getCategoryDelete(){
		return this.categoryDelete;
	}
	public void setCategoryDelete(Integer categoryDelete){
		this.categoryDelete=categoryDelete;
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