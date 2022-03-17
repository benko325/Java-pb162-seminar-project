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
public class Circle implements Measurable, Circular {
    private final Vertex2D center;
    private final double radius;
    
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
        this.center = center;
        this.radius = radius;
    }

    @Override
    public Vertex2D getCenter() {
        return this.center;
    }
    
    @Override
    public double getRadius() {
        return this.radius;
    }
    
    @Override
    public String toString() {
        return "Circle: center=" + center + ", radius=" + radius;
    }
    
    @Override
    public double getWidth() {
        return this.radius * 2;
    }
    
    @Override
    public double getHeight() {
        return this.getWidth();
    }
}
