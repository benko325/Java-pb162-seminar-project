package cz.muni.fi.pb162.project.demo;
import cz.muni.fi.pb162.project.geometry.LabeledPolygon;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import java.io.File;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Class for running main method.
 *
 * @author Benjamin Havlik
 */
public class Demo {

    /**
     * Runs the code.
     * Creates LabeledPolygon from the file "polygon-ok.txt" and add vertex called "vrchol x"
     * with coordinates [123, 456] and write the output to the output stream System.out in JSON format.
     * Then it prints "Hello World!".
     *
     * @param args command line arguments, will be ignored
     * @throws IOException on read error
     */
    public static void main(String[] args) throws IOException {
        File file = new File("polygon-ok.txt");
        LabeledPolygon polygon = new LabeledPolygon.Builder().
                read(file).addVertex("vrchol x", new Vertex2D(123.00, 456.00)).build();
        
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Collection<String> labels = polygon.getLabels();
        SortedMap<String, Vertex2D> tmp = new TreeMap<>();
        
        for (String label : labels) {
            tmp.put(label, polygon.getVertex(label));
        }
        
        System.out.print(gson.toJson(tmp));
        System.out.println("Hello World!");
    }
}
