import java.util.LinkedList;
import java.util.Arrays;
public class Task011 {
    public static void main(String[] args) {
        // Create a LinkedList of Integers
        LinkedList<Integer> myList = new LinkedList<>();

        // Add some elements
        myList.add(10);
        myList.add(20);
        myList.add(30);
        myList.add(40);


        Object[] arr = myList.toArray();

        System.out.println("LinkedList converted to Array:");
        System.out.println(Arrays.toString(arr));
    }
}
