package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Square;


/**
 * Class for running main method.
 *
 * @author Benjamin Havlik
 */
public class Demo {

    /**
     * Runs the code.
     * Creates a square with center [0, 0], diameter of square 100 
     * and writes information about it to standard output.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {
        Vertex2D center = new Vertex2D(0, 0);
        Square square = new Square(center, 100);
        
        System.out.println(square);
    }
}
