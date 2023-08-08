package com.gt.s.kos.resignation.vo;

public class GtResignationVO {

	private String grnum;
	private String grstartdate;
	private String grenddate;
	private String grsubject;
	private String grmemo;
	private String grfile;
	private String insertdate;
	private String updatedate;
	private String deleteyn;
	private String genum;
	private String writer;
	private String reference;
	private String approver;
	private String dept;
	private String proval;
	private String count;
	
	
	

	public GtResignationVO() {
	}
	
	
	
	public GtResignationVO(String grnum, String grstartdate, String grenddate, String grsubject, String grmemo,
			String grfile, String insertdate, String updatedate, String deleteyn, String genum, String writer,
			String reference, String approver, String dept, String proval, String count) {
		this.grnum = grnum;
		this.grstartdate = grstartdate;
		this.grenddate = grenddate;
		this.grsubject = grsubject;
		this.grmemo = grmemo;
		this.grfile = grfile;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.deleteyn = deleteyn;
		this.genum = genum;
		this.writer = writer;
		this.reference = reference;
		this.approver = approver;
		this.dept = dept;
		this.proval = proval;
		this.count = count;
	}
	
	
	public String getGrnum() {
		return grnum;
	}
	public String getGrstartdate() {
		return grstartdate;
	}
	public String getGrenddate() {
		return grenddate;
	}
	public String getGrsubject() {
		return grsubject;
	}
	public String getGrmemo() {
		return grmemo;
	}
	public String getGrfile() {
		return grfile;
	}
	public String getInsertdate() {
		return insertdate;
	}
	public String getUpdatedate() {
		return updatedate;
	}
	public String getDeleteyn() {
		return deleteyn;
	}
	public String getGenum() {
		return genum;
	}
	public String getWriter() {
		return writer;
	}
	public String getReference() {
		return reference;
	}
	public String getApprover() {
		return approver;
	}
	public String getDept() {
		return dept;
	}
	public String getProval() {
		return proval;
	}
	public String getCount() {
		return count;
	}
	public void setGrnum(String grnum) {
		this.grnum = grnum;
	}
	public void setGrstartdate(String grstartdate) {
		this.grstartdate = grstartdate;
	}
	public void setGrenddate(String grenddate) {
		this.grenddate = grenddate;
	}
	public void setGrsubject(String grsubject) {
		this.grsubject = grsubject;
	}
	public void setGrmemo(String grmemo) {
		this.grmemo = grmemo;
	}
	public void setGrfile(String grfile) {
		this.grfile = grfile;
	}
	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}
	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}
	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}
	public void setGenum(String genum) {
		this.genum = genum;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setApprover(String approver) {
		this.approver = approver;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setProval(String proval) {
		this.proval = proval;
	}
	public void setCount(String count) {
		this.count = count;
	}
	

}