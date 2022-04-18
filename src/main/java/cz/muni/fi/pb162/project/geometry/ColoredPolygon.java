/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Class representing polygons with colors.
 * 
 * @author Benjamin Havlik
 */
public class ColoredPolygon {
    private Polygon polygon;
    private Color color;
    
    /**
     * Constructor of a ColoredPolygon objects.
     * 
     * @param polygon   defines polygon
     * @param color     defines color of a polygon
     */
    public ColoredPolygon(Polygon polygon, Color color) {
        this.polygon = polygon;
        this.color = color;
    }
    
    public Polygon getPolygon() {
        return this.polygon;
    }
    
    public Color getColor() {
        return this.color;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        
        ColoredPolygon secondPolygon = (ColoredPolygon) o;
        
        return this.color.equals(secondPolygon.color) && this.polygon.equals(secondPolygon.polygon);
    }
    
    @Override
    public int hashCode() {
        return this.color.hashCode() * this.polygon.hashCode();
    }
}
