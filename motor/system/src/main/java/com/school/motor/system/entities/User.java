package com.school.motor.system.entities;

import com.school.motor.system.annotation.Table;

import java.io.Serial;
import java.sql.Timestamp;
@Table("采购合同")
public class User extends BaseEntity{
	@Serial
	private final static long serialVersionUID=1702446595882L;
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userPhone;
	private String userAddress;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer roleId;
	private Integer status;
	public Integer getUserId(){
		return this.userId;
	}
	public void setUserId(Integer userId){
		this.userId=userId;
	}
	public String getUserName(){
		return this.userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public String getUserPassword(){
		return this.userPassword;
	}
	public void setUserPassword(String userPassword){
		this.userPassword=userPassword;
	}
	public String getUserPhone(){
		return this.userPhone;
	}
	public void setUserPhone(String userPhone){
		this.userPhone=userPhone;
	}
	public String getUserAddress(){
		return this.userAddress;
	}
	public void setUserAddress(String userAddress){
		this.userAddress=userAddress;
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
	public Integer getRoleId(){
		return this.roleId;
	}
	public void setRoleId(Integer roleId){
		this.roleId=roleId;
	}
	public Integer getStatus(){
		return this.status;
	}
	public void setStatus(Integer status){
		this.status=status;
	}
}
