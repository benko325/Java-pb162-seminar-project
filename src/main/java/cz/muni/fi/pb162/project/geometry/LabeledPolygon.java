/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Collections;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class representing polygons with named vertices.
 * 
 * @author Benjamin Havlik
 */
public final class LabeledPolygon extends SimplePolygon implements Labelable, Sortable, PolygonWritable {
    private SortedMap<String, Vertex2D> vertices = new TreeMap<>();
    
    /**
     * Utility nested class, which takes care of creating the LabeledPolygon.
     * 
     * @author Benjamin Havlik
     */
    public static class Builder implements Buildable, PolygonReadable {
        private SortedMap<String, Vertex2D> vertices = new TreeMap<>();
        
        /**
         * Method saves the vertex under the given name.
         * 
         * @param label name of the vertex
         * @param vert  vertex itself
         * @return      builder object
         * @throws      NullPointerException if the name or vertex is null
         */
        public Builder addVertex(String label, Vertex2D vert) {
            if (label == null || vert == null) {
                throw new IllegalArgumentException("label and vertex can not be null");
            }
            
            this.vertices.put(label, vert);
            
            return this;
        }
        
        @Override
        public LabeledPolygon build() {
            return new LabeledPolygon(this.vertices);
        }
        
        @Override
        public Builder read(InputStream is) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            Map<String, Vertex2D> helpMap = new HashMap<>();
            
            while (br.ready()) {
                String[] line = br.readLine().split(" ", 3);
                if (line.length < 3) {
                    throw new IOException("too few arguments in line");
                }
                
                try {
                    double x = Double.parseDouble(line[0]);
                    double y = Double.parseDouble(line[1]);
                    String label = line[2];
                    helpMap.put(label, new Vertex2D(x, y));
                } catch (NullPointerException | NumberFormatException e) {
                    throw new IOException(e);
                }             
            }
            
            this.vertices.putAll(helpMap);
            return this;
        }
        
        @Override
        public Builder read(File file) throws IOException {
            try (FileInputStream fis = new FileInputStream(file)) {
                this.read(fis);
            }
            
            return this;
        }
    }
    
    /**
     * Private constructor of a LabeledPolygon objects with one parameter.
     * 
     * @param vertices  defines the vertices of a LabeledPolygon 
     */
    private LabeledPolygon(Map<String, Vertex2D> vertices) {
        super(vertices.values().toArray(new Vertex2D[0]));
        this.vertices.putAll(vertices);
    }

    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("parameter index con not be negative");
        }
        
        //String label = new ArrayList<String>(vertices.keySet()).get(index % getNumVertices());
        //return vertices.get(label);
        
        return new ArrayList<>(vertices.values()).get(index % getNumVertices());
    }

    @Override
    public int getNumVertices() {
        return this.vertices.size();
    }

    @Override
    public Vertex2D getVertex(String label) {
        if (!this.vertices.containsKey(label)) {
            throw new IllegalArgumentException("vertex with given label does not exists here");
        }
        
        return this.vertices.get(label);
    }

    @Override
    public Collection<String> getLabels() {
        return Collections.unmodifiableSet(this.vertices.keySet());
    }

    @Override
    public Collection<String> getLabels(Vertex2D vertex) {
        return this.vertices.entrySet().stream().
                filter(s -> s.getValue().equals(vertex)).map(s -> s.getKey()).
                collect(Collectors.toSet());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices() {
        return new TreeSet<>(this.vertices.values());
    }

    @Override
    public Collection<Vertex2D> getSortedVertices(Comparator<Vertex2D> comparator) {
        TreeSet<Vertex2D> sorted = new TreeSet<>(comparator);
        sorted.addAll(this.vertices.values());
        
        return sorted;
    }
    
    /**
     * Method which returns a set of vertices that are stored multiple times 
     * under different names in the polygon.
     * 
     * @return set of vertices stored multiple times under different names in the polygon
     */
    public Collection<Vertex2D> duplicateVertices() {
       List<Vertex2D> list = new ArrayList<>(this.vertices.values());
       TreeSet<Vertex2D> setToReturn = new TreeSet<>();
       TreeSet<Vertex2D> helpSet = new TreeSet<>();
       
       for (Vertex2D vertice : list) {
           if (!helpSet.add(vertice)) {
               setToReturn.add(vertice);
           }
       }
       
       return setToReturn;
    }
    
    @Override
    public void write(OutputStream os) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        for (Map.Entry<String, Vertex2D> vertice : this.vertices.entrySet()) {
            String line = vertice.getValue().getX() + " " + 
                    vertice.getValue().getY() + " " + vertice.getKey();
            
            bw.write(line);
            bw.newLine();
        }
            
        bw.flush();
    }
    
    @Override
    public void write(File file) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            this.write(fos);
        }
    }
    
    /**
     * Write a map in JSON format to the output stream.
     * 
     * @param os output stream to be written on
     * @throws IOException on write error
     */
    public void writeJson(OutputStream os) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        for (Map.Entry<String, Vertex2D> vertice : this.vertices.entrySet()) {
            String json = gson.toJson(vertice);
            bw.write(json);
            bw.newLine();
        }
        
        bw.flush();
    }
}
