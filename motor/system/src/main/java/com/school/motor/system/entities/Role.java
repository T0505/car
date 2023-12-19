package com.school.motor.system.entities;

import java.io.Serial;
import java.sql.Timestamp;
import com.school.motor.system.annotation.Table;
@Table("")
public class Role extends BaseEntity{
	@Serial
	private final static long serialVersionUID=1702987676330L;
	private String roleName;
	private String description;
	private Timestamp createTime;
	private Timestamp updateTime;
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public String getRoleName(){
		return this.roleName;
	}
	public void setRoleName(String roleName){
		this.roleName=roleName;
	}
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description=description;
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