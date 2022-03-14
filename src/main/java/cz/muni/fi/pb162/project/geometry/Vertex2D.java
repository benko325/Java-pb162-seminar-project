/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Class for making 2D Vertex objects with coordinates x and y.
 * 
 * @author Benjamin Havlik
 */
public class Vertex2D {
    private final double x;
    private final double y;
    
    /**
    * Constructor of a Vertex2D objects.
    * 
    * @param x  first coordinate of a vertex
    * @param y  second coordinate of a vertex
    */
    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return this.x;
    }
    
    public double getY() {
        return this.y;
    }
    
    /**
     * Get the info about vertex coordinates.
     *
     * @return text output of parameters x and y of vertex in format [x, y]
     */
    
    @Override
    public String toString() {
        return "[" + this.x + ", " + this.y + "]";
    }
    
    /**
     * Create a new vertex with coordinates which are in the middle of coordinates of actual vertex and secondVertex.
     *
     * @param secondVertex  is used to calculate the new middle vertex, can not be null
     * @return  new vertex with coordinates in the middle of actual vertex and secondVertex
     */
    
    public Vertex2D createMiddle(Vertex2D secondVertex) {
        
        return new Vertex2D(
                (this.x + secondVertex.x) / 2.0,
                (this.y + secondVertex.y) / 2.0
        );
    }
    
    /**
     * Calculate distance between 2 vertices.
     * 
     * @param secondVertex is used for calculate distance between 2 vertices
     * @return distance between actual vertex and secondVertex
     */
    
    public double distance(Vertex2D secondVertex) {
        if (secondVertex == null) {
            return -1.0;
        }
        
        double distX = (this.getX() - secondVertex.getX()) * (this.getX() - secondVertex.getX());
        double distY = (this.getY() - secondVertex.getY()) * (this.getY() - secondVertex.getY());
        
        double dist = Math.sqrt(distX + distY);
        
        return dist;
    }
}