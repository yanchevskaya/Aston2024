package lesson_7;

public class Triangle implements Area{
    private double sideOne;
    private double sideTwo;
    private double sideThree;
    private String borderColor;
    private String fillColor;

    public Triangle(double sideOne, double sideTwo, double sideThree, String borderColor, String fillColor) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
        this.borderColor = borderColor;
        this.fillColor = fillColor;
    }

    public Triangle(double sideOne, double sideTwo, double sideThree) {
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public String getFillColor() {
        return fillColor;
    }

    public double square(){
        double p = perimeter() /2;
        return Math.sqrt(p*(p-sideOne)*(p-sideTwo)*(p-sideThree));
    }

    public double perimeter(){
        return sideOne+sideTwo+sideThree;
    }

    public void print(){
        System.out.printf("Square triangle: %.2f\nPerimeter triangle: %.2f\n" +
                "Border color: %s\nFill color: %s\n",  square(), perimeter(), getBorderColor(), getFillColor());
    }

}