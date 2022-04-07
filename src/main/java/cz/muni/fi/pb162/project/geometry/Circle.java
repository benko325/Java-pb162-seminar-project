/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Class for making Circle objects with centre, which is a Vertex2D type and a radius.
 * 
 * @author Benjamin Havlik
 */
public class Circle extends GeneralRegularPolygon {

    /**
     * Constructor of a Circle objects without parameters.
     */
    public Circle() {
        this(new Vertex2D(0.0, 0.0), 1.0);
    }
    
    /**
     * Constructor of a Circle objects.
     * 
     * @param center defines the coordinates of a circle center
     * @param radius defines the radius of a circle 
     */
    public Circle(Vertex2D center, double radius) {
        super(center, Integer.MAX_VALUE, radius);
        this.setColor(Color.RED);
    }

    @Override
    public String toString() {
        return "Circle: center=" + this.getCenter() + ", radius=" + this.getRadius();
    }
    
    @Override
    public double getEdgeLength() {
        return 0.0;
    }
}
