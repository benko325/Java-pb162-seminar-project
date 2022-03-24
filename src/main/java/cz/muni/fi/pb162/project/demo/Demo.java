package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import cz.muni.fi.pb162.project.geometry.RegularOctagon;


/**
 * Class for running main method.
 *
 * @author Benjamin Havlik
 */
public class Demo {

    /**
     * Runs the code.
     * Creates regular octagon with center [0, 0] and radius 1
     * and writes information about it to standard output.
     *
     * @param args command line arguments, will be ignored
     */
    public static void main(String[] args) {
        Vertex2D center = new Vertex2D(0, 0);
        RegularOctagon octagon = new RegularOctagon(center, 1.0);
        
        System.out.println(octagon);
    }
}
