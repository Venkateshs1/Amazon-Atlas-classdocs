import java.util.ArrayList;

public class Task012 {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> friends = new ArrayList<>();

        // Add 5 friend names
        friends.add("venky");
        friends.add("poori");
        friends.add("Sai");
        friends.add("lamine");
        friends.add("nico");

        // Display the names
        System.out.println("My Friends:");
        for (String name : friends) {
            System.out.println(name);
        }
    }
}
