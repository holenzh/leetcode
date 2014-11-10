package com.holen.add_two_numbers;

import com.holen.ListNode;

public class Solution {
	public static ListNode addTwoNumbers(ListNode head1 , ListNode head2){
		//ListNode newNode = head1.next;
		ListNode newNode = new ListNode(0);
		ListNode node = newNode;
		ListNode previous = newNode;
		while(head1!=null && head2!=null){
			newNode.val += head1.val + head2.val;
			newNode.next = new ListNode(newNode.val/10);
			newNode.val = newNode.val % 10;
			previous = newNode;
			newNode = newNode.next;
			head1 = head1.next;
			head2 = head2.next;
		}
		
		ListNode current = null;
		if(head1 == null){
			current = head2;
		}else{
			current = head1;
		}
		while(current != null){
			newNode.val += current.val;
			newNode.next = new ListNode(newNode.val/10);
			newNode.val = newNode.val%10;
			previous = newNode;
			newNode = newNode.next;
			current = current.next;
		}
		
		if(previous.next!=null && previous.next.val==0){
			previous.next = null;
		}
		
		return node;
	}

}
