import java.util.HashMap;

public class Task18_d13 {
    public static void main(String[] args) {
        // Original HashMap with some values
        HashMap<String, Integer> hm2 = new HashMap<>();
        hm2.put("A", 1);
        hm2.put("B", 2);
        hm2.put("C", 3);

        // Copy hm2 to hm3
        HashMap<String, Integer> hm3 = new HashMap<String, Integer>(hm2);

        // Print the copied HashMap
        System.out.println("Copied HashMap (hm3):");
        for (String key : hm3.keySet()) {
            System.out.println(key + " => " + hm3.get(key));
        }
    }
}
