package com.member;

import java.sql.Date;

public class SmemberDTO {
	private int s_num;
	private String s_pw;
	private String s_name;
	private int s_age;
	private Date s_birth;
	private String s_email;
	private String s_phone;
	private int s_job;
	
	public int getS_num() {
		return s_num;
	}
	public void setS_num(int s_num) {
		this.s_num = s_num;
	}
	public String getS_pw() {
		return s_pw;
	}
	public void setS_pw(String s_pw) {
		this.s_pw = s_pw;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_age() {
		return s_age;
	}
	public void setS_age(int s_age) {
		this.s_age = s_age;
	}
	public Date getS_birth() {
		return s_birth;
	}
	public void setS_birth(Date s_birth) {
		this.s_birth = s_birth;
	}
	public String getS_email() {
		return s_email;
	}
	public void setS_email(String s_email) {
		this.s_email = s_email;
	}
	public String getS_phone() {
		return s_phone;
	}
	public void setS_phone(String s_phone) {
		this.s_phone = s_phone;
	}
	public int getS_job() {
		return s_job;
	}
	public void setS_job(int s_job) {
		this.s_job = s_job;
	}
	
}
