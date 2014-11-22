package com.holen;

import com.holen.remove_nth_node_from_end.Solution;






/**
 * 测试程序，提供一些测试用例，验证其他包中的题目解法是否正确
 * date: 2014-11-04
 * @author Holen
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int[] prices = {4,5,6,7,8,2,9};
		System.out.println(new Solution().climbStairs(44));*/
		
		/*String str = "123";
		System.out.println(Solution.numDecodings("17"));*/
		
		/*ListNode node1_1 = new ListNode(1);
		ListNode node2_1 = new ListNode(0);
		ListNode node1_2 = new ListNode(8, node1_1);
		ListNode node1_3 = new ListNode(2, node1_2);
		ListNode node2_2 = new ListNode(6, node2_1);
		ListNode node2_3 = new ListNode(5, node2_2);
		
		ListNode newNode = Solution.addTwoNumbers(node1_2, node2_1);
		while(newNode != null){
			System.out.println(newNode.val);
			newNode = newNode.next;
		}*/
		
		/*int[] array = {1,2,3,1,2,3,3};
		System.out.println(Solution.singleNumber(array));*/
		
		/*String S = "dagccat";
		String T = "catyyyyyyy";
		System.out.println(Solution.numDistinct(S, T));*/
		
		/*String word1 = "zoologicoarchaeologist";
		String word2 = "zoogeologist";
		
		System.out.println(Solution.minDistance(word1, word2));*/
		
		/*ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(5 , node1);
		ListNode node3 = new ListNode(2 , node2);
		ListNode node4 = new ListNode(3 , node3);
		ListNode node5 = new ListNode(4 , node4);
		ListNode node6 = new ListNode(1 , node5);
		ListNode head = Solution.partition(node6, 6);
		while(head!=null){
			System.out.print(head.val + "  ");
			head = head.next;
		}*/
		
		/*String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		//String s3 = "aadbbbaccc";
		
		System.out.println(Solution.isInterleaving(s1, s2, s3));*/
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2 , node1);
		ListNode node3 = new ListNode(3 , node2);
		ListNode node4 = new ListNode(4 , node3);
		
		ListNode head = Solution.removeNthFromEnd(node3, 3);
		while(head!=null){
			System.out.print(head.val + "  ");
			head = head.next;
		}
		
	}

}
