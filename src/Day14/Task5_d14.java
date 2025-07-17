import java.util.*;
public class Task5_d14 {
    public static void main(String[] args) {
        Stack<String> names= new Stack<>();

        names.push("Venky");
        names.push("DK");
        names.push("Driftking");

        System.out.println("before deletion ");
        System.out.println("Stack of names: " + names);

        System.out.println("after deletion ");
        String dummy = names.pop();

        System.out.println("Stack of names: " + names);
        System.out.println("deleted element is "+ dummy);
    }

}
