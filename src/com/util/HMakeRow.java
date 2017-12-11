package com.util;

public class HMakeRow {
	private int startRow;
	private int lastRow;
	private String kind;
	private String search;
	private String tt;
	
	public String getTt() {
		return tt;
	}
	public void setTt(String tt) {
		this.tt = tt;
	}
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
		
		if(kind==null&&tt.equals("ward")) {
			this.kind="w_num";
		}
		else if(kind==null&&tt.equals("h_list")){
			this.kind="p_num";
		}
		else {
			this.kind = kind;
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
