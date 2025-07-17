
import java.util.*;
import java.util.stream.Collectors;
public class Task16_d11 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Step 1: Accept 5 integers from user
    List<Integer> numbers = new ArrayList<>();
    System.out.println("Enter 5 integers:");
    for (int i = 0; i < 5; i++) {
        numbers.add(sc.nextInt());
    }

    List<Integer> addNumbers = numbers.stream()
            .filter(num -> num % 2 !=0)
            .collect(Collectors.toList());

    System.out.println("Enter the numbers:");
    addNumbers.forEach(System.out::println);

    sc.close();
}
}
