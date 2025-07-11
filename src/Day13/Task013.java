package LinkedList;
import java.util.LinkedList;
public class Task013 {
    public static void main(String[] args) {
        // Create a LinkedList of Strings (acting like a stack)
        LinkedList<String> stackList = new LinkedList<>();

        // Push elements (LIFO - add to front)
        stackList.push("A");
        stackList.push("B");
        stackList.push("C");

        // Now the list is: [C, B, A]
        System.out.println("After pushing elements (stack): " + stackList);

        // Pop elements (remove from front)
        String poppedElement = stackList.pop();
        System.out.println("Popped Element: " + poppedElement);

        // Display remaining elements
        System.out.println("After popping one element: " + stackList);
    }
}
