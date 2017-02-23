/**
 * Created by Xiaojun YU on 2017-02-21.
 */
public class FactoryPattern {
    /**
     * Your object will be instantiated and called as such:
     * ShapeFactory sf = new ShapeFactory();
     * Shape shape = sf.getShape(shapeType);
     * shape.draw();
     */
    interface Shape {
        void draw();
    }

    class Rectangle implements Shape {
        // Write your code here
        @Override
        public void draw() {
            System.out.println(" ---- ");
            System.out.println("|    |");
            System.out.println(" ---- ");
        }
    }

    class Square implements Shape {
        // Write your code here
        @Override
        public void draw() {
            System.out.println(" ---- ");
            System.out.println("|    |");
            System.out.println("|    |");
            System.out.println(" ---- ");
        }
    }

    class Triangle implements Shape {
        // Write your code here
        @Override
        public void draw() {
            System.out.println("  /\\ ");
            System.out.println(" /  \\ ");
            System.out.println("/____\\ ");
        }
    }

    public class ShapeFactory {
        /**
         * @param shapeType a string
         * @return Get object of type Shape
         */
        public Shape getShape(String shapeType) {
            // Write your code here
            switch (shapeType.toLowerCase()) {
                case "square":
                    return new Square();

                case "triangle":
                    return new Triangle();

                case "rectangle":
                    return new Rectangle();

            }
            return null;
        }
    }
}
