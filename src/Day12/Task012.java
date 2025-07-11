import java.util.Hashtable;
import java.util.Map;

public class Task012 {
    public static void main(String[] args) {
        Hashtable<String, Integer> ht = new Hashtable<>();
        ht.put("Anitha", 101);
        ht.put("Kavitha", 102);
        ht.put("Meera", 103);
            // use  get method of Ht
        for (Map.Entry<String, Integer> e : ht.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());
    }
//public static void main(String[] args) {
//    HashMap<String, Integer> ht = new HashMap<>();
//    ht.put("Anitha", 101);
//    ht.put("Kavitha", 102);
//    ht.put("Meera", 103);
//    // use  get method of Ht
//    for (Map.Entry<String, Integer> e : ht.entrySet())
//        System.out.println(e.getKey() + " " + e.getValue());
//}
}
