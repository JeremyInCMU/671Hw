import java.text.DecimalFormat;
/**
 * Code for Square which is a subclass of Rectangle.
 * @author Jiaming Xiao
 */
public class Square extends Rectangle {
     /**
      * Instance variable for side.
      */
     private double side;
     /**
      * Constructor of Square with side paramter.
      * @param newSide side
      */
     public Square(double newSide) {
         super(newSide, newSide);
         side = newSide;
     }
     /**
      * Returns side value of Square object.
      * @return side value in double
      */
     public double getSide() {
         return side;
     }
     /**
      * Returns area value of Square object.
      * @return area value in double
      */
     @Override
     public double getArea() {
         return (side * side);
     }
     /**
      * Returns perimeter value of Square object.
      * @return perimeter value in double
      */
     @Override
     public double getPerimeter() {
         return (4 * side);
     }
     /**
      * Returns String representation of Square object.
      * @return String representation of Square object
      */
     public String toString() {
         DecimalFormat pattern = new DecimalFormat("0.000");
         return "Square " + pattern.format(side * side) + " "
                + pattern.format(4 * side);
     }
}
