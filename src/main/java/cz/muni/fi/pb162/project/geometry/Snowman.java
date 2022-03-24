/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Class for making Snowman objects, which consist of 3 objects implementing RegularPolygon inrterface.
 * The lowest object is the biggest and the upper parts of the snowman will shrink by reductionFactor.
 * 
 * @author Benjamin Havlik
 */
public class Snowman {
    public static final int NUM_OF_CIRCULARS = 3;
    private static final double DEFAULT_REDUCTION = 0.8;
    private RegularPolygon[] allBalls = new RegularPolygon[NUM_OF_CIRCULARS];
    
    /**
     * Constructor of a Snowman objects.
     * 
     * @param circular1         represents the lower sphere of a snowman
     * @param reductionFactor   is a number by which will the upper parts of the snowman shrink
     */
    public Snowman(RegularPolygon circular1, double reductionFactor) {
        this.allBalls[0] = circular1;
        
        for (int i = 1; i < this.NUM_OF_CIRCULARS; i++) {
            if (reductionFactor > 0 && reductionFactor <= 1) {
                double radius = allBalls[i - 1].getRadius() * reductionFactor;
                Vertex2D center = new Vertex2D(allBalls[i - 1].getCenter().getX(), 
                        allBalls[i - 1].getCenter().getY() + allBalls[i - 1].getRadius() + radius);
                this.allBalls[i] = new GeneralRegularPolygon(center, this.allBalls[i - 1].getNumEdges(), radius);
            } else {
                double radius = allBalls[i - 1].getRadius() * this.DEFAULT_REDUCTION;
                Vertex2D center = new Vertex2D(allBalls[i - 1].getCenter().getX(), 
                        allBalls[i - 1].getCenter().getY() + allBalls[i - 1].getRadius() + radius);
                this.allBalls[i] = new GeneralRegularPolygon(center, this.allBalls[i - 1].getNumEdges(), radius);
            }
        }
    }
    
    /**
     * Get all polygons, from which is snowman made.
     * 
     * @return an array of all "show balls" from the lowest to the highest
     */
    public RegularPolygon[] getBalls() {
        return this.allBalls;
    }
}
