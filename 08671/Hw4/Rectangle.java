import java.text.DecimalFormat;
/**
 * Code for Rectangle which is a subclass of Shape.
 * @author Jiaming Xiao
 */
public class Rectangle extends Shape {
    /**
     * Instance variable for width.
     */
    private double width;
    /**
     * Instance variable for height.
     */
    private double height;

    /**
     * Constructor with width and height.
     * @param newWidth width value
     * @param newHeight height value
     */
    public Rectangle(double newWidth, double newHeight) {
        super();
        width = newWidth;
        height = newHeight;
    }
    /**
     * Returns width value of rectangle object.
     * @return width value in double
     */
    public double getWidth() {
        return width;
    }
    /**
     * Returns height value of rectangle object.
     * @return height value in double
     */
    public double getHeight() {
        return height;
    }
    /**
     * Returns area value of rectangle object.
     * @return area value in double
     */
    public double getArea() {
        return (width * height);
    }
    /**
     * Returns perimeter value of rectangle object.
     * @return perimeter value in double
     */
    public double getPerimeter() {
        return (2 * (width + height));
    }
    /**
     * Returns String representation of rectangle object.
     * @return String representation of rectangle object
     */
     @Override
     public String toString() {
         DecimalFormat pattern = new DecimalFormat("0.000");
         return "Rectangle " + pattern.format(width * height) + " "
                + pattern.format(2 * (width + height));
     }
}
