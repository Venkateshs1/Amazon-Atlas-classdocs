public class Task11_d16 {
    public int calc(int n) {
        if (n == 0) return 0;
        return n + calc(n - 1);
    }

    public static void main(String[] args) {
        Task11_d16 obj = new Task11_d16();
        int result = obj.calc(5); // Change the number to test other inputs
        System.out.println("Sum = " + result);
    }
}
