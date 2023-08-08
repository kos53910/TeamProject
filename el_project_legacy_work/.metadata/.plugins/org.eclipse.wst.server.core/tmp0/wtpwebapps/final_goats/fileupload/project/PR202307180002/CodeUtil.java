package com.gt.s.common;

public abstract class CodeUtil {
	
	private static final String[] TITLE = {"사원", "대리", "과장", "차장", "이사", "대표이사"};
	private static final String[] TITLE_NUM = {"1", "2", "3", "4", "5", "6"};
	public static final String[] gender_value = {"여자","남자"};
	public static final String[] hp_value = {"010", "011", "016", "017"};
	
	public static String title_gubun(String s) {
		
		for(int i=0; i<TITLE.length; i++) {
			if(s.equals(TITLE[i])) {
				return TITLE_NUM[i];
			}
		}
		return "null";
	}
	
	public static String gender(String s) {
		return "F".equals(s.toUpperCase()) ? "여자" : "남자";
	}
	
	public static String hp(String s) {

		String s0 = "";
		String s1 = "";
		String s2 = "";
		String ss = "";
		
		if (s !=null && s.length() > 0){			
			int sLen = s.length();			
			if (11 == sLen) {
				s0 = s.substring(0, 3);
				s1 = s.substring(3, 7);
				s2 = s.substring(7);
				ss = s0 + "-" + s1 + "-" + s2;
			}
		}		
		return ss;
	}
	
	public static String edsmcheck(String app, int count) {
	    String s = "";
	    String[] app_ = app.split("/");	    
	    if (app_.length <= count) {
	        s = "OK";
	        return s;
	    } else {
	        s = app_[count];
	        return s.split(" ")[0];
	    }
	}
	
	public static String edsmjeoncheck(String app, int count) {
		
		String s = "";
		
		String[] app_ = app.split("/");
		if(count > 10) {
			count = count - 10;
			s = app_[count];
		}
		return s.split(" ")[0];
	}
	
	public static String formname(String s) {
		
		String formname = s.substring(0, 2).toUpperCase();
		if(formname.equals("BU")) {
			return "출장 계획서";
		}
		if(formname.equals("VA")) {
			return "휴가 신청서";
		}
		if(formname.equals("SP")) {
			return "지출 내역서";
		}
		if(formname.equals("DR")) {
			return "기안서(일반)";
		}
		if(formname.equals("CO")) {
			return "기안서(계약)";
		}
		if(formname.equals("RE")) {
			return "사직서";
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		formname("va20230717");

	}
}