/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.comparator;
import cz.muni.fi.pb162.project.geometry.Vertex2D;
import java.util.Comparator;

/**
 * Comparator for Vertex2D class, which sort vertices by descending.
 * 
 * @author Benjamin Havlik
 */
public class VertexInverseComparator implements Comparator<Vertex2D> {
    
    @Override
    public int compare(Vertex2D v1, Vertex2D v2) {
        return -1 * v1.compareTo(v2);
        //other option:
        //return v2.compareTo(v1);
    }
}
