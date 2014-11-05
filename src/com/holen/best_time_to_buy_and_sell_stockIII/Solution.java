package com.holen.best_time_to_buy_and_sell_stockIII;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * You may not engage in multiple transactions at the same time.
 * (ie, you must sell the stock before you buy again).
 * @author Holen
 * date: 2014-11-05
 */
public class Solution {
	/**
	 * Dynamic Programming
	 * f[n] = max(f[1...i] + f[i...n]) ,i from 1 to n
	 * The first loop is to calculate the max profit of f[1..i] every i, and keep the answer in the profits[].
	 * The second loop is to calculate the max profit of f[i...n] and it is no need to keep answer in an array
	 * because we can get the maxProfit by compare f[1...i]+f[i...n].
	 * @param prices
	 * @return maxProfit
	 */
	public int maxProfit(int[] prices){
		//when the array length smaller than 1 , return
		if(prices.length < 1){
			return 0;
		}
		
		int[] profits = new int[prices.length];
		int minPrices = prices[0];
		int maxprofits = 0;
		/*
		 * ��һ�α������飬���ڲ�ͬ��iֵ�����ǵõ��������󣬱���������maxProfits[]�У��±��Ӧ������Ԫ�ص�ֵ��
		 * ������������ÿ��ѭ��������С������Ȼ���õ��������ȥ��С�������õ��������֮ǰ������������Ƚ�
		 * ʵ������һ��������������f[1...i].
		 */
		for(int i=1 ; i<prices.length ; i++){
			int profit = prices[i] - minPrices;
			//������������ǰ�����������Ƚϣ�����ϴ����
			profits[i] = (profits[i-1]>profit?profits[i-1]:profit);
			//���µ�i�����͵ļ۸�
			minPrices = (minPrices<prices[i]?minPrices:prices[i]);
		}
		
		int maxPrices = prices[prices.length-1];
		
		/*
		 *��һ���������������Ϊ�����f[i...n]��ֵ����Ϊi��ֵ���������дӺ���ǰ������
		 *�Ӻ���ǰ������ʱ�������ҵ���С��ֵ����������ʹ������ֵ��ȥ�����ֵ��ÿ�α�������ֵ��
		 *Ȼ��������ֵ������һ��ѭ����Ӧ��i����������Ȼ������������ķ���
		 */
		for(int i=prices.length-2 ; i>=0 ; i--){
			int profit = maxPrices - prices[i];
			maxprofits = (profits[i] + profit)>maxprofits?profits[i] + profit:maxprofits;
			maxPrices = (maxPrices>prices[i]?maxPrices:prices[i]);
		}
		
		return maxprofits;
	}

}
