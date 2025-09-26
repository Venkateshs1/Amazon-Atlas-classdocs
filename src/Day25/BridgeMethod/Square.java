package Day25.BridgeMethod;

public class Square extends Shape {
    private int s;

    public Square(ExcalidrawAPI excalidrawAPI, int s) {
        super(excalidrawAPI);
        this.s = s;
    }

    @Override
    void draw() {
        excalidrawAPI.drawSquare(s);
    }
}
