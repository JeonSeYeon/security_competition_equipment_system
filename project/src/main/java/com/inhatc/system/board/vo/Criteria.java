package com.inhatc.system.board.vo;

import org.springframework.web.util.UriComponentsBuilder;

public class Criteria { //Criteria:�˻�����, �з�����
	//���� �ȸ����� ��. �Ķ���� 2�� �̻� �޵��� �����ϸ� �Ǵµ�, �˻��� ���� ����� �ٰԵǸ� ���� ���޵Ǵ� �Ķ���;��� �������Ƿ� �����ϱ� ����
	
	private Integer page;
	private Integer perPageNum;
	private String manager_belong;
	private String writer;
	
	//�Ӽ� searchType, keyword �߰�
	private String searchType;
	private String keyword;

	public Criteria() {
		this.page = 1; //�⺻ �� 1������
		this.perPageNum = 10; //����Ʈ �� �������� ���� 10���� ���� �ο�
	}

	public void setPage(int page) {

		if (page <= 0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {

		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10;
			return;
		}

		this.perPageNum = perPageNum;
	}
 // set�޼ҵ�� ����ڰ� ���Ƿ� �߸� �Է��� �� �ִ� ���� ���� �ʿ��� �����͸� ��������
	
	public int getPage() {
		return page;
	}

	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}

	public int getPerPageNum() { //�� �������� �������� ����
		return this.perPageNum;
	}
	
	public String makeQuery() {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", this.perPageNum);
				
		if (searchType!=null) {
			uriComponentsBuilder
					.queryParam("searchType", this.searchType)
					.queryParam("keyword", this.keyword);
		}
		return uriComponentsBuilder.build().encode().toString();
	}
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", searchType=" + searchType + ", keyword="
				+ keyword + "]";
	}

	

	public String getManager_belong() {
		return manager_belong;
	}

	public void setManager_belong(String manager_belong) {
		this.manager_belong = manager_belong;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setPerPageNum(Integer perPageNum) {
		this.perPageNum = perPageNum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSearchType() {
		return searchType;
	}	

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	
	
}
