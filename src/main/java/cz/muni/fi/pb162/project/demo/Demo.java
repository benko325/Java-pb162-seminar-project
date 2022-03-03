package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.Triangle;


/**
 * Class for running main method.
 *
 * @author Benjamin Havlik
 */
public class Demo {

    /**
     * Runs the code.
     * Creates 3 vertices with coordinates [-100, 0], [0, 100] and [100, -100].
     * Then newly creates a triangle with these coordinates and print the information about the triangle.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {
        Vertex2D v1 = new Vertex2D(-100, 0);
        Vertex2D v2 = new Vertex2D(0, 100);
        Vertex2D v3 = new Vertex2D(100, -100);
        
        Triangle triangle = new Triangle(v1, v2, v3);
        
        System.out.println(triangle);
    }
}
