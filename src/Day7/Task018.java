package Day7;

class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }
}
public class Task018 {
    public static void main(String[] args) {
        Person myObj = new Person();
        myObj.setName("Venky");
        System.out.println(myObj.getName());

    }
}
