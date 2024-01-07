package com.school.motor.system.entities;

import java.io.Serial;
import java.sql.Timestamp;
import com.school.motor.system.annotation.Table;
@Table("题库")
public class SysQuestion extends BaseEntity{
	@Serial
	private final static long serialVersionUID=1703300785093L;
	private String topic;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private Integer modelId;
	private Integer subjectId;
	private Integer answerId;
	private String image;
	public String getTopic(){
		return this.topic;
	}
	public void setTopic(String topic){
		this.topic=topic;
	}
	public String getOptionA(){
		return this.optionA;
	}
	public void setOptionA(String optionA){
		this.optionA=optionA;
	}
	public String getOptionB(){
		return this.optionB;
	}
	public void setOptionB(String optionB){
		this.optionB=optionB;
	}
	public String getOptionC(){
		return this.optionC;
	}
	public void setOptionC(String optionC){
		this.optionC=optionC;
	}
	public String getOptionD(){
		return this.optionD;
	}
	public void setOptionD(String optionD){
		this.optionD=optionD;
	}
	public Integer getModelId(){
		return this.modelId;
	}
	public void setModelId(Integer modelId){
		this.modelId=modelId;
	}
	public Integer getSubjectId(){
		return this.subjectId;
	}
	public void setSubjectId(Integer subjectId){
		this.subjectId=subjectId;
	}
	public Integer getAnswerId(){
		return this.answerId;
	}
	public void setAnswerId(Integer answerId){
		this.answerId=answerId;
	}
	public String getImage(){
		return this.image;
	}
	public void setImage(String image){
		this.image=image;
	}

	@Override
	public String toString() {
		return "SysQuestion{" +
				"topic='" + topic + '\'' +
				", optionA='" + optionA + '\'' +
				", optionB='" + optionB + '\'' +
				", optionC='" + optionC + '\'' +
				", optionD='" + optionD + '\'' +
				", modelId=" + modelId +
				", subjectId=" + subjectId +
				", answerId=" + answerId +
				", image='" + image + '\'' +
				'}';
	}
}