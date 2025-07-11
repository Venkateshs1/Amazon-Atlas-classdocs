public class Task003 {
    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    Node head = null;
    Node tail = null;

    // Add elements to the circular linked list
    public void addElement(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Display the circular linked list
    public void displayElements() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        System.out.println("Circular Linked List elements:");
        do {
            System.out.println(current.data);
            current = current.next;
        } while (current != head); // Stop when we circle back to head
    }

    // Main method
    public static void main(String[] args) {
        Task003 list = new Task003();

        // Add 4 elements
        list.addElement(5);
        list.addElement(15);
        list.addElement(25);
        list.addElement(35);

        // Display the list
        list.displayElements();
    }
}
