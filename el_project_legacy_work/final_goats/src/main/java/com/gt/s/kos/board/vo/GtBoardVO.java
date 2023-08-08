package com.gt.s.kos.board.vo;

public class GtBoardVO {
	public GtBoardVO() {
		// TODO Auto-generated constructor stub
	}
	public GtBoardVO(int gbnum, String gbsubject, String gename, String gbmemo, int gbcnt, String gbfile,
			String deleteyn, String insertdate, String updatedate, String insertrdate, String deleterdate) {
		this.gbnum = gbnum;
		this.gbsubject = gbsubject;
		this.gename = gename;
		this.gbmemo = gbmemo;
		this.gbcnt = gbcnt;
		this.gbfile = gbfile;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.insertrdate = insertrdate;
		this.deleterdate = deleterdate;
	}
	private int gbnum;
	private String gbsubject;
	private String gename;
	private String gbmemo;
	private int gbcnt;
	private String gbfile;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	private String insertrdate;
	private String deleterdate;
	public int getGbnum() {
		return gbnum;
	}
	public String getGbsubject() {
		return gbsubject;
	}
	public String getGename() {
		return gename;
	}
	public String getGbmemo() {
		return gbmemo;
	}
	public int getGbcnt() {
		return gbcnt;
	}
	public String getGbfile() {
		return gbfile;
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
	public String getInsertrdate() {
		return insertrdate;
	}
	public String getDeleterdate() {
		return deleterdate;
	}
	public void setGbnum(int gbnum) {
		this.gbnum = gbnum;
	}
	public void setGbsubject(String gbsubject) {
		this.gbsubject = gbsubject;
	}
	public void setGename(String gename) {
		this.gename = gename;
	}
	public void setGbmemo(String gbmemo) {
		this.gbmemo = gbmemo;
	}
	public void setGbcnt(int gbcnt) {
		this.gbcnt = gbcnt;
	}
	public void setGbfile(String gbfile) {
		this.gbfile = gbfile;
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
	public void setInsertrdate(String insertrdate) {
		this.insertrdate = insertrdate;
	}
	public void setDeleterdate(String deleterdate) {
		this.deleterdate = deleterdate;
	}
}
