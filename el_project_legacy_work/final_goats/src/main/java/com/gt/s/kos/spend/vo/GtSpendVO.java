package com.gt.s.kos.spend.vo;

public class GtSpendVO {

	public GtSpendVO(String gsnum, String gssubject, String gpnum, String gsdate, String gsgubun, String gsaccount,
			String gsinfo, String gscount, String gscost, String gsfile, String deleteyn, String insertdate,
			String updatedate, String genum, String writer, String reference, String approver, String dept,
			String proval, String count, String totalcost, String startdate, String enddate) {
		super();
		this.gsnum = gsnum;
		this.gssubject = gssubject;
		this.gpnum = gpnum;
		this.gsdate = gsdate;
		this.gsgubun = gsgubun;
		this.gsaccount = gsaccount;
		this.gsinfo = gsinfo;
		this.gscount = gscount;
		this.gscost = gscost;
		this.gsfile = gsfile;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.genum = genum;
		this.writer = writer;
		this.reference = reference;
		this.approver = approver;
		this.dept = dept;
		this.proval = proval;
		this.count = count;
		this.totalcost = totalcost;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	public GtSpendVO(String gsnum, String gssubject, String gpnum, String gsdate, String gsgubun, String gsaccount,
			String gsinfo, String gscount, String gscost, String gsfile, String deleteyn, String insertdate,
			String updatedate, String genum, String writer, String reference, String approver, String dept,
			String proval, String count, String startdate, String enddate) {
		super();
		this.gsnum = gsnum;
		this.gssubject = gssubject;
		this.gpnum = gpnum;
		this.gsdate = gsdate;
		this.gsgubun = gsgubun;
		this.gsaccount = gsaccount;
		this.gsinfo = gsinfo;
		this.gscount = gscount;
		this.gscost = gscost;
		this.gsfile = gsfile;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.genum = genum;
		this.writer = writer;
		this.reference = reference;
		this.approver = approver;
		this.dept = dept;
		this.proval = proval;
		this.count = count;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	public GtSpendVO() {

	}
	public GtSpendVO(String gsnum, String gssubject, String gpnum, String gsdate, String gsgubun, String gsaccount,
			String gsinfo, String gscount, String gscost, String gsfile, String deleteyn, String insertdate,
			String updatedate, String genum, String writer, String reference, String approver, String dept,
			String proval, String count) {

		this.gsnum = gsnum;
		this.gssubject = gssubject;
		this.gpnum = gpnum;
		this.gsdate = gsdate;
		this.gsgubun = gsgubun;
		this.gsaccount = gsaccount;
		this.gsinfo = gsinfo;
		this.gscount = gscount;
		this.gscost = gscost;
		this.gsfile = gsfile;
		this.deleteyn = deleteyn;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.genum = genum;
		this.writer = writer;
		this.reference = reference;
		this.approver = approver;
		this.dept = dept;
		this.proval = proval;
		this.count = count;
	}
	private String gsnum;
	private String gssubject;
	private String gpnum;
	private String gsdate;
	private String gsgubun;
	private String gsaccount;
	private String gsinfo;
	private String gscount;
	private String gscost;
	private String gsfile;
	private String deleteyn;
	private String insertdate;
	private String updatedate;
	private String genum;
	private String writer;
	private String reference;
	private String approver;
	private String dept;
	private String proval;
	private String count;
	
	private String totalcost;
	
	private String startdate;
	private String enddate;
	
	public String getGsnum() {
		return gsnum;
	}
	public String getGssubject() {
		return gssubject;
	}
	public String getGpnum() {
		return gpnum;
	}
	public String getGsdate() {
		return gsdate;
	}
	public String getGsgubun() {
		return gsgubun;
	}
	public String getGsaccount() {
		return gsaccount;
	}
	public String getGsinfo() {
		return gsinfo;
	}
	public String getGscount() {
		return gscount;
	}
	public String getGscost() {
		return gscost;
	}
	public String getGsfile() {
		return gsfile;
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
	public void setGsnum(String gsnum) {
		this.gsnum = gsnum;
	}
	public void setGssubject(String gssubject) {
		this.gssubject = gssubject;
	}
	public void setGpnum(String gpnum) {
		this.gpnum = gpnum;
	}
	public void setGsdate(String gsdate) {
		this.gsdate = gsdate;
	}
	public void setGsgubun(String gsgubun) {
		this.gsgubun = gsgubun;
	}
	public void setGsaccount(String gsaccount) {
		this.gsaccount = gsaccount;
	}
	public void setGsinfo(String gsinfo) {
		this.gsinfo = gsinfo;
	}
	public void setGscount(String gscount) {
		this.gscount = gscount;
	}
	public void setGscost(String gscost) {
		this.gscost = gscost;
	}
	public void setGsfile(String gsfile) {
		this.gsfile = gsfile;
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
	public String getStartdate() {
		return startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getTotalcost() {
		return totalcost;
	}
	public void setTotalcost(String totalcost) {
		this.totalcost = totalcost;
	}
}
