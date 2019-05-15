package code.mybatis.hello.query;

import java.util.List;

public class PageResult {
	private List<?> result;//每一页的结果集
	private int totalCount;//结果总数
	
	private int currentPage = 1;//当前页
	private int pageSize = 3;//每页最多多少条数据
	
	private int prevPage;
	private int nextPage;
	private int totalPage;
	
	public PageResult(List<?> result, int totalCount, int currentPage, int pageSize) {
		super();
		this.result = result;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
		this.prevPage = currentPage - 1 >= 1 ? currentPage - 1 : 1;
		this.nextPage = currentPage + 1 <= totalPage ? currentPage + 1 : totalPage;
		currentPage = currentPage > totalPage ? totalPage : currentPage;
	}

	public List<?> getResult() {
		return result;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPrevPage() {
		return prevPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}
	
}
