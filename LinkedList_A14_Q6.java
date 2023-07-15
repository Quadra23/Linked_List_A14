

	class ListNode {
	    int val;
	    ListNode next;

	    public ListNode(int val) {
	        this.val = val;
	        this.next = null;
	    }
	}

	class Solution {
	    public ListNode leftShiftLinkedList(ListNode head, int k) {
	        if (head == null || k <= 0) {
	            return head;
	        }

	        int count = 1;
	        ListNode current = head;
	        while (count < k && current != null) {
	            current = current.next;
	            count++;
	        }

	        if (current == null) {
	            return head;
	        }

	        ListNode kthNode = current;
	        while (current.next != null) {
	            current = current.next;
	        }

	        current.next = head;
	        head = kthNode.next;
	        kthNode.next = null;

	        return head;
	    }

	    public void printList(ListNode head) {
	        ListNode current = head;
	        while (current != null) {
	            System.out.print(current.val + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }
	}

	public class LinkedList_A14_Q6 {
	    public static void main(String[] args) {
	        Solution solution = new Solution();

	        // Create the linked list
	        ListNode node1 = new ListNode(1);
	        ListNode node2 = new ListNode(2);
	        ListNode node3 = new ListNode(3);
	        ListNode node4 = new ListNode(4);
	        ListNode node5 = new ListNode(5);
	        ListNode node6 = new ListNode(6);
	        ListNode node7 = new ListNode(7);
	        ListNode node8 = new ListNode(8);
	        node1.next = node2;
	        node2.next = node3;
	        node3.next = node4;
	        node4.next = node5;
	        node5.next = node6;
	        node6.next = node7;
	        node7.next = node8;

	        // Left-shift the linked list
	        int k = 4;
	        ListNode shiftedList = solution.leftShiftLinkedList(node1, k);

	        // Print the shifted list
	        solution.printList(shiftedList);
	    }
	}

