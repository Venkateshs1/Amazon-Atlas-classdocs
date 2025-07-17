import java.util.*;
public class Task13_d11 {
    public static void main(String[] args) {
        // Create a List to store friends' names
        List<String> friends = new ArrayList<>();

        // Add 5 friends' full names
        friends.add("Rohit Sharma");
        friends.add("Virat Kohli");
        friends.add("Fermin Lopez");
        friends.add("Pedri Gonzalez");
        friends.add("Pablo Gavi");

        // Display the list of friends
        System.out.println("List of Friends:");
        for (String friend : friends) {
            System.out.println(friend);
        }
    }
}
