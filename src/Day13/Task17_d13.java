package LinkedList;
import java.util.HashMap;
public class Task17_d13 {
    public static void main(String[] args) {
        // Create HashMap with initial capacity of 10
        HashMap<String, Integer> hm2 = new HashMap<String, Integer>(10);
        // Add 11 key-value pairs
        hm2.put("A", 1);
        hm2.put("B", 2);
        hm2.put("C", 3);
        hm2.put("D", 4);
        hm2.put("E", 5);
        hm2.put("F", 6);
        hm2.put("G", 7);
        hm2.put("H", 8);
        hm2.put("I", 9);
        hm2.put("J", 10);
        hm2.put("K", 11); // 11th element
        // Print the HashMap
        System.out.println("HashMap contents:");
        for (String key : hm2.keySet()) {
            System.out.println(key + " => " + hm2.get(key));
        }
    }
}
