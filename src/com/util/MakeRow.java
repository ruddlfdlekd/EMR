package com.util;

public class MakeRow {
	private int startRow;
	private int lastRow;
	private String hkind;
	private String kind;
	private String search;
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
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
			this.kind="title";
		}else {
			this.kind = kind;
		}
	}
	
	public String getHkind() {
		return hkind;
	}
	public void setHkind(String hkind) {
		if(hkind==null) {
			this.kind="w_num";
		}
		this.hkind = hkind;
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
