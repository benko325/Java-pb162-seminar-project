/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.utils;
import cz.muni.fi.pb162.project.geometry.Triangle;
import cz.muni.fi.pb162.project.geometry.Measurable;

/**
 * Class which allows us to "measure" objects and print information about their height and width.
 * 
 * @author Benjamin Havlik
 */
public class Gauger {
    
    /**
     * Method takes Triangle object and prints info about it (from toString() method) 
     * and its height and width.
     * 
     * @param triangle is a Triangle object and info about this object will be printed
     */
    public static void printMeasurement(Triangle triangle) {
        System.out.println(triangle);
        printMeasurement((Measurable) triangle);
    }
    
    /**
     * Method takes any measurable object and prints info about its height and width.
     * 
     * @param measurable is an object which implements Measurable interface and info about this object will be printed
     */
    public static void printMeasurement(Measurable measurable) {
        System.out.println("Width: " + measurable.getWidth());
        System.out.println("Height: " + measurable.getHeight());
    }   
}
