

	class Node {
	    int data;
	    Node next;
	    Node random;

	    public Node(int data) {
	        this.data = data;
	        this.next = null;
	        this.random = null;
	    }
	}

	class LinkedList {
	    Node head;

	    public Node copyRandomList(Node head) {
	        if (head == null) {
	            return null;
	        }

	        // Step 1: Create a new copy of each node and insert it after the original node
	        Node current = head;
	        while (current != null) {
	            Node newNode = new Node(current.data);
	            newNode.next = current.next;
	            current.next = newNode;
	            current = newNode.next;
	        }

	        // Step 2: Set the random pointers of the copied nodes
	        current = head;
	        while (current != null) {
	            if (current.random != null) {
	                current.next.random = current.random.next;
	            }
	            current = current.next.next;
	        }

	        // Step 3: Separate the original and copied nodes
	        Node original = head;
	        Node copy = head.next;
	        Node copyHead = copy;

	        while (original != null) {
	            original.next = original.next.next;
	            if (copy.next != null) {
	                copy.next = copy.next.next;
	            }
	            original = original.next;
	            copy = copy.next;
	        }

	        return copyHead;
	    }

	    public void printList(Node head) {
	        Node current = head;
	        while (current != null) {
	            System.out.print(current.data + " ");
	            current = current.next;
	        }
	        System.out.println();
	    }
	}

	public class LinkedList_A14_Q4 {
	    public static void main(String[] args) {
	        LinkedList list = new LinkedList();

	        // Create the original linked list
	        Node node1 = new Node(1);
	        Node node2 = new Node(3);
	        Node node3 = new Node(5);
	        Node node4 = new Node(9);
	        node1.next = node2;
	        node2.next = node3;
	        node3.next = node4;

	        // Set the random pointers
	        node1.random = node1;
	        node2.random = node4;

	        // Set the head of the original linked list
	        list.head = node1;

	        // Create a copy of the linked list
	        Node copyHead = list.copyRandomList(list.head);

	        // Print the copied list
	        list.printList(copyHead);
	    }
	}
