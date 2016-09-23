import java.text.DecimalFormat;
/**
 * Codes for Octagon which is a subclass of Shape.
 * @author Jiaming Xiao
 */
public class Octagon extends Shape {
    /**
     * Instance variable for side.
     */
    private double side;

    /**
     * Constructor to create Octagon with side.
     * @param newSide side value of octagon
     */
    public Octagon(double newSide) {
        super();
        side = newSide;
    }
    /**
     * Returns side value of an Octagon object.
     * @return double side side value
     */
    public double getSide() {
        return side;
    }
    /**
     * Returns area value of an Octagon object.
     * @return double area area value
     */
    public double getArea() {
        return (2 * side * side * (1 + Math.sqrt(2)));
    }
    /**
     * Returns perimeter value of an Octagon object.
     * @return double perimeter perimeter value
     */
    public double getPerimeter() {
        return (8 * side);
    }
    /**
     * Returns String representation of Octagon object.
     * @return String representation of Octagon object
     */
    @Override
    public String toString() {
        DecimalFormat pattern = new DecimalFormat("0.000");
        return "Octagon " + pattern.format(2 * side * side * (1 + Math.sqrt(2)))
               + " " + pattern.format(8 * side);
    }
}
