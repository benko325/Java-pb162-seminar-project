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
public class Square extends GeneralRegularPolygon {
    
    /**
     * Constructor of a Square objects which takes 2 arguments - center and diameter.
     * 
     * @param center    defines the center of a square
     * @param diameter  defines the value of a diameter
     */
    public Square(Vertex2D center, double diameter) {
        super(center, 4, diameter / 2);
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
    public String toString() {
        return "Square: vertices=" + this.getVertex(0) + " " + this.getVertex(1) + 
                " " + this.getVertex(2) + " " + this.getVertex(3);
    }
}
