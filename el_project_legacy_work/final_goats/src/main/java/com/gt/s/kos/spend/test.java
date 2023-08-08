package com.gt.s.kos.spend;

public class test {
	
	public static void cu(int x, int y) {
		
		int add = x + y;
		int sub = x - y;
		int mul = x * y;
		int div = x / y;
		int div_ = x % y;
		
		System.out.println(add + ":" + sub + ":"  + mul + ":"  + div + ":"  + div_);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 함수를 이용해서 정수 계산기 만들기, 나누기는 몫값과 나머지값 모두 출력 매개변수 2개
		// 함수만 만들면 됩니다
		int i = 2;
		int ii = 3;
		
		test.cu(i, ii);
	}

}
