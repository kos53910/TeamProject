package com.gt.s.common;


public class TestValidation {
	
	public static boolean testValidation(String sV) {
		
		
		boolean bool =false;
		
		int nCnt = 0;
		int nCnt_A = 0;
		int nCnt_a = 0;
		int nCnt_x = 0;
		int nCnt_n = 0;
		if(sV != null && sV.length() > 0) {
			
			int sVlen = sV.length();

			if(sVlen <=12) {
				
				for(int i = 0; i<sVlen; i++) {
					
					char cS = sV.charAt(i);
					
					if(0x41 <= cS && cS<=0x5A) {
						nCnt_A++;
					}
					
					if(0x61 <= cS && cS <=0x7A) {
						nCnt_a++;
					}
					if(0x21 <= cS && cS<=0x27) {
						nCnt_x++;
					}
					if(0x30 <= cS && cS <= 0x39) {
						nCnt_n++;
					}
					
					nCnt++;
				}
			}
		
			

			if(nCnt_A > 0 && nCnt_a > 0 && nCnt_x >0 && nCnt_n > 0 && 8<=nCnt && nCnt<=12) {
				
				if(nCnt == nCnt_A + nCnt_a + nCnt_n + nCnt_x) {
					bool = true;
				}
			}
			
		}
		
		return bool;
	}
	
	public static void main(String[] args) {
		String sV = "1";
		
		boolean bool = TestValidation.testValidation(sV);

		
		System.out.println("bool >>>> :" + bool);

		
	}

}
