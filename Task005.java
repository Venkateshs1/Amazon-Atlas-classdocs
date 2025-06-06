import java.awt.geom.RectangularShape;

public class Task005 {
    public static int add(int a, int b){
        int res=a=b;
        return res;
    }
    public static int substract(int a, int b){
        int res=a-b;
        return res;
    }
    public static int multiply(int a, int b){
        int res=a*b;
        return res;
    }
    public static int divide(int a, int b){
        int res=a/b;
        return res;
    }

    public static void main(String[] args){
        int result1, result2, result3, result4;
        result1=add(5,6);
        result2=substract(4,1);
        result3=multiply(4,7);
        result4=divide(8,4);
        System.out.println("Addition : " + result1 + "Substraction :" + result2 + "Multiplication :" + result3 + "Divide : " + result4);

    }

}
