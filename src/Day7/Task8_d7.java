package Day7;

class customer{
    String name;

    public customer(String name){
        this.name = name;
    }

    void displayName(){
        System.out.println(name);
    }
}
public class Task8_d7 {
    public static void main(String[] args) {
        customer atlas = new customer("Venky");
        System.out.println(atlas.name);
        atlas.displayName();
    }
}
