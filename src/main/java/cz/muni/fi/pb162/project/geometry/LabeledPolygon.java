/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;
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

/**
 * Class representing polygons with named vertices.
 * 
 * @author Benjamin Havlik
 */
public final class LabeledPolygon extends SimplePolygon implements Labelable, Sortable {
    private SortedMap<String, Vertex2D> vertices = new TreeMap<>();
    
    /**
     * Utility nested class, which takes care of creating the LabeledPolygon.
     * 
     * @author Benjamin Havlik
     */
    public static class Builder implements Buildable {
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
    
}
