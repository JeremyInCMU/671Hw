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
        super(3 * Math.sqrt(3) * newSide * newSide / 2, 6 * newSide);
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
