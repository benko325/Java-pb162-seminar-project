/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

/**
 * Class representing paper, on which can we draw objects.
 * 
 * @author Benjamin Havlik
 */
public class Paper implements Drawable {
    private Set<ColoredPolygon> polygons;
    private Color pencilColor;
    
    /**
     * Constructor of a Paper objects without parameters.
     * 
     */
    public Paper() {
        this.pencilColor = Color.BLACK;
        this.polygons = new HashSet<>();
    }
    
    /**
     * Constructor of a Paper objects with parameter drawable used to copy polygons.
     * 
     * @param drawable is used to copy polygons to actual paper
     */
    public Paper(Drawable drawable) {
        this();
        this.polygons.addAll(drawable.getAllDrawnPolygons());
    }
    
    @Override
    public void changeColor(Color color) {
        this.pencilColor = color;
    }
    
    @Override
    public void drawPolygon(Polygon polygon) {
        if (this.pencilColor == Color.WHITE) {
            return;
        }
        
        this.polygons.add(new ColoredPolygon(polygon, this.pencilColor));
    }
    
    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        this.polygons.remove(polygon);
    }
    
    @Override
    public void eraseAll() {
        this.polygons.removeAll(this.polygons);
    }
    
    @Override
    public Collection<ColoredPolygon> getAllDrawnPolygons() {
        return Collections.unmodifiableSet(this.polygons);
    }
    
    @Override
    public int uniqueVerticesAmount() {
        Set<Vertex2D> vertices = new HashSet<>();
        
        for (ColoredPolygon polygon : this.polygons) {
            for (int i = 0; i < polygon.getPolygon().getNumVertices(); i++) {
                vertices.add(polygon.getPolygon().getVertex(i));
            }
        }
        
        return vertices.size();
    }
}
