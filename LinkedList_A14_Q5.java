

	class ListNode {
	    int val;
	    ListNode next;

	    public ListNode(int val) {
	        this.val = val;
	        this.next = null;
	    }
	}

	class Solution {
	    public ListNode oddEvenList(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }

	        ListNode oddHead = head;
	        ListNode evenHead = head.next;
	        ListNode oddTail = oddHead;
	        ListNode evenTail = evenHead;

	        while (evenTail != null && evenTail.next != null) {
	            oddTail.next = evenTail.next;
	            oddTail = oddTail.next;
	            evenTail.next = oddTail.next;
	            evenTail = evenTail.next;
	        }

	        oddTail.next = evenHead;
	        return oddHead;
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

	public class LinkedList_A14_Q5 {
	    public static void main(String[] args) {
	        Solution solution = new Solution();

	        // Create the linked list
	        ListNode node1 = new ListNode(2);
	        ListNode node2 = new ListNode(1);
	        ListNode node3 = new ListNode(3);
	        ListNode node4 = new ListNode(5);
	        ListNode node5 = new ListNode(6);
	        ListNode node6 = new ListNode(4);
	        ListNode node7 = new ListNode(7);
	        node1.next = node2;
	        node2.next = node3;
	        node3.next = node4;
	        node4.next = node5;
	        node5.next = node6;
	        node6.next = node7;

	        // Reorder the linked list
	        ListNode reorderedList = solution.oddEvenList(node1);

	        // Print the reordered list
	        solution.printList(reorderedList);
	    }
	}
