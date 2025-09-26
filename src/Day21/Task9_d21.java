package Day21;

class Engine {
    void start() {
        System.out.println("Engine starting");
    }
}

class Car {
    void drive() {
        Engine engine = new Engine();
        engine.start();
        System.out.println("Car is driving");
    }
}

public class Task9_d21 {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.drive();
    }
}
