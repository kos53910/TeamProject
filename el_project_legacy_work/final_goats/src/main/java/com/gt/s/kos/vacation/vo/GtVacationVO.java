package com.gt.s.kos.vacation.vo;

public class GtVacationVO {

	public GtVacationVO(String gvnum, String gvtype, String gvreasons, String gvstartdate, String gvenddate,
			String gvsubject, String gvmemo, String gvdays, String gvfile, String insertdate, String updatedate,
			String deleteyn, String genum, String writer, String gehp, String reference, String approver, String dept,
			String proval, String count, String decianother, String pageSize, String groupSize, String curPage,
			String totalCount, String sum) {
		super();
		this.gvnum = gvnum;
		this.gvtype = gvtype;
		this.gvreasons = gvreasons;
		this.gvstartdate = gvstartdate;
		this.gvenddate = gvenddate;
		this.gvsubject = gvsubject;
		this.gvmemo = gvmemo;
		this.gvdays = gvdays;
		this.gvfile = gvfile;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.deleteyn = deleteyn;
		this.genum = genum;
		this.writer = writer;
		this.gehp = gehp;
		this.reference = reference;
		this.approver = approver;
		this.dept = dept;
		this.proval = proval;
		this.count = count;
		this.decianother = decianother;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
		this.sum = sum;
	}

	private String gvnum;
	private String gvtype;
	private String gvreasons;
	private String gvstartdate;
	private String gvenddate;
	private String gvsubject;
	private String gvmemo;
	private String gvdays;
	private String gvfile;
	private String insertdate;
	private String updatedate;
	private String deleteyn;
	private String genum;
	private String writer;
	private String gehp;
	private String reference;
	private String approver;
	private String dept;
	private String proval;
	private String count;
	private String decianother;
	
	private String pageSize;
	private String groupSize;
	private String curPage;
	private String totalCount;
	
	private String sum;
	
	public GtVacationVO() {
		// TODO Auto-generated constructor stub
	}

	public GtVacationVO(String gvnum, String gvtype, String gvreasons, String gvstartdate, String gvenddate,
			String gvsubject, String gvmemo, String gvdays, String gvfile, String insertdate, String updatedate,
			String deleteyn, String genum, String writer, String gehp, String reference, String approver, String dept,
			String proval, String count, String decianother) {
	
		this.gvnum = gvnum;
		this.gvtype = gvtype;
		this.gvreasons = gvreasons;
		this.gvstartdate = gvstartdate;
		this.gvenddate = gvenddate;
		this.gvsubject = gvsubject;
		this.gvmemo = gvmemo;
		this.gvdays = gvdays;
		this.gvfile = gvfile;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.deleteyn = deleteyn;
		this.genum = genum;
		this.writer = writer;
		this.gehp = gehp;
		this.reference = reference;
		this.approver = approver;
		this.dept = dept;
		this.proval = proval;
		this.count = count;
		this.decianother = decianother;
	}

	public GtVacationVO(String gvnum, String gvtype, String gvreasons, String gvstartdate, String gvenddate,
			String gvsubject, String gvmemo, String gvdays, String gvfile, String insertdate, String updatedate,
			String deleteyn, String genum, String writer, String gehp, String reference, String approver, String dept,
			String proval, String count, String decianother, String pageSize, String groupSize, String curPage,
			String totalCount) {
		this.gvnum = gvnum;
		this.gvtype = gvtype;
		this.gvreasons = gvreasons;
		this.gvstartdate = gvstartdate;
		this.gvenddate = gvenddate;
		this.gvsubject = gvsubject;
		this.gvmemo = gvmemo;
		this.gvdays = gvdays;
		this.gvfile = gvfile;
		this.insertdate = insertdate;
		this.updatedate = updatedate;
		this.deleteyn = deleteyn;
		this.genum = genum;
		this.writer = writer;
		this.gehp = gehp;
		this.reference = reference;
		this.approver = approver;
		this.dept = dept;
		this.proval = proval;
		this.count = count;
		this.decianother = decianother;
		this.pageSize = pageSize;
		this.groupSize = groupSize;
		this.curPage = curPage;
		this.totalCount = totalCount;
	}

	public String getGvnum() {
		return gvnum;
	}

	public void setGvnum(String gvnum) {
		this.gvnum = gvnum;
	}

	public String getGvtype() {
		return gvtype;
	}

	public void setGvtype(String gvtype) {
		this.gvtype = gvtype;
	}

	public String getGvreasons() {
		return gvreasons;
	}

	public void setGvreasons(String gvreasons) {
		this.gvreasons = gvreasons;
	}

	public String getGvstartdate() {
		return gvstartdate;
	}

	public void setGvstartdate(String gvstartdate) {
		this.gvstartdate = gvstartdate;
	}

	public String getGvenddate() {
		return gvenddate;
	}

	public void setGvenddate(String gvenddate) {
		this.gvenddate = gvenddate;
	}

	public String getGvsubject() {
		return gvsubject;
	}

	public void setGvsubject(String gvsubject) {
		this.gvsubject = gvsubject;
	}

	public String getGvmemo() {
		return gvmemo;
	}

	public void setGvmemo(String gvmemo) {
		this.gvmemo = gvmemo;
	}

	public String getGvdays() {
		return gvdays;
	}

	public void setGvdays(String gvdays) {
		this.gvdays = gvdays;
	}

	public String getGvfile() {
		return gvfile;
	}

	public void setGvfile(String gvfile) {
		this.gvfile = gvfile;
	}

	public String getInsertdate() {
		return insertdate;
	}

	public void setInsertdate(String insertdate) {
		this.insertdate = insertdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getDeleteyn() {
		return deleteyn;
	}

	public void setDeleteyn(String deleteyn) {
		this.deleteyn = deleteyn;
	}

	public String getGenum() {
		return genum;
	}

	public void setGenum(String genum) {
		this.genum = genum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getGehp() {
		return gehp;
	}

	public void setGehp(String gehp) {
		this.gehp = gehp;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getApprover() {
		return approver;
	}

	public void setApprover(String approver) {
		this.approver = approver;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getProval() {
		return proval;
	}

	public void setProval(String proval) {
		this.proval = proval;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDecianother() {
		return decianother;
	}

	public void setDecianother(String decianother) {
		this.decianother = decianother;
	}

	public String getPageSize() {
		return pageSize;
	}

	public String getGroupSize() {
		return groupSize;
	}

	public String getCurPage() {
		return curPage;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public void setGroupSize(String groupSize) {
		this.groupSize = groupSize;
	}

	public void setCurPage(String curPage) {
		this.curPage = curPage;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	
	
}
