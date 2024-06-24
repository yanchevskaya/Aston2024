package lesson_7;

public class Circle implements Area{
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
        return r*r*Area.PI;
    }

    public double perimeter(){
        return 2*r*Area.PI;
    }

    public void print(){
        System.out.printf("Square circle: %.2f\nPerimeter circle: %.2f\n" +
                "Border color: %s\nFill color: %s\n",  square(), perimeter(), getBorderColor(), getFillColor());
    }
}
