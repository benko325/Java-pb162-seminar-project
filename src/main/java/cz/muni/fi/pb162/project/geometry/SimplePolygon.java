/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;
import cz.muni.fi.pb162.project.utils.SimpleMath;

/**
 * Abstract class representing simple polygons.
 * 
 * @author Benjamin Havlik
 */
public abstract class SimplePolygon implements Polygon {
    
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
