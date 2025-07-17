import java.lang.FunctionalInterface;

// this is functional interface
@FunctionalInterface
interface MyInterface1{

    // abstract method
    double getPiValue();
}
public class Task9_d11 {
    public static void main( String[] args ) {
        // declare a reference to MyInterface
        MyInterface1 ref;

        // lambda expression
        ref = () -> 3.1415;

        System.out.println("Value of Pi = " + ref.getPiValue());
    }
}
