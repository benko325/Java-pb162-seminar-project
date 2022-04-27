/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;
import cz.muni.fi.pb162.project.utils.SimpleMath;
import cz.muni.fi.pb162.project.exception.MissingVerticesException;

/**
 * Abstract class representing simple polygons.
 * 
 * @author Benjamin Havlik
 */
public abstract class SimplePolygon implements Polygon {
    
    /**
     * Constructor of SimplePolygon used only by subclasses.
     * 
     * @param vertices defines vertices of a polygon
     */
    public SimplePolygon(Vertex2D[] vertices) {
        if (vertices == null) {
            throw new IllegalArgumentException("parameter vertices can not be null");
        }
        
        if (vertices.length < 3) {
            throw new MissingVerticesException("parameter vertices must have at least 3 vertices");
        }
        
        for (Vertex2D vertice : vertices) {
            if (vertice == null) {
                throw new IllegalArgumentException("parameter vertices can not have a null pointer in itself");
            }
        }
    }
    
    @Override
    public double getHeight() {
        return SimpleMath.maxY(this) - SimpleMath.minY(this);
    }
    
    @Override
    public double getWidth() {
        return SimpleMath.maxX(this) - SimpleMath.minX(this);
    }
    
    @Override
    public String toString() {
        String result =  "Polygon: vertices =";
        
        for (int i = 0; i < this.getNumVertices(); i++) {
            result += " " + this.getVertex(i);
        }
        
        return result;
    }
    
    @Override
    public abstract Vertex2D getVertex(int index);
    
    @Override
    public abstract int getNumVertices();
}
