package com.gt.s.common;

import com.gt.s.common.mail.GoogleMailSender;

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
	    if(count < 5) {
		    s = app_[count];
		    if((s.split(" ")[0]).equals("-")) {
		    	s = "OK";
		    	return s;
		    }else{
		        return s.split(" ")[0];
		    }
	    }else {
	    	s = "OK";
	    	return s;
	    }

	}
	
	public static String edsmjeoncheck(String app, int count) {
		
		String s = "";
		
		String[] app_ = app.split("/");
		if(count >= 10) {
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
	
	public static String tablename(String appnum) {
		
		String s = appnum.substring(0, 2).toUpperCase();
		if(s.equals("BU")) {
			return "GOAT_BUSINESSTRIP";
		}
		if(s.equals("VA")) {
			return "GOAT_VACATION";
		}
		if(s.equals("SP")) {
			return "GOAT_SPEND";
		}
		if(s.equals("DR")) {
			return "GOAT_DRAFT";
		}
		if(s.equals("CO")) {
			return "GOAT_CONTRACT";
		}
		if(s.equals("RE")) {
			return "GOAT_RESIGNATION";
		}
		
		
		return "123";
	}
	
	public static String numname(String appnum) {
		
		String s = appnum.substring(0, 2).toUpperCase();
		if(s.equals("BU")) {
			return "GBTNUM";
		}
		if(s.equals("VA")) {
			return "GVNUM";
		}
		if(s.equals("SP")) {
			return "GSNUM";
		}
		if(s.equals("DR")) {
			return "GDRNUM";
		}
		if(s.equals("CO")) {
			return "GCNUM";
		}
		if(s.equals("RE")) {
			return "GRNUM";
		}
		
		
		return "123";
	}
	
	public static String subjectname(String appnum) {
		
		String s = appnum.substring(0, 2).toUpperCase();
		if(s.equals("BU")) {
			return "GBTNAME";
		}
		if(s.equals("VA")) {
			return "GVSUBJECT";
		}
		if(s.equals("SP")) {
			return "GSSUBJECT";
		}
		if(s.equals("DR")) {
			return "GDRSUBJECT";
		}
		if(s.equals("CO")) {
			return "GCSUBJECT";
		}
		if(s.equals("RE")) {
			return "GRSUBJECT";
		}
		
		
		return "123";
	}
	
	public static int jeoncountup(String sessionname, String app, int count) {
		
		String[] app_ = app.split("/");
		for(int i=0; i<app_.length; i++) {
			if((app_[i].split(" ")[0]).equals(sessionname)) {
				System.out.println(i);
				return i;
			}
			
		}
		return 0;
	}
	
	public static void googlemail(String num, String subject, 
									String writer, String date, 
									String email) {
		
		String subject_ = "["+formname(num)+ "] " + subject + " " + date;
		String msg = "<p>안녕하세요. " + writer + " 입니다.</p>" +
						 "<p>확인 하시어 <b>결재</b> 부탁드립니다.</p>";
		
		GoogleMailSender gms = new GoogleMailSender();
		gms.googleMailSender(subject_, email, msg, writer.split(" ")[1]);
	}
	
	public static void nappGoogleEmail( String num, String subject, 
										String date, String email) {
		
		String subject_ = "[반려] "+"["+formname(num)+ "] " + subject + " " + date;
		String msg = "<p>문서번호 " + num + " 작성일 " + date + " 해당 문서가 반려되었습니다.</p>" +
						 "<p>확인 하시어 재기안 부탁드립니다.</p>";
		
		
		GoogleMailSender gms = new GoogleMailSender();
		gms.googleMailSender(subject_, email, msg, "관리자");
		
	}
	
	public static void main(String[] args) {
		
		String jeon = CodeUtil.edsmjeoncheck("이홍대 차장/이승현 이사/이준규 대표이사/-/-/", 0);
		String s = CodeUtil.edsmcheck("이홍대 차장/이승현 이사/이준규 대표이사/-/-/", 0);
		if (jeon.equals("") && (!s.equals("OK")) && 0 >= 0) {
				System.out.println("OK");
		}

	}
}