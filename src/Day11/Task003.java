import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task003 {
    public static void main(String args[]) {
        FileOutputStream outfile = null;
//String s=args[0]; // to input string from command line
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter you Input: ");
        String s=sc.nextLine();
        byte b1[] = s.getBytes();
        try
        {
            outfile = new FileOutputStream("FileName02.txt");
            outfile.write(b1);
        }
        catch(IOException e)
        {
            System.out.println(e);
            System.exit(-1);
        }
        System.out.println("Write Byte");
        System.out.println("Thank You...!!!");
    }

}
