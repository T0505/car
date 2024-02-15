package com.school.motor.system.entities;

import java.io.Serial;
import java.time.LocalDateTime;
import com.school.motor.system.annotation.Table;
@Table("科目类型")
public class SysSubject extends BaseEntity{
	@Serial
	private final static long serialVersionUID=1703300785083L;
	private String name;
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}

	@Override
	public String toString() {
		return "SysSubject{" +
				"name='" + name + '\'' +
				'}';
	}
}