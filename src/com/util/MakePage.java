package com.util;

public class MakePage {
	private int curPage;
	private int totalCount;
	private int perPage;
	private int perBlock;
	
	//생성자
	public MakePage(int curPage, int totalCount) {
		this.curPage=curPage;
		this.totalCount=totalCount;
		perPage=10;
		perBlock=5;
	}
	//row
	public MakeRow getMakeRow(MakeRow makeRow) {
		makeRow.setStartRow((curPage-1)*perPage+1);
		makeRow.setLastRow(curPage*perPage);
		return makeRow;
	}
	
	public HMakeRow getMakeRow(HMakeRow hmakeRow) {
		hmakeRow.setStartRow((curPage-1)*perPage+1);
		hmakeRow.setLastRow(curPage*perPage);
		return hmakeRow;
	}
	
	
	//페이징
	public Pageing pageing() {
		Pageing pageing = new Pageing();
		//페이징 처리
		//1. totalCount
		//2. totalPage
		int totalPage=0;
		if(totalCount%perPage==0) {
			totalPage=totalCount/perPage;
		}else {
			totalPage=totalCount/perPage+1;
		}
		//3. totalBlock
		if(totalPage%perBlock==0) {
			pageing.setTotalBlock(totalPage/perBlock);
		}else {
			pageing.setTotalBlock(totalPage/perBlock+1);
		}
		//4. curBlock
		if(curPage%perBlock==0) {
			pageing.setCurBlock(curPage/perBlock);
		}else {
			pageing.setCurBlock(curPage/perBlock+1);
		}
		//5. start, last
		pageing.setStartNum((pageing.getCurBlock()-1)*perBlock+1);
		pageing.setLastNum(pageing.getCurBlock()*perBlock);
		
		if(pageing.getCurBlock()==pageing.getTotalBlock()||totalCount==0) {
			pageing.setLastNum(totalPage);
		}
		
		return pageing;
		
	}
	
	
	
	
	
	
	

}
