package com.kh.spring.notice.model.vo;

import java.sql.Date;

public class Notice {
	private String nId;
	private String nTitle;
	private String nWriter;
	private String nContent;
	private Date nCreateDate;
	private Date nModifyDate;
	private String filePath;
	
	public Notice() {}

	public Notice(String nId, String nTitle, String nWriter, String nContent, Date nCreateDate, Date nModifyDate,
			String filePath) {
		super();
		this.nId = nId;
		this.nTitle = nTitle;
		this.nWriter = nWriter;
		this.nContent = nContent;
		this.nCreateDate = nCreateDate;
		this.nModifyDate = nModifyDate;
		this.filePath = filePath;
	}

	public String getnId() {
		return nId;
	}

	public void setnId(String nId) {
		this.nId = nId;
	}

	public String getnTitle() {
		return nTitle;
	}

	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}

	public String getnWriter() {
		return nWriter;
	}

	public void setnWriter(String nWriter) {
		this.nWriter = nWriter;
	}

	public String getnContent() {
		return nContent;
	}

	public void setnContent(String nContent) {
		this.nContent = nContent;
	}

	public Date getnCreateDate() {
		return nCreateDate;
	}

	public void setnCreateDate(Date nCreateDate) {
		this.nCreateDate = nCreateDate;
	}

	public Date getnModifyDate() {
		return nModifyDate;
	}

	public void setnModifyDate(Date nModifyDate) {
		this.nModifyDate = nModifyDate;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return "Notice [nId=" + nId + ", nTitle=" + nTitle + ", nWriter=" + nWriter + ", nContent=" + nContent
				+ ", nCreateDate=" + nCreateDate + ", nModifyDate=" + nModifyDate + ", filePath=" + filePath + "]";
	}
}
