import java.text.DecimalFormat;
/**
 * Codes for Hexagon which is a subclass of Shape.
 * @author Jiaming Xiao
 */
public class Hexagon extends Shape {
    /**
     * Instance variable for side.
     */
    private double side;

    /**
     * Constructor to create Hexagon with side.
     * @param newSide side value of Hexagon
     */
    public Hexagon(double newSide) {
        super();
        side = newSide;
    }
    /**
     * Returns side value of an Hexagon object.
     * @return double side  side value
     */
    public double getSide() {
        return side;
    }
    /**
     * Returns area value of an Hexagon object.
     * @return double area  area value
     */
    public double getArea() {
        return (3 * Math.sqrt(3) * side * side / 2);
    }
    /**
     * Returns perimeter value of an Hexagon object.
     * @return double perimeter perimeter value
     */
    public double getPerimeter() {
        return (6 * side);
    }
    /**
     * Returns String representation of Hexagon object.
     * @return String representation of Hexagon object
     */
    @Override
    public String toString() {
        DecimalFormat pattern = new DecimalFormat("0.000");
        return "Hexagon " + pattern.format(3 * Math.sqrt(3) * side * side / 2)
               + " " + pattern.format(6 * side);
    }
}
