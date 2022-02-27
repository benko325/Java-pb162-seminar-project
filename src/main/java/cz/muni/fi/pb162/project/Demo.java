package cz.muni.fi.pb162.project;
import cz.muni.fi.pb162.project.geometry.Vertex2D;


/**
 * Class for running main method.
 *
 * @author Benjamin Havlik, 514493
 */
public class Demo {

    /**
     * Runs the code.
     * Creates 2 vertices with coordinates [2, 3] and [1, 1].
     * Then moves the first vertex by the coordinates of the second vertex and prints information about both vertices.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {

        Vertex2D v1 = new Vertex2D();
        v1.setX(2.0);
        v1.setY(3.0);
        
        Vertex2D v2 = new Vertex2D();
        v2.setX(1.0);
        v2.setY(1.0);
        
        v1.move(v2);
        System.out.println(v1.getInfo());
        System.out.println(v2.getInfo());

    }
}
