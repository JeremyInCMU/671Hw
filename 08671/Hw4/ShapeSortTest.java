/**
 * Code for ShapeSortTest which is a class to sort input shapes.
 *      - Ascending order of area of shape
 *      - Descending order of perimeter of shape
 * @author Jiaming Xiao
 */
public class ShapeSortTest {
    /**
     * Get input arguments and create an array of instances.
     * @param args arguments of commandline
     */
    public static void main(String[] args) {
        int length = args.length;
        Shape[] shapes = new Shape[length];
        for (int i = 0; i < args.length; i++) {
            switch (args[i].charAt(0)) {
                case 'C':
                   shapes[i] = new Circle(Double.parseDouble(args[i].substring(1)));
                   break;
                case 'S':
                   shapes[i] = new Square(Double.parseDouble(args[i].substring(1)));
                   break;
                case 'H':
                   shapes[i] = new Hexagon(Double.parseDouble(args[i].substring(1)));
                   break;
                case 'O':
                   shapes[i] = new Octagon(Double.parseDouble(args[i].substring(1)));
                   break;
                default:
                   break;
            }
        }
        ShapeSortTest shapeTest = new ShapeSortTest();
        shapeTest.ascendSortArea(shapes);
        shapeTest.toString(shapes);
        System.out.println("");
        shapeTest.descendSortPerimeter(shapes);
        shapeTest.toString(shapes);
    }
    /**
     * Ascendingly sort an array of objects based on their area.
     * @param shapes shape array
     */
    public static void ascendSortArea(Shape[] shapes) {
        for (int i = 0; i < shapes.length - 1; i++) {
            for (int j = i + 1; j < shapes.length; j++) {
                if (shapes[i].getArea() > shapes[j].getArea()) {
                    Shape temp = shapes[j];
                    shapes[j] = shapes[i];
                    shapes[i] = temp;
                }
            }

        }
    }
    /**
     * Dscendingly sort an array of objects based on their perimeter.
     * @param shapes shape array
     */
    public static void descendSortPerimeter(Shape[] shapes) {
        for (int i = 0; i < shapes.length - 1; i++) {
            for (int j = i + 1; j < shapes.length; j++) {
                if (shapes[i].getPerimeter() < shapes[j].getPerimeter()) {
                    Shape temp = shapes[j];
                    shapes[j] = shapes[i];
                    shapes[i] = temp;
                }
            }

        }
    }
    /**
     * Returns String representation of objects.
     * @param shapes shape array
     */
    public static void toString(Shape[] shapes) {
        for (Shape shape: shapes) {
            if (shape instanceof Circle) {
                System.out.println(shape.toString());
            } else if (shape instanceof Square) {
                System.out.println(shape.toString());
            } else if (shape instanceof Hexagon) {
                System.out.println(shape.toString());
            } else if (shape instanceof Octagon) {
                System.out.println(shape.toString());
            }
        }
    }
}
