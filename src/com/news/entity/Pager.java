package com.news.entity;

/**
 * 分页实体类
 * @author RyougiChan
 */
public class Pager {
	/** 待显示页面 */
	private int curPage;
	/** 每页记录数 */
	private int perPageRows;
	/** 记录总数目 */
	private int rowCount;
	/** 总页数 */
	private int pageCount;
	
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
	public int getPageCount() {
		return (rowCount + perPageRows - 1) / perPageRows;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
}
