package Day8;
class Customer01 {
    int cost = 100;
    String items = "Tomatoes";
}
public class Task23_d8 extends Customer01 {
    int cost = 200;
    String items=  "Potatoes";

    void purchaseList() {
        System.out.println(cost);
        System.out.println(items);
        System.out.println(super.cost);
        System.out.println(super.items);
        super.cost = 300;
        super.items = "Pizza";
        System.out.println(super.cost);
        System.out.println(super.items);
    }
    public static void main(String[] args) {

        Task23_d8 mart1 = new Task23_d8();

        mart1.purchaseList();



    }
}
