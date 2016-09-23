import java.text.DecimalFormat;
/**
 * code for Shape.
 * @author Jiaming Xiao
 */
public class Shape {
    /**
     * Instance variable for area.
     */
    private double area;
    /**
     * Instance variable for perimeter.
     */
    private double perimeter;
    /**
     * Constructor with both are and perimeter parameter.
     * @param newArea area value of shape
     * @param newPerimeter perimeter value of shape
     */
    public Shape(double newArea, double newPerimeter) {
        area = newArea;
        perimeter = newPerimeter;
    }
    /**
     * Returns area value of shape object.
     * @return area value in double
     */
    public double getArea() {
        return area;
    }
    /**
     * Returns perimeter value of shape object.
     * @return perimeter value in double
     */
     public double getPerimeter() {
         return perimeter;
     }
     /**
      * Return String representation of Shape object.
      * @return String representation of Shape object
      */
     @Override
     public String toString() {
         DecimalFormat pattern = new DecimalFormat("0.000");
         return "Shape " + pattern.format(area) + " " + pattern.format(perimeter);
     }
}
