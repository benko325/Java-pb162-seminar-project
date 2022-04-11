/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

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
        if (vertices == null) {
            throw new IllegalArgumentException("parameter vertices can not be null");
        }
        
        if (vertices.length < 3) {
            throw new IllegalArgumentException("parameter vertices must have at least 3 Vertex2D objects");
        }
        
        for (Vertex2D vertice : vertices) {
            if (vertice == null) {
                throw new IllegalArgumentException("parameter vertices can not have a null in itself");
            }
        }
        
        this.vertices = new Vertex2D[vertices.length];
        System.arraycopy(vertices, 0, this.vertices, 0, vertices.length);
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
        
        if (this.getNumVertices() != secondPolygon.getNumVertices()) {
            return false;
        }
        
        for (int i = 0; i < this.getNumVertices(); i++) {
            if (!(this.getVertex(i).equals(secondPolygon.getVertex(i)))) {
                return false;
            }
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = 23;
        
        for (int i = 0; i < this.getNumVertices(); i++) {
            result = (41 * result) + this.getVertex(i).hashCode();
        }
        
        return result;
    }
}
