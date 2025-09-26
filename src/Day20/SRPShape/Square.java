package Day20.SRPShape;

class Square implements Shape {
    int height;

    public Square(int height) {
        this.height = height;
    }

    public double area() {
        return height * height;
    }
}
