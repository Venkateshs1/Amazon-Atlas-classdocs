public class Task011 {
    public int calc(int n) {
        if (n == 0) return 0;
        return n + calc(n - 1);
    }

    public static void main(String[] args) {
        Task011 obj = new Task011();
        int result = obj.calc(5); // Change the number to test other inputs
        System.out.println("Sum = " + result);
    }
}
