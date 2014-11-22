package com.holen.remove_nth_node_from_end;

import com.holen.ListNode;

public class Solution {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node = head;
		ListNode pre = head;
		for(int i=0 ; i<n ; i++){
			node = node.next;
		}
		if(node == null){
			pre = pre.next;
			head = null;
			return pre;
		}
		while(node.next != null){
			pre = pre.next;
			node = node.next;
		}
		ListNode cur = pre.next;
		pre.next = cur.next;
		cur = null;
		return head;
	}
}
