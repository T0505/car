package com.school.motor.system.entities;

import java.io.Serial;
import java.sql.Timestamp;
import com.school.motor.system.annotation.Table;
@Table("角色信息表")
public class SysRole extends BaseEntity{
	@Serial
	private final static long serialVersionUID=1703300785089L;
	private String roleName;
	private String description;
	private Timestamp updateTime;
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
	public Timestamp getUpdateTime(){
		return this.updateTime;
	}
	public void setUpdateTime(Timestamp updateTime){
		this.updateTime=updateTime;
	}

	@Override
	public String toString() {
		return "SysRole{" +
				"roleName='" + roleName + '\'' +
				", description='" + description + '\'' +
				", updateTime=" + updateTime +
				'}';
	}
}