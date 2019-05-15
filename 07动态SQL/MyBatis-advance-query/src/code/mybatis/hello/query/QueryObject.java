package code.mybatis.hello.query;

public class QueryObject {
	private int currentPage = 1;
	private int pageSize = 3;

	//��ҳ��ѯ��limit start,passSize
	public int getStart() {
		return (currentPage - 1) * pageSize;
	}

	//����ַ���Ϊ�մ���ҲӦ������Ϊnull
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
