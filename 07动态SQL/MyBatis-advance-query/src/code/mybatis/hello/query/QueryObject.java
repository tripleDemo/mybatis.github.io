package code.mybatis.hello.query;

public class QueryObject {
	private int currentPage = 1;
	private int pageSize = 3;

	//分页查询：limit start,passSize
	public int getStart() {
		return (currentPage - 1) * pageSize;
	}

	//如果字符串为空串，也应该设置为null
	public String empty2null(String str) {
		return hasLength(str) ? str : null;
	}
	public boolean hasLength(String str) {
		return str != null && !"".equals(str.trim());
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
