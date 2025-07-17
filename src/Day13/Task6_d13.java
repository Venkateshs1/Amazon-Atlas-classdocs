import java.util.LinkedList;
public class Task6_d13 {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add("AA");
        linkedList.add("BB");
        linkedList.add("CC");
        System.out.println("First elemeent: "+linkedList.getFirst());
        System.out.println("Last Element: "+linkedList.getLast());
        System.out.println("ALl Items:");
        for (String i : linkedList){
            System.out.println(i);
        }
    }
}
