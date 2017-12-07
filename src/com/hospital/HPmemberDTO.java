package com.hospital;

import java.sql.Date;

public class HPmemberDTO {
private int w_num;
private int w_rnum;
private int w_rmax;
private int p_num;
private String p_name;
private int s_num;
private String s_name;
private String p_sung;
private Date p_date;
private Date p_sdate;

public Date getP_sdate() {
	return p_sdate;
}
public void setP_sdate(Date p_sdate) {
	this.p_sdate = p_sdate;
}
public Date getP_date() {
	return p_date;
}
public void setP_date(Date p_date) {
	this.p_date = p_date;
}
public int getW_num() {
	return w_num;
}
public void setW_num(int w_num) {
	this.w_num = w_num;
}
public int getW_rnum() {
	return w_rnum;
}
public void setW_rnum(int w_rnum) {
	this.w_rnum = w_rnum;
}
public int getW_rmax() {
	return w_rmax;
}
public void setW_rmax(int w_rmax) {
	this.w_rmax = w_rmax;
}
public int getP_num() {
	return p_num;
}
public void setP_num(int p_num) {
	this.p_num = p_num;
}
public String getP_name() {
	return p_name;
}
public void setP_name(String p_name) {
	this.p_name = p_name;
}
public int getS_num() {
	return s_num;
}
public void setS_num(int s_num) {
	this.s_num = s_num;
}
public String getS_name() {
	return s_name;
}
public void setS_name(String s_name) {
	this.s_name = s_name;
}
public String getP_sung() {
	return p_sung;
}
public void setP_sung(String p_sung) {
	this.p_sung = p_sung;
}
}
