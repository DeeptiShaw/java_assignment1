public class Calculator {

    // Method Overloading for Addition
    public int add(int a, int b) {
        return a + b;
    }
    public double add(double a, double b) {
        return a + b;
    }
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method Overloading for Subtraction
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method Overloading for Multiplication
    public double multiply(double a, double b) {
        return a * b;
    }

    // Method Overloading for Division (with Exception Handling)
    public double divide(int a, int b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Error: Cannot divide by zero!");
            }
            return (double) a / b;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return Double.NaN;
        }
    }
}
