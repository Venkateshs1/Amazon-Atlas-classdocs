package Day7;

public class Task13_d7 {
    public static void main(String[] args) {
        for(int i = 10; i>=1; i--){
            if(i == 7 || i ==5){
                continue;
            }
            System.out.println(i);
        }
    }
}
