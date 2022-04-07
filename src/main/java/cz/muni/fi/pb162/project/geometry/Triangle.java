/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Class for making a Triangle objects with 3 vertices stored in an attribute "vertices".
 * 
 * @author Benjamin Havlik
 */
public class Triangle extends ArrayPolygon {
    private final Triangle[] subTriangles = new Triangle[3];
    
    /**
    * Constructor of a Triangle objects.
    * 
    * @param firstVertex    first vertice of a triangle
    * @param secondVertex   second vertice od a triangle
    * @param thirdVertex    third vertice of a triangle
    */
    public Triangle(Vertex2D firstVertex, Vertex2D secondVertex, Vertex2D thirdVertex) {
        super(new Vertex2D[] {firstVertex, secondVertex, thirdVertex});
    }
    
    /**
     * Constructor of a Sierpiński Triangle objects.
     * 
     * @param firstVertex   first vertice of a triangle
     * @param secondVertex  second vertice of a triangle
     * @param thirdVertex   third vertice of a triangle
     * @param depth         specifies the depth of the division of the triangle
     */
    public Triangle(Vertex2D firstVertex, Vertex2D secondVertex, Vertex2D thirdVertex, int depth) {
        this(firstVertex, secondVertex, thirdVertex);
        this.divide(depth);
    }
    
    @Override
    public String toString() {
        
        return "Triangle: vertices=" + this.getVertex(0) + " " + 
                this.getVertex(1) + " " + this.getVertex(2);
    }
    
    /**
     * Check if the triangle was already divided by method divide().
     * 
     * @return true if the triangle was divided, else false
     */
    public boolean isDivided() {
        return this.subTriangles[0] != null;
    }
    
    /**
     * Divide the triangle into the 3 smaller triangles and store those triangles into the parameter subTriangles.
     * 
     * @return true if the division was successful, else false if the triangle was already divided
     */
    public boolean divide() {
        if (this.isDivided()) {
            return false;
        }
        
        this.subTriangles[0] = new Triangle(this.getVertex(0), this.getVertex(0).createMiddle(this.getVertex(1)), 
                this.getVertex(0).createMiddle(this.getVertex(2)));
        this.subTriangles[1] = new Triangle(this.getVertex(1), this.getVertex(1).createMiddle(this.getVertex(0)), 
                this.getVertex(1).createMiddle(this.getVertex(2)));
        this.subTriangles[2] = new Triangle(this.getVertex(2), this.getVertex(2).createMiddle(this.getVertex(0)), 
                this.getVertex(2).createMiddle(this.getVertex(1)));
        
        return true;
    }
    
    /**
     * Divide the triangle into the 3 smaller triangles and store those triangles into the parameter subTriangles.
     * Then, if the depth parameter is greather than 0, it recursively tries to split 
     * the resulting sub-triangles until reaching the requested depth.
     * 
     * @param depth specifies the depth of the division
     */
    public void divide(int depth) {
        if (depth <= 0) {
            return;
        }
        
        this.divide();
        for (int i = 0; i < 3; i++) {
            this.subTriangles[i].divide(depth - 1);
        }
    }
    
    /**
     * Get the subtriangle from parameter subTriangle[index].
     * If the index is less than 0 or greather than length of array subTriangles, returns null.
     * 
     * @param index is used to identify a concrete triangle in subTriangles
     * @return  null if the index is invalid or the triangle was not divided, 
     *          otherwise returns subtriangle at the parameter subTriangles[index]
     */
    public Triangle getSubTriangle(int index) {
        if ((index < 0 || index >= this.subTriangles.length)) {
            return null;
        }
        
        if (!(this.isDivided())) {
            return null;
        }
        
        return this.subTriangles[index];
    }
    
    public static final double TOLERATED_DEVIATION = 0.001;
    
    /**
     * Check if the triangle is equilateral or not.
     * 
     * @return true if the triangle is equilateral, else false
     */
    public boolean isEquilateral() {
        double firstSide = this.getVertex(0).distance(this.getVertex(1));
        double secondSide = this.getVertex(0).distance(this.getVertex(2));
        double thirdSide = this.getVertex(1).distance(this.getVertex(2));
        
        return Math.abs(firstSide - secondSide) < TOLERATED_DEVIATION &&
                Math.abs(firstSide - thirdSide) < TOLERATED_DEVIATION &&
                Math.abs(secondSide - thirdSide) < TOLERATED_DEVIATION; 
    }
}