import java.text.DecimalFormat;
/**
 * Code for Circle which is a subclass of Shape.
 * @author Jiaming Xiao
 */
public class Circle extends Shape {
    /**
     * Instance variable for radius.
     */
    private double radius;
    /**
     * Constructor to create Circle with radius.
     * @param newRadius  radius value of circle
     */
    public Circle(double newRadius) {
        super();
        radius = newRadius;
    }
    /**
     * Returns radius value of a Circle object.
     * @return double radius value
     */
    public double getRadius() {
        return radius;
    }
    /**
     * Returns area value of a Circle object.
     * @return double area value
     */
    public double getArea() {
        return (Math.PI * radius * radius);
    }
    /**
     * Returns perimeter value of a Circle object.
     * @return double perimeter value
     */
    public double getPerimeter() {
        return (Math.PI * 2 * radius);
    }
    /**
     * Returns String representation of Circle object.
     * @return String representation of Circle object.
     */
    @Override
    public String toString() {
        DecimalFormat pattern = new DecimalFormat("0.000");
        return "Circle " + pattern.format(Math.PI * radius * radius)
               + " " + pattern.format(Math.PI * 2 * radius);
    }
}
