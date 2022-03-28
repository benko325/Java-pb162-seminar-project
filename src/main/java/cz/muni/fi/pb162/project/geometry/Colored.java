/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Interface for objects that can have a color.
 * 
 * @author Benjamin Havlik
 */
public interface Colored {
    /**
     * Returns object's color.
     * 
     * @return color of a Colored object 
     */
    Color getColor();
    
    /**
     * Change object's color.
     * 
     * @param color will be the new color of the object
     */
    void setColor(Color color);
}
