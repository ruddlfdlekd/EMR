package com.util;

public class MdbMakeRow {
private int StartRow;
private int lastRow;
private String kind;
private String search;
public int getStartRow() {
	return StartRow;
}
public void setStartRow(int startRow) {
	StartRow = startRow;
}
public int getLastRow() {
	return lastRow;
}
public void setLastRow(int lastRow) {
	this.lastRow = lastRow;
}
public String getKind() {
	return kind;
}
public void setKind(String kind) {
	if(kind==null) {
	this.kind = "m_num";
}else {
	this.kind= kind;
}
}
public String getSearch() {
	return search;
}
public void setSearch(String search) {
	if(search==null) {
		this.search="";
	}else {
	this.search = search;
}
}
}
