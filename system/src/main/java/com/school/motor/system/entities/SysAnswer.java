package com.school.motor.system.entities;

import java.io.Serial;
import com.school.motor.system.annotation.Table;
@Table("题目答案")
public class SysAnswer extends BaseEntity{
	@Serial
	private final static long serialVersionUID=1703300785074L;
	private String answer;
	private String explains;
	private String video;
	public String getAnswer(){
		return this.answer;
	}
	public void setAnswer(String answer){
		this.answer=answer;
	}
	public String getExplains(){
		return this.explains;
	}
	public void setExplains(String explains){
		this.explains=explains;
	}
	public String getVideo(){
		return this.video;
	}
	public void setVideo(String video){
		this.video=video;
	}

	@Override
	public String toString() {
		return "SysAnswer{" +
				"answer='" + answer + '\'' +
				", explains='" + explains + '\'' +
				", video='" + video + '\'' +
				'}';
	}
}
