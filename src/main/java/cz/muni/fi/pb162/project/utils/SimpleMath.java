/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.utils;
import cz.muni.fi.pb162.project.geometry.Polygon;

/**
 * Class with simple mathematics methods used to work with Polygon objects.
 * 
 * @author Benjamin Havlik
 */
public class SimpleMath {
    
    /**
     * Find and return the minimum X coordinate of a Polygon object.
     * 
     * @param polygon   is a Polygon object, from which we have to find the minimum X coordinate
     * @return          minimum X coordinate of a polygon
     */
    public static double minX(Polygon polygon) {
        double numOfVertices = polygon.getNumVertices();
        double min = polygon.getVertex(0).getX();
        
        for (int i = 0; i < numOfVertices; i++) {
            if (Double.compare(polygon.getVertex(i).getX(), min) < 0) {
                min = polygon.getVertex(i).getX();
            }
        }
        
        return min;
    }
    
    /**
     * Find and return the minimum Y coordinate of a Polygon object.
     * 
     * @param polygon   is a Polygon object, from which we have to find the minimum Y coordinate
     * @return          minimum Y coordinate of a polygon
     */
    public static double minY(Polygon polygon) {
        double numOfVertices = polygon.getNumVertices();
        double min = polygon.getVertex(0).getY();
        
        for (int i = 0; i < numOfVertices; i++) {
            if (Double.compare(polygon.getVertex(i).getY(), min) < 0) {
                min = polygon.getVertex(i).getY();
            }
        }
        
        return min;
    }
    
    /**
     * Find and return the maximum X coordinate of a Polygon object.
     * 
     * @param polygon   is a Polygon object, from which we have to find the maximum X coordinate
     * @return          maximum X coordinate of a polygon
     */
    public static double maxX(Polygon polygon) {
        double numOfVertices = polygon.getNumVertices();
        double max = polygon.getVertex(0).getX();
        
        for (int i = 0; i < numOfVertices; i++) {
            if (Double.compare(polygon.getVertex(i).getX(), max) > 0) {
                max = polygon.getVertex(i).getX();
            }
        }
        
        return max;
    }
    
    /**
     * Find and return the maximum Y coordinate of a Polygon object.
     * 
     * @param polygon   is a Polygon object, from which we have to find the maximum Y coordinate
     * @return          maximum Y coordinate of a polygon
     */
    public static double maxY(Polygon polygon) {
        double numOfVertices = polygon.getNumVertices();
        double max = polygon.getVertex(0).getY();
        
        for (int i = 0; i < numOfVertices; i++) {
            if (Double.compare(polygon.getVertex(i).getY(), max) > 0) {
                max = polygon.getVertex(i).getY();
            }
        }
        
        return max;
    }
}
