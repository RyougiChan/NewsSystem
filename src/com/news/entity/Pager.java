package com.news.entity;

/**
 * 分页实体类
 * @author RyougiChan
 */
public class Pager {
	/** 当前页面 */
	private int curPage;
	/** 每页记录数 */
	private int perPageRows;
	/** 记录总数目 */
	private int rowCount;
	/** 总页数 */
	private int totalPage;
	
	public int getTotalPage() {
		return (rowCount + perPageRows - 1) / perPageRows;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getPerPageRows() {
		return perPageRows;
	}
	public void setPerPageRows(int perPageRows) {
		this.perPageRows = perPageRows;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	
}
