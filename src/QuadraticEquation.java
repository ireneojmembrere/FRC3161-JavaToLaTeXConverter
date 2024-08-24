import java.util.Arrays;

public class QuadraticEquation {
    // coefficients of quadratic equation in standard form $ax^2 + bx + c = 0$
    private final double a,b,c;

    // constructor method to set the coefficients of the quadratic in standard form
    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    // retrieval method for coefficient a
    public double getA(){
        return a;
    }

    // retrieval method for coefficient b
    public double getB(){
        return b;
    }

    // retrieval method for coefficient c
    public double getC(){
        return c;
    }

    // method to return zeroes of quadratic equation making use of the quadratic formula
    // $x_{1,2} = \frac{-b \pm \sqrt{b^2 - 4ac}}{2a}$
    public double[] getRoots(){
        double disc = Math.pow(getB(),2) - 4*getA()*getC(); // the discriminant

        if (disc >= 0){
            double[] roots = new double[2];
            roots[0] = (-1*getB() + Math.sqrt(disc)) / (2*getA()); // the root using +
            roots[1] = (-1*getB() + Math.sqrt(disc)) / (2*getA()); // the root using -
            return roots;
        } else {
            return null; // the case of no roots
        }
    }

    // method to print the x and y coordinates of the vertex of the parabola
    public void printVertex(){
        double[] vertex = new double[2];
        vertex[0] = -1 * getB() / (2*getA()); // x coordinate
        vertex[1] = getA()*Math.pow(vertex[0],2) + getB()*vertex[0] + getC(); // y coordinate

        System.out.println("The vertex of the parabola is located at (x,y) = " + Arrays.toString(vertex));
    }
}
