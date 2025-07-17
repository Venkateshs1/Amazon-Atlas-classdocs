package LinkedList;
import java.util.LinkedList;
public class Task8_d13 {
    public static void main(String[] args) {
        LinkedList<String> myList = new LinkedList<>();

        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");
        myList.add("Date");

        System.out.println("Original List: " + myList);

        // Update the first element (index 0)
        myList.set(0, "Avocado");

        System.out.println("Updated List: " + myList);
    }
}
