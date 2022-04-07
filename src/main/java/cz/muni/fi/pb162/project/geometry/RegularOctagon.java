/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Class for making a special type of a regular polygon - octagon.
 * 
 * @author Benjamin Havlik
 */
public class RegularOctagon extends GeneralRegularPolygon {
    
    /**
     * Constructor of a RegularOctagon objects.
     * 
     * @param center is a Vertex2D center of an octagon
     * @param radius is a radius of an octagon 
     */
    public RegularOctagon(Vertex2D center, double radius) {
        super(center, 8, radius);
    }
}
