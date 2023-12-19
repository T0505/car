package com.school.motor.system.entities;

import java.io.Serial;
import java.sql.Timestamp;
import com.school.motor.system.annotation.Table;
@Table("")
public class Question extends BaseEntity{
	@Serial
	private final static long serialVersionUID=1702987676311L;
	private String questionText;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private Integer categoryId;
	private String questionImage;
	private Integer questionKeyId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer questionDelete;
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public String getQuestionText(){
		return this.questionText;
	}
	public void setQuestionText(String questionText){
		this.questionText=questionText;
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
	public Integer getCategoryId(){
		return this.categoryId;
	}
	public void setCategoryId(Integer categoryId){
		this.categoryId=categoryId;
	}
	public String getQuestionImage(){
		return this.questionImage;
	}
	public void setQuestionImage(String questionImage){
		this.questionImage=questionImage;
	}
	public Integer getQuestionKeyId(){
		return this.questionKeyId;
	}
	public void setQuestionKeyId(Integer questionKeyId){
		this.questionKeyId=questionKeyId;
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
	public Integer getQuestionDelete(){
		return this.questionDelete;
	}
	public void setQuestionDelete(Integer questionDelete){
		this.questionDelete=questionDelete;
	}
}