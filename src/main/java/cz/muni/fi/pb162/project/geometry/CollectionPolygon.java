/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 * Class for making (simple) CollectionPolygon objects with different number of vertices.
 * 
 * @author Benjamin Havlik
 */
public class CollectionPolygon extends SimplePolygon {
    private List<Vertex2D> vertices = new ArrayList<>();
    
    /**
     * Constructor of a CollectionPolygon objects that takes Array as a paramater.
     * 
     * @param vertices  defines the vertices of a polygon 
     */
    public CollectionPolygon(Vertex2D[] vertices) {
        super(vertices);        
        this.vertices.addAll(Arrays.asList(vertices));
    }
    
    /**
     * Constructor of a CollectionPolygon objects that takes List as a parameter.
     * 
     * @param vertices defines the vertices of a polygon
     */
    public CollectionPolygon(List<Vertex2D> vertices) {
        super(vertices.toArray(Vertex2D[]::new));
        this.vertices.addAll(vertices);      
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        
        CollectionPolygon secondPolygon = (CollectionPolygon) o;
        
        return secondPolygon.vertices.equals(this.vertices);
    }
    
    @Override
    public int hashCode() {
        return this.vertices.hashCode();
    }
    
    @Override
    public int getNumVertices() {
        return this.vertices.size();
    }
    
    @Override
    public Vertex2D getVertex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index can not be negative");
        }
        
        return this.vertices.get(index % this.getNumVertices());
    }
    
    /**
     * Get a new polygon without the leftmost vertices.
     * 
     * @return a new polygon without the leftmost vertices
     */
    public CollectionPolygon withoutLeftmostVertices() {
        double minX = SimpleMath.minX(this);
        List<Vertex2D> newVertices = new ArrayList<>();
        
        for (Vertex2D vertice : this.vertices) {
            if (vertice.getX() > minX) {
                newVertices.add(vertice);
            }
        }
        
        if (newVertices.isEmpty()) {
            return null;
        }
        
        return new CollectionPolygon(newVertices.toArray(Vertex2D[]::new));
    }
}
