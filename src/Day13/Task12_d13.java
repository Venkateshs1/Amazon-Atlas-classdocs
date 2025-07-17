package LinkedList;

import java.util.LinkedList;
public class Task12_d13 {
    public static void main(String[] args) {
        // Create the original LinkedList
        LinkedList<String> originalList = new LinkedList<>();
        originalList.add("Apple");
        originalList.add("Banana");
        originalList.add("Cherry");

        // Clone the LinkedList
        LinkedList<String> clonedList = (LinkedList<String>) originalList.clone();

        // Display both lists
        System.out.println("Original List: " + originalList);
        System.out.println("Cloned List:   " + clonedList);

        // Modify original to verify cloning
        originalList.set(0, "Avocado");

        // Display after modification
        System.out.println("\nAfter modifying original list:");
        System.out.println("Original List: " + originalList);
        System.out.println("Cloned List:   " + clonedList);
    }
}
