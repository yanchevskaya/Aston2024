public class Rectangle implements Square{
    private double sideOne;
    private double sideTwo;
    private String borderColor;
    private String fillColor;

    public Rectangle(double sideOne, double sideTwo, String borderColor, String fillColor) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public Rectangle(double sideOne, double sideTwo) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
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

    public double square(){
        return sideOne*sideTwo;
    }

    public double perimeter(){
        return (sideOne+sideTwo)*2;
    }

    public void print(){
        System.out.printf("Square rectangle: %.2f\nPerimeter rectangle: %.2f\n" +
                "Border color: %s\nFill color: %s\n",  square(), perimeter(), getBorderColor(), getFillColor());
    }
}
