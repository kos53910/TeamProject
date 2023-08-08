package com.gt.s.common;

public class Test {

	public static void main(String[] args) {
		double y = 0.5;
		double z = 0;
		for (int i=0;i < 100;i++) {
			if(i > 0) {
				y = (y - (y/2));
			}
			z = z + y;
			System.out.println(z);
		}
	}
}
