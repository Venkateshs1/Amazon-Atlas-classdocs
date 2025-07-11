package LinkedList;
import java.util.LinkedList;
public class Task009 {
    public static void main(String[] args) {
        // Create a LinkedList of Integers
        LinkedList<Integer> myList = new LinkedList<>();

        // Add some elements
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);

        // 1. Display using get() in a regular for loop
        System.out.println("Displaying with get() method:");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        // 2. Display using for-each loop
        System.out.println("\nDisplaying with for-each loop:");
        for (Integer num : myList) {
            System.out.println(num);
        }
    }
}
