import java.util.LinkedList;
import java.util.Spliterator;

public class Task015 {
    public static void main(String[] args) {

        LinkedList<String> llobj = new LinkedList<String>();
        llobj.add("Venky");
        llobj.add("Venkatesh");
        llobj.add(".VS");
        llobj.add("SR");

        Spliterator<String> itobj1 = llobj.spliterator();
        Spliterator<String> itobj2 = itobj1.trySplit();

        System.out.println("spliterator 1");
        while( itobj1.tryAdvance( (n) -> { System.out.println(n); } ) );

        System.out.println("spliterator 2");
        while( itobj2.tryAdvance( (n) -> { System.out.println(n); } ) );
    }

}
