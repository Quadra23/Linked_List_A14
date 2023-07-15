

	class Node {
	    int data;
	    Node next;

	    public Node(int data) {
	        this.data = data;
	        this.next = null;
	    }
	}

	class LinkedList {
	    Node head;

	    public void add(int data) {
	        Node newNode = new Node(data);
	        if (head == null) {
	            head = newNode;
	        } else {
	            Node current = head;
	            while (current.next != null) {
	                current = current.next;
	            }
	            current.next = newNode;
	        }
	    }

	    public void detectAndRemoveLoop() {
	        if (head == null || head.next == null) {
	            return;
	        }

	        Node slow = head;
	        Node fast = head;

	        // Detect the loop using Floyd's cycle detection algorithm
	        while (fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;

	            if (slow == fast) {
	                break;
	            }
	        }

	        // If a loop is detected, find the starting point of the loop
	        if (slow == fast) {
	            slow = head;
	            while (slow.next != fast.next) {
	                slow = slow.next;
	                fast = fast.next;
	            }
	            // Unlink the last node to remove the loop
	            fast.next = null;
	        }
	    }

	    public void printList() {
	        Node current = head;
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }
	}

	public class LinkedList_A14_Q1 {
	    public static void main(String[] args) {
	        LinkedList list = new LinkedList();

	        // Add elements to the linked list
	        list.add(1);
	        list.add(3);
	        list.add(4);

	        // Create a loop by connecting the last node to the node at position X
	        int X = 2;
	        if (X > 0) {
	            Node current = list.head;
	            while (X > 1) {
	                current = current.next;
	                X--;
	            }
	            Node last = list.head;
	            while (last.next != null) {
	                last = last.next;
	            }
	            last.next = current;
	        }

	        // Remove the loop from the linked list
	        list.detectAndRemoveLoop();

	        // Print the updated list
	        list.printList();
	    }
	}

