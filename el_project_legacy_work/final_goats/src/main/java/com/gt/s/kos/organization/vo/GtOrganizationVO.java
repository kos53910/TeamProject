package com.gt.s.kos.organization.vo;

public class GtOrganizationVO {


	private String genum;
	private String gename;
	private String gedept;
	private String title;
	private String geid;
	private String geemail;
	private String gehp;

	public GtOrganizationVO() {
		// TODO Auto-generated constructor stub
	}
	
	public GtOrganizationVO(String genum, String gename, String gedept, String title, String geid, String geemail,
			String gehp) {
		
		this.genum = genum;
		this.gename = gename;
		this.gedept = gedept;
		this.title = title;
		this.geid = geid;
		this.geemail = geemail;
		this.gehp = gehp;
	}

	public String getGenum() {
		return genum;
	}

	public String getGename() {
		return gename;
	}

	public String getGedept() {
		return gedept;
	}

	public String getTitle() {
		return title;
	}

	public String getGeid() {
		return geid;
	}

	public String getGeemail() {
		return geemail;
	}

	public String getGehp() {
		return gehp;
	}

	public void setGenum(String genum) {
		this.genum = genum;
	}

	public void setGename(String gename) {
		this.gename = gename;
	}

	public void setGedept(String gedept) {
		this.gedept = gedept;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGeid(String geid) {
		this.geid = geid;
	}

	public void setGeemail(String geemail) {
		this.geemail = geemail;
	}

	public void setGehp(String gehp) {
		this.gehp = gehp;
	}
	
	
}