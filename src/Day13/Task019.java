import java.util.HashMap;
public class Task019 {
    public static void main(String[] args) {
        // Create HashMap with initial capacity 10 and load factor 0.75
        HashMap<String, Integer> hm4 = new HashMap<String, Integer>(10, 0.75f);

        // Add entries to the map
        hm4.put("One", 1);
        hm4.put("Two", 2);
        hm4.put("Three", 3);
        hm4.put("Four", 4);
        hm4.put("Five", 5);
        hm4.put("Six", 6);
        hm4.put("Seven", 7);

        // Add more entries (after threshold 10 * 0.75 = 7, resizing may happen)
        hm4.put("Eight", 8);
        hm4.put("Nine", 9);

        // Print all entries
        System.out.println("HashMap contents with load factor 0.75:");
        for (String key : hm4.keySet()) {
            System.out.println(key + " => " + hm4.get(key));
        }
    }
}
