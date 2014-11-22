package com.holen.swap_node_in_pairs;

import com.holen.ListNode;

public class Solution {
	public static ListNode swapPairs(ListNode head){
		if(head==null || head.next==null){
			return head;
		}
		
		ListNode currentNode = head;
		ListNode lastNode = null;
		
		while(currentNode!=null && currentNode.next != null){
			ListNode node = currentNode.next;
			if(lastNode == null){
				currentNode.next = node.next;
				node.next = currentNode;
				head = node;
				lastNode = currentNode;
			}else{
				currentNode.next = node.next;
				node.next = currentNode;
				lastNode.next = node;
				lastNode = currentNode;
			}
			currentNode = currentNode.next;
		}
		return head;
	}
}
