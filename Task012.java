import java.util.Scanner;
import java.util.SplittableRandom;

public class Task012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count =0;
        System.out.println("Enter login Id : ");
        String id = sc.next();
        System.out.println("Enter your password : ");
        int pwd = sc.nextInt();
        while(id!="Venkatesh" && pwd!=1234){
            System.out.println("You have logged in " + ++count + "times");
            System.out.println("Enter your login Id : ");
            id = sc.next();
            System.out.println("Enter your password  : ");
            pwd = sc.nextInt();
        }
        System.out.println("You have entered in portal");
        System.out.println("For 2nd portal");

        String id2;
        int pwd2;
        do {
            System.out.println("You have logged in " + ++count + "times");
            System.out.println("Enter your login Id : ");
            id2= sc.next();
            System.out.println("Enter your password : ");
            pwd2= sc.nextInt();
        }
        while (id2!="Venk" && pwd2!=123);
        System.out.println("You have entered in 2nd portal");
    }
}
