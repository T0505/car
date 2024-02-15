package com.school.motor.system.entities;

import java.io.Serial;
import java.time.LocalDateTime;
import com.school.motor.system.annotation.Table;
@Table("题目类别")
public class SysModel extends BaseEntity{
	@Serial
	private final static long serialVersionUID=1703300785079L;
	private String title;
	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title=title;
	}

	@Override
	public String toString() {
		return "SysModel{" +
				"title='" + title + '\'' +
				'}';
	}
}