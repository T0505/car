package com.school.motor.system.entities;

import java.io.Serial;
import com.school.motor.system.annotation.Table;
@Table("用户人员")
public class SysUser extends BaseEntity{
	@Serial
	private final static long serialVersionUID=1707286386731L;
	private String username;
	private String password;
	private String phone;
	private String address;
	private Integer roleId;
	private Integer status;
	public String getUsername(){
		return this.username;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public String getPassword(){
		return this.password;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPhone(){
		return this.phone;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getAddress(){
		return this.address;
	}
	public void setAddress(String address){
		this.address=address;
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
	@Override
	public String toString() {
		return "SysUser{username="+username+",password="+password+",phone="+phone+",address="+address+",roleId="+roleId+",status="+status+"}";
	}
}