import java.util.*;
public class Task8_d14 {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        names.push("A");
        names.push("B");
        names.push("C");
        System.out.println("Stack of names: " + names);
        String Val = "C";
        int position = names.search(Val);
        System.out.println("The searched value is at position " + position);
    }
}
