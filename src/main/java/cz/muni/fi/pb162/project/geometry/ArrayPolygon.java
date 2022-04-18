/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;
import java.util.Arrays;

/**
 * Class for making (simple) ArrayPolygon objects with different number of vertices.
 * 
 * @author Benjamin Havlik
 */
public class ArrayPolygon extends SimplePolygon {
    private final Vertex2D[] vertices;
    
    /**
     * Constructor of a ArrayPolygon objects.
     * 
     * @param vertices  defines vertices form which is a polygon made
     */
    public ArrayPolygon(Vertex2D[] vertices) {
        super(vertices);        
        this.vertices = Arrays.copyOf(vertices, vertices.length);
    }
    
    @Override
    public int getNumVertices() {
        return this.vertices.length;
    }
    
    @Override
    public Vertex2D getVertex(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("index can not be negative");
        }
        
        return this.vertices[i % this.getNumVertices()];
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        
        ArrayPolygon secondPolygon = (ArrayPolygon) o;
        
        return Arrays.equals(this.vertices, secondPolygon.vertices);
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(this.vertices);
    }
}
