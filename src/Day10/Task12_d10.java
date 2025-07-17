import java.util.stream.*;

public class Task12_d10 {
    public static void main(String[] args) {
        Stream<String> stream
                = Stream.of("Heelo", "My",
                "name", "is",
                "Venky",
                ".S");

        stream.forEach(System.out::println);
    }

}
