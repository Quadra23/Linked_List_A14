

	class ListNode {
	    int val;
	    ListNode next;

	    public ListNode(int val) {
	        this.val = val;
	        this.next = null;
	    }
	}

	class Solution {
	    public int[] nextGreaterNodes(ListNode head) {
	        // Step 1: Count the number of nodes in the list
	        int count = 0;
	        ListNode current = head;
	        while (current != null) {
	            count++;
	            current = current.next;
	        }

	        // Step 2: Create an array to store the result
	        int[] result = new int[count];

	        // Step 3: Use a stack to keep track of indices of nodes with decreasing values
	        int index = 0;
	        current = head;
	        Stack<Integer> stack = new Stack<>();
	        while (current != null) {
	            while (!stack.isEmpty() && current.val > result[stack.peek()]) {
	                result[stack.pop()] = current.val;
	            }
	            stack.push(index);
	            current = current.next;
	            index++;
	        }

	        // Step 4: Remaining indices in the stack have no greater nodes
	        while (!stack.isEmpty()) {
	            result[stack.pop()] = 0;
	        }

	        return result;
	    }
	}

	public class LinkedList_A14_Q7 {
	    public static void main(String[] args) {
	        Solution solution = new Solution();

	        // Create the linked list
	        ListNode node1 = new ListNode(2);
	        ListNode node2 = new ListNode(7);
	        ListNode node3 = new ListNode(4);
	        ListNode node4 = new ListNode(3);
	        ListNode node5 = new ListNode(5);
	        node1.next = node2;
	        node2.next = node3;
	        node3.next = node4;
	        node4.next = node5;

	        // Find the next greater nodes
	        int[] nextGreaterNodes = solution.nextGreaterNodes(node1);

	        // Print the result
	        for (int value : nextGreaterNodes) {
	            System.out.print(value + " ");
	        }
	        System.out.println();
	    }
	}
