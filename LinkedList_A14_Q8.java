

	class ListNode {
	    int val;
	    ListNode next;

	    public ListNode(int val) {
	        this.val = val;
	        this.next = null;
	    }
	}

	class Solution {
	    public ListNode removeZeroSumSublists(ListNode head) {
	        // Step 1: Create a dummy node and set its next pointer to the head
	        ListNode dummy = new ListNode(0);
	        dummy.next = head;

	        // Step 2: Create a prefix sum map to keep track of the prefix sum and its corresponding node
	        Map<Integer, ListNode> map = new HashMap<>();
	        int prefixSum = 0;
	        ListNode current = dummy;

	        while (current != null) {
	            prefixSum += current.val;

	            if (map.containsKey(prefixSum)) {
	                // Remove nodes between the previous prefix sum and the current node
	                ListNode prev = map.get(prefixSum).next;
	                int sum = prefixSum + prev.val;
	                while (prev != current) {
	                    map.remove(sum);
	                    prev = prev.next;
	                    sum += prev.val;
	                }
	                map.get(prefixSum).next = current.next;
	            } else {
	                map.put(prefixSum, current);
	            }

	            current = current.next;
	        }

	        return dummy.next;
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

	public class LinkedList_A14_Q8 {
	    public static void main(String[] args) {
	        Solution solution = new Solution();

	        // Create the linked list
	        ListNode node1 = new ListNode(1);
	        ListNode node2 = new ListNode(2);
	        ListNode node3 = new ListNode(3);
	        ListNode node4 = new ListNode(-3);
	        ListNode node5 = new ListNode(-2);
	        node1.next = node2;
	        node2.next = node3;
	        node3.next = node4;
	        node4.next = node5;

	        // Remove consecutive sequences of nodes that sum to 0
	        ListNode result = solution.removeZeroSumSublists(node1);

	        // Print the resulting list
	        solution.printList(result);
	    }
	}

