package LinkedList;

import java.util.LinkedList;
public class Task10_d13 {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();

        myList.add(100);
        myList.add(200);
        myList.add(300);

        // 1. Print directly (internally uses toString)
        System.out.println("Printing LinkedList directly:");
        System.out.println(myList);

        // 2. Using forEach method with lambda (not a loop in code)
        System.out.println("\nPrinting using forEach method:");
        myList.forEach(System.out::println);
    }
}
