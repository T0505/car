package com.school.motor.system.entities;

import java.sql.Timestamp;
import com.school.motor.system.annotation.Table;
@Table("问题答案表")
public class QuestionKey extends BaseEntity{
	private long serialVersionUID=1702804601418L;
	private String questionKeyQuestion;
	private String questionKeyCorrect;
	private String questionKeyAnalysis;
	private byte[] questionKeyVideo;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer questionKeyDel;
	public Integer getId(){
		return this.id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public String getQuestionKeyQuestion(){
		return this.questionKeyQuestion;
	}
	public void setQuestionKeyQuestion(String questionKeyQuestion){
		this.questionKeyQuestion=questionKeyQuestion;
	}
	public String getQuestionKeyCorrect(){
		return this.questionKeyCorrect;
	}
	public void setQuestionKeyCorrect(String questionKeyCorrect){
		this.questionKeyCorrect=questionKeyCorrect;
	}
	public String getQuestionKeyAnalysis(){
		return this.questionKeyAnalysis;
	}
	public void setQuestionKeyAnalysis(String questionKeyAnalysis){
		this.questionKeyAnalysis=questionKeyAnalysis;
	}
	public byte[] getQuestionKeyVideo(){
		return this.questionKeyVideo;
	}
	public void setQuestionKeyVideo(byte[] questionKeyVideo){
		this.questionKeyVideo=questionKeyVideo;
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
	public Integer getQuestionKeyDel(){
		return this.questionKeyDel;
	}
	public void setQuestionKeyDel(Integer questionKeyDel){
		this.questionKeyDel=questionKeyDel;
	}
}