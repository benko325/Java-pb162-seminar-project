/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Class for making Square objects with Vertex2D center and double diameter.
 * 
 * @author Benjamin Havlik
 */
public class Square implements Circular {
    private Vertex2D center;
    private double diameter;
    
    /**
     * Constructor of a Square objects which takes 2 arguments - center and diameter.
     * 
     * @param center    defines the center of a square
     * @param diameter  defines the value of a diameter
     */
    public Square(Vertex2D center, double diameter) {
        this.center = center;
        this.diameter = diameter;
    }
    
    /**
     * Constructor of a Square objects which takes 1 argument of a Circular type.
     * 
     * @param circular  will be used to define square's center and diameter
     */
    public Square(Circular circular) {
        this(circular.getCenter(), circular.getRadius() * 2);
    }
    
    @Override
    public Vertex2D getCenter() {
        return this.center;
    }
    
    @Override
    public double getRadius() {
        return this.diameter / 2;
    }
    
    /**
     * Returns the coordinates of the index-th vertex.
     * 
     * @param index defines the index of a concrete vertex
     * @return      null if the index is invalid, else required vertex
     */
    public Vertex2D getVertex(int index) {
        if (index < 0 || index > 3) {
            return null;
        }
        
        switch (index) {
            case 0:
                return new Vertex2D(this.center.getX() - this.getRadius(), 
                        this.center.getY());
            case 1:
                return new Vertex2D(this.center.getX(), 
                        this.center.getY() - this.getRadius());
            case 2:
                return new Vertex2D(this.center.getX() + this.getRadius(), 
                        this.center.getY());
            case 3:
                return new Vertex2D(this.center.getX(), 
                        this.center.getY() + this.getRadius());
            default:
                return null;
        }
    }
    
    @Override
    public String toString() {
        return "Square: vertices=" + this.getVertex(0) + " " + this.getVertex(1) + 
                " " + this.getVertex(2) + " " + this.getVertex(3);
    }
}
