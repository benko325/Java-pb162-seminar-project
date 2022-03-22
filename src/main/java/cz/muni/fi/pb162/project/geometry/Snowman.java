/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Class for making Snowman objects, which consist of 1 Circular object and several Circle objects (default 4).
 * The lowest Circular object is the biggest and the upper parts of the snowman will shrink by reductionFactor.
 * 
 * @author Benjamin Havlik
 */
public class Snowman {
    public static final int NUM_OF_CIRCULARS = 4;
    private static final double DEFAULT_REDUCTION = 0.8;
    private Circular[] allBalls = new Circular[NUM_OF_CIRCULARS];
    
    /**
     * Constrictor of a Snowman objects.
     * 
     * @param circular1         represents the lower sphere of a snowman
     * @param reductionFactor   is a number by which will the upper parts of the snowman shrink
     */
    public Snowman(Circular circular1, double reductionFactor) {
        this.allBalls[0] = circular1;
        
        for (int i = 1; i < this.NUM_OF_CIRCULARS; i++) {
            if (reductionFactor > 0 && reductionFactor <= 1) {
                double radius = allBalls[i - 1].getRadius() * reductionFactor;
                Vertex2D center = new Vertex2D(allBalls[i - 1].getCenter().getX(), 
                        allBalls[i - 1].getCenter().getY() + allBalls[i - 1].getRadius() + radius);
                this.allBalls[i] = new Circle(center, radius);
            } else {
                double radius = allBalls[i - 1].getRadius() * this.DEFAULT_REDUCTION;
                Vertex2D center = new Vertex2D(allBalls[i - 1].getCenter().getX(), 
                        allBalls[i - 1].getCenter().getY() + allBalls[i - 1].getRadius() + radius);
                this.allBalls[i] = new Circle(center, radius);
            }
        }
    }
    
    /**
     * Get all balls, from which is snowman made.
     * 
     * @return an array of all "show balls" from the lowest to the highest
     */
    public Circular[] getBalls() {
        return this.allBalls;
    }
}
