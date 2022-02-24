/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Class for making 2D Vertex objects with coordinates x and y.
 * 
 * @author Benjamin Havlik, 514493
 */
public class Vertex2D {
    private double x = 0.0;
    private double y = 0.0;
    
    public double getX() {
        return this.x;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * Get the info about vertex coordinates.
     *
     * @return text output of parameters x and y of vertex in format [x, y]
     */
    
    public String getInfo() {
        return "[" + this.x + ", " + this.y + "]";
    }
    
    /**
     * Get the summary of vertex coordinates.
     *
     * @return summary of coordinates x and y
     */
    
    public double sumCoordinates() {
        return this.x + this.y;
    }
    
    /**
     * Takes another 2D point and shifts the vertex by its coordinates.
     *
     * @param vertex    contains coordinates that will be used to shift original vertex
     */
    
    public void move(Vertex2D vertex) {
        this.x += vertex.x;
        this.y += vertex.y;
        //setX(getX() + vertex.getX());
        //setY(getY() + vertex.getY());
    }
}
