package com.inhatc.system.board.vo;


public class BoardVO {

	private Integer bno; //�۹�ȣ
	private String manager_classification; //�۾��з�
	private String manager_belong; //�Ҽ� (IT�Ⱑ��, PC������)
	private String client_number; //��ȭ��ȣ
	private String client_belong; //�Ƿ��� �Ҽ�
	private String client_local; //��ġ
	private String client_name; //�̸�
	private String instrument; //���������(������, ���� ...)
	private String content; //����
	private String progress; //ó����Ȳ(���, ó����, ó���Ϸ�)
	private String completeId;
	private String completeDate;
	private String regdate; //��¥-�ð�
	private String writer;
	private String show;
	
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getManager_classification() {
		return manager_classification;
	}
	public void setManager_classification(String manager_classification) {
		this.manager_classification = manager_classification;
	}
	public String getManager_belong() {
		return manager_belong;
	}
	public void setManager_belong(String manager_belong) {
		this.manager_belong = manager_belong;
	}
	public String getClient_number() {
		return client_number;
	}
	public void setClient_number(String client_number) {
		this.client_number = client_number;
	}
	public String getClient_belong() {
		return client_belong;
	}
	public void setClient_belong(String client_belong) {
		this.client_belong = client_belong;
	}
	public String getClient_local() {
		return client_local;
	}
	public void setClient_local(String client_local) {
		this.client_local = client_local;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getProgress() {
		return progress;
	}
	public void setProgress(String progress) {
		this.progress = progress;
	}
	public String getCompleteId() {
		return completeId;
	}
	public void setCompleteId(String completeId) {
		this.completeId = completeId;
	}
	public String getCompleteDate() {
		return completeDate;
	}
	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	
	
}
