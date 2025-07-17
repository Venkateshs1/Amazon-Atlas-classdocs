package LinkedList;
import java.util.LinkedList;
public class Task7_d13 {
    public static void main(String[] args) {
        // Create a LinkedList of Strings
        LinkedList<String> myList = new LinkedList<>();

        // Add elements to the LinkedList
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");
        myList.add("Date");

        // Display original list
        System.out.println("Original List: " + myList);

        // Remove first and last elements
        myList.removeFirst();
        myList.removeLast();

        // Display list after removal
        System.out.println("After Removing First and Last: " + myList);
    }
}
