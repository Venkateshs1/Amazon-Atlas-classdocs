public class Task016 {
    // Node class for Doubly Linked List
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    // Head and tail references
    Node head = null;
    Node tail = null;

    // Method to add elements to the end of the list
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;   // Link last node to new node
            newNode.prev = tail;   // Link new node back to last node
            tail = newNode;        // Move tail to new node
        }
    }

    // Method to display the list forward
    public void displayForward() {
        Node current = head;
        System.out.println("Doubly Linked List (Forward):");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to display the list backward
    public void displayBackward() {
        Node current = tail;
        System.out.println("Doubly Linked List (Backward):");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Main method to run
    public static void main(String[] args) {
        Task016 dll = new Task016();

        // Add some nodes
        dll.add(10);
        dll.add(20);
        dll.add(30);
        dll.add(40);

        // Display forward and backward
        dll.displayForward();
        dll.displayBackward();
    }
}