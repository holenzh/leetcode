package com.holen.climbing_stairs;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author Holen
 * date:2014-11-05
 */
public class Solution {
	/**
	 * Ҫ֪���ж����ַ����������Ǻ����ף����������룬Ҫ��Ƕ�����ô���һ����¥��Ҫô��n-2�ĵط�����������Ҫô��n-1
	 * �ĵط�����һ��̨�ף��Ҳ���Ҫ����n-2��n-1����ô��������ֻ֪������ͨ��������������ģ���f[n] = f[n-1]+f[n-2]��
	 * ����n-1��̨�׵ķ���Ҳ�����֣�һ����ͨ��n-2��һ��������n-3���������������ʵ���Ͼ���쳲��������С�
	 * �ǵݹ鷽��
	 * @param n
	 * @return 
	 */
	public int climbStairs(int n) {
		int sum1 = 1;
		int sum2 = 2;
		if(n == 0){
		return 0;	
		}else if(n == 1){
			return sum1;
		}else if(n == 2){
			return sum2;
		}
		for(int i=2 ; i<n ; i++){
			int temp = sum2;
			sum2 = sum1 + sum2;
			sum1 = temp;
		}
		
		return sum2;
    }
	/**
	 * �ݹ鷽ʽʵ�֣�ʱ�临�Ӷȸߣ�time-limit-exceed
	 * @param n
	 * @return
	 */
	public int climbStairs2(int n){
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}
		
		return climbStairs2(n-1) + climbStairs2(n-2);
	}

}
