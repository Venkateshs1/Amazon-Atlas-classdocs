package Day7;

public class Task6_d7 {
    static void check(int a, int b){
        String result = (a>b)?a+" is greater than "+b: b+" is greater than "+a;
        System.out.println(result);
    }

    public static void main(String[] args) {
        check(5,8);
    }
}
