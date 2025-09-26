package Day24.ConcretePrototype;

public interface Colors {
    Colors clone();
    String getName();
    void setName(String name);
}
