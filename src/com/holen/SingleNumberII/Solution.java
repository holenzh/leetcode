package com.holen.SingleNumberII;

public class Solution {
	public static int singleNumber(int[] A){
		int one=0 , two=0 , three=0;
		for(int i=0 ; i<A.length ; i++){
			two |= one&A[i];
			one^=A[i];
			three = one & two;
			one &= ~three;
			two &= ~three;
		}
		return one;
	}

}
