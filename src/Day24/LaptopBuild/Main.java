package Day24.LaptopBuild;

public class Main {
    public static void main(String[] args) {
        LaptopBuilder lbobj = new LaptopConcreteBuilder();
        LaptopDirector director = new LaptopDirector(lbobj);
        Laptop laptop = director.constructLaptop();

        System.out.println(laptop);
    }
}
