package com.school.motor.system.entities;

import java.io.Serial;
import com.school.motor.system.annotation.Table;
@Table("")
public class ClassInfo extends BaseEntity{
	@Serial
	private final static long serialVersionUID=1702900463386L;
	private String classname;
	private String teacher;
	private String major;
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public String getClassname(){
		return this.classname;
	}
	public void setClassname(String classname){
		this.classname=classname;
	}
	public String getTeacher(){
		return this.teacher;
	}
	public void setTeacher(String teacher){
		this.teacher=teacher;
	}
	public String getMajor(){
		return this.major;
	}
	public void setMajor(String major){
		this.major=major;
	}
}