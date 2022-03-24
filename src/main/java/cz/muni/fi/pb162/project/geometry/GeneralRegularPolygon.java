/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Class for making polygons with Vertex2D center, double radius, different number of edges (int) and a color (enum).
 * 
 * @author Benjamin Havlik
 */
public class GeneralRegularPolygon implements RegularPolygon, Colored {
    private Vertex2D center;
    private int numOfEdges;
    private double radius;
    private Color color;
    
    /**
     * Constructor of a GeneralRegularPolygon objects.
     * 
     * @param center    center of a polygon
     * @param edges     number of edges of a polygon
     * @param radius    radius of a circumscribed circle
     */
    public GeneralRegularPolygon(Vertex2D center, int edges, double radius) {
        this.center = center;
        this.numOfEdges = edges;
        this.radius = radius;
        this.color = Color.BLACK;
    }
    
    @Override
    public int getNumEdges() {
        return this.numOfEdges;
    }
    
    @Override
    public double getEdgeLength(){
        return 2 * this.radius * Math.sin(Math.PI / this.numOfEdges);
    }
    
    @Override
    public Vertex2D getVertex(int index) {
        double x, y;
        x = this.center.getX() - (this.radius * Math.cos(index * 2 * Math.PI / this.numOfEdges));
        y = this.center.getY() - (this.radius * Math.sin(index * 2 * Math.PI / this.numOfEdges));
        
        return new Vertex2D(x, y);
    }

    @Override
    public double getWidth() {
        return 2 * this.radius;
    }

    @Override
    public double getHeight() {
        return this.getWidth();
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
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return this.numOfEdges + "-gon: center=" + this.center + 
                ", radius=" + this.radius + ", color=" + this.color;
    }
}
