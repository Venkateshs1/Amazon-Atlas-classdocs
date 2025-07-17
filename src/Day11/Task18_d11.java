package streams;
import java.util.stream.Stream;

public class Task18_d11 {
    public static void main(String[] args) {

        Stream<Integer> nums = Stream.iterate(1, n -> n + 1)
                .limit(20);

        System.out.println("First 10 numbers from the stream:");
        nums.limit(10).forEach(System.out::println);
    }
}
