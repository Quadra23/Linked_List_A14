

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

	    public Node reverseList(Node head) {
	        Node current = head;
	        Node prev = null;
	        Node next = null;

	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }

	        return prev;
	    }

	    public Node addOne(Node head) {
	        Node reversedHead = reverseList(head);
	        Node current = reversedHead;
	        int carry = 1;

	        while (current != null) {
	            int sum = current.data + carry;
	            current.data = sum % 10;
	            carry = sum / 10;

	            if (carry == 0) {
	                break;
	            }

	            current = current.next;
	        }

	        Node updatedHead = reverseList(reversedHead);

	        if (carry != 0) {
	            Node newHead = new Node(carry);
	            newHead.next = updatedHead;
	            updatedHead = newHead;
	        }

	        return updatedHead;
	    }

	    public void printList(Node head) {
	        Node current = head;
	        while (current != null) {
	            System.out.print(current.data);
	            current = current.next;
	        }
	        System.out.println();
	    }
	}

	public class LinkedList_A14_Q2 {
	    public static void main(String[] args) {
	        LinkedList list = new LinkedList();

	        // Add elements to the linked list
	        list.add(4);
	        list.add(5);
	        list.add(6);

	        // Add 1 to the number represented by the linked list
	        list.head = list.addOne(list.head);

	        // Print the updated list
	        list.printList(list.head);
	    }
	}
