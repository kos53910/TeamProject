package com.gt.s.kos.schedule.vo;

public class GtScheduleVO {
	
	private String gpnum;
	private String gpsubject;
	private String gppnum;
	private String writer;
	private String gptype;
	private String gpmemo;
	private String gplocation;
	private String gpstart;
	private String gpend;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	
	


	public GtScheduleVO() {
		
		// TODO Auto-generated constructor stub
	}
	
	public GtScheduleVO(String gpnum, String gpsubject, String gppnum, String writer, String gptype, String gpmemo,
			String gplocation, String gpstart, String gpend, String deleteyn, String insertdate, String updatedate) {
		this.gpnum = gpnum;
		this.gpsubject = gpsubject;
		this.gppnum = gppnum;
		this.writer = writer;
		this.gptype = gptype;
		this.gpmemo = gpmemo;
		this.gplocation = gplocation;
		this.gpstart = gpstart;
		this.gpend = gpend;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
	}
	
	
	public String getGpnum() {
		return gpnum;
	}
	public String getGpsubject() {
		return gpsubject;
	}
	public String getGppnum() {
		return gppnum;
	}
	public String getWriter() {
		return writer;
	}
	public String getGptype() {
		return gptype;
	}
	public String getGpmemo() {
		return gpmemo;
	}
	public String getGplocation() {
		return gplocation;
	}
	public String getGpstart() {
		return gpstart;
	}
	public String getGpend() {
		return gpend;
	}
	public String getDeleteyn() {
		return deleteyn;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public void setGpnum(String gpnum) {
		this.gpnum = gpnum;
	}
	public void setGpsubject(String gpsubject) {
		this.gpsubject = gpsubject;
	}
	public void setGppnum(String gppnum) {
		this.gppnum = gppnum;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setGptype(String gptype) {
		this.gptype = gptype;
	}
	public void setGpmemo(String gpmemo) {
		this.gpmemo = gpmemo;
	}
	public void setGplocation(String gplocation) {
		this.gplocation = gplocation;
	}
	public void setGpstart(String gpstart) {
		this.gpstart = gpstart;
	}
	public void setGpend(String gpend) {
		this.gpend = gpend;
	}
	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	
	

	
} // end of class
