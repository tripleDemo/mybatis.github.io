package code.mybatis.hello.query;

import java.util.List;

public class PageResult {
	private List<?> result;//ÿһҳ�Ľ����
	private int totalCount;//�������
	
	private int currentPage = 1;//��ǰҳ
	private int pageSize = 3;//ÿҳ������������
	
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
