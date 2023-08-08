package com.gt.s.common;

public abstract class CodeUtil {
	
	private static final String[] TITLE = {"사원", "대리", "과장", "차장", "이사", "대표이사"};
	private static final String[] TITLE_NUM = {"1", "2", "3", "4", "5", "6"};
	public static final String[] gender_value = {"여자","남자"};
	public static final String[] hp_value = {"010", "011", "016", "017"};
	
	public static String title_gubun(String s) {
		
		for(int i=0; i<TITLE.length; i++) {
			if(s == TITLE[i]) {
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
	
	public static void main(String[] args) {
		
		String s = title_gubun("과장");
		System.out.println(s);
	}
}