/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.utils;
import cz.muni.fi.pb162.project.geometry.Triangle;

/**
 * Class with simple mathematics methods used to work with Triangle objects.
 * 
 * @author Benjamin Havlik
 */
public class SimpleMath {
    
    /**
     * Find and return the minimum X coordinate of a Triangle object.
     * 
     * @param triangle  is a Triangle object, from which we have to find the minimum X coordinate
     * @return          minimum X coordinate of a triangle
     */
    public static double minX(Triangle triangle) {
        double min = triangle.getVertex(0).getX();
        min = Math.min(min, triangle.getVertex(1).getX());
        min = Math.min(min, triangle.getVertex(2).getX());
        
        return min;
    }
    
    /**
     * Find and return the minimum Y coordinate of a Triangle object.
     * 
     * @param triangle  is a Triangle object, from which we have to find the minimum Y coordinate
     * @return          minimum Y coordinate of a triangle
     */
    public static double minY(Triangle triangle) {
        double min = triangle.getVertex(0).getY();
        min = Math.min(min, triangle.getVertex(1).getY());
        min = Math.min(min, triangle.getVertex(2).getY());
        
        return min;
    }
    
    /**
     * Find and return the maximum X coordinate of a Triangle object.
     * 
     * @param triangle  is a Triangle object, from which we have to find the maximum X coordinate
     * @return          maximum X coordinate of a triangle
     */
    public static double maxX(Triangle triangle) {
        double max = triangle.getVertex(0).getX();
        max = Math.max(max, triangle.getVertex(1).getX());
        max = Math.max(max, triangle.getVertex(2).getX());
        
        return max;
    }
    
    /**
     * Find and return the maximum Y coordinate of a Triangle object.
     * 
     * @param triangle  is a Triangle object, from which we have to find the maximum Y coordinate
     * @return          maximum Y coordinate of a triangle
     */
    public static double maxY(Triangle triangle) {
        double max = triangle.getVertex(0).getY();
        max = Math.max(max, triangle.getVertex(1).getY());
        max = Math.max(max, triangle.getVertex(2).getY());
        
        return max;
    }
}
