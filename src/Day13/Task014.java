import java.util.*;
import java.util.LinkedList;

public class Task014 {
    public static void main(String[] args) {
        LinkedList<String> lobj = new LinkedList<>();
        lobj.add("Venky");
        lobj.add("Venkatesh");
        lobj.add(".VS");
        Spliterator<String> sitobj = lobj.spliterator();
        //forEachRemaining is a method of Spliterator
        System.out.println("Splitting the list:");
        sitobj.forEachRemaining(System.out::println);
    }

}
