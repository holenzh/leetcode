package com.holen.decode_ways;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1  'B' -> 2 ... 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * @author Holen
 * date: 2014-11-08
 */
public class Solution {
	/**
	 * 这是一道典型的DP题，从后往前看，我们发现f(n)=af(n-1)+bf(n-2).
	 * 当最后一个数字为0时,a=0；不为0时,a=1
	 * 当前一个数字为0时,b=0；当前后两个数组组成的数小于26时，b=1。
	 * @param s
	 * @return
	 */
	public static int numDecodings(String s){
		int length = s.length();
		if(length == 0){
			return 0;
		}
		int[] count = new int[length+1];
		if(s.charAt(0) != '0'){
			count[0] = 1;
			count[1] = 1;
		}
		for(int i=2 ; i<=length ; i++){
			if(s.charAt(i-1) != '0'){
				count[i] += count[i-1];
			}
			
			if(s.charAt(i-2) != '0'){
				if(((s.charAt(i-2)-'0')*10 + s.charAt(i-1)-'0')<=26){
					count[i] += count[i-2];
				}
			}
		}
		return count[length];
	}
}
