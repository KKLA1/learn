package cn.org.kkl.domain;

import java.util.List;

public class PageBean<T> {

	private int currPage;// 当前页数
	private int pageSize;// 每页显示数
	private int totalCount;// 总共记录数
	private int totalPages;// 总页数
	private List<T> list;// 需要显示的数据集合

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	@Override
	public String toString() {
		return "PageBean [currPage=" + currPage + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", totalPages=" + totalPages + ", list=" + list + "]";
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
