package Day9;
class OuterClass3{
    int x = 50;
    class InnerClass {
        public int innerMethod() {
            return x;
        }
    }
}
public class Task14_d9 {
    public static void main(String[] args) {
        OuterClass3 myOuter = new OuterClass3();
        OuterClass3.InnerClass myInner = myOuter.new InnerClass();
        System.out.println(myInner.innerMethod());
    }
}
