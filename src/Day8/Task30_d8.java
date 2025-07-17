package Day8;
interface testInterface {
    final int tax = 10;
    void display();
}



class TestClass implements testInterface {

    public void display(){
        System.out.println("Myclass");
    }
}
public class Task30_d8 {
    public static void main(String[] args)
    {
        TestClass t = new TestClass();
        t.display();
        System.out.println(t.tax);
    }
}
