public class Circle implements Square{
    private double r;
    private String borderColor;
    private String fillColor;

    public Circle(double r, String borderColor, String fillColor) {
        this.r = r;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public Circle(int r) {
        this.r = r;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public double square() {
        return r*r*Square.PI;
    }

    public double perimeter(){
        return 2*r*Square.PI;
    }

    public void print(){
        System.out.printf("Square circle: %.2f\nPerimeter circle: %.2f\n" +
                "Border color: %s\nFill color: %s\n",  square(), perimeter(), getBorderColor(), getFillColor());
    }
}
