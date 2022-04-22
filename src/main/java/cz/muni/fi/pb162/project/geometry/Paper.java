/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;
import java.util.Collection;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import cz.muni.fi.pb162.project.exception.EmptyDrawableException;
import cz.muni.fi.pb162.project.exception.MissingVerticesException;
import cz.muni.fi.pb162.project.exception.TransparentColorException;

/**
 * Class representing paper, on which can we draw objects.
 * 
 * @author Benjamin Havlik
 */
public class Paper implements Drawable, PolygonFactory {
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
    public void drawPolygon(Polygon polygon) throws TransparentColorException {
        if (this.pencilColor == Color.WHITE) {
            throw new TransparentColorException("you can not draw anything on white paper with white color");
        }
        
        this.polygons.add(new ColoredPolygon(polygon, this.pencilColor));
    }
    
    @Override
    public void erasePolygon(ColoredPolygon polygon) {
        this.polygons.remove(polygon);
    }
    
    @Override
    public void eraseAll() throws EmptyDrawableException {
        if (this.polygons.isEmpty()) {
            throw new EmptyDrawableException("empty paper can not be erased");
        }
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
    
    @Override
    public Polygon tryToCreatePolygon(List<Vertex2D> vertices) {
        if (vertices == null) {
            throw new NullPointerException("parameter vertices can not be null");
        }
        
        List<Vertex2D> newVertices = new ArrayList<>();
        newVertices.addAll(vertices);
        Polygon polygon;
        
        try {
            polygon = new CollectionPolygon(newVertices);
        } catch(IllegalArgumentException iae) {                      
            for (int i = 0; i < newVertices.size(); i++) {
                if (newVertices.get(i) == null) {
                    newVertices.remove(i);
                }
            }
            
            polygon = new CollectionPolygon(newVertices);
        }
        
        return polygon;
    }
    
    @Override
    public void tryToDrawPolygons(List<List<Vertex2D>> polygons) throws EmptyDrawableException {        
        int counter = 0;
        for (int i = 0; i < polygons.size(); i++) {
            try {
                Polygon polygonToDraw = this.tryToCreatePolygon(polygons.get(i));
                this.drawPolygon(polygonToDraw);
                counter += 1;
            } catch(TransparentColorException tce) {
                this.pencilColor = Color.BLACK;
                if (i == polygons.size() - 1 && counter == 0) {
                    throw new EmptyDrawableException("no polygon was drawn", tce);
                }
            } catch(MissingVerticesException | NullPointerException e) {
                if (i == polygons.size() - 1 && counter == 0) {
                    throw new EmptyDrawableException("no polygon was drawn", e);
                }
            } catch(Exception e) {
                if (i == polygons.size() - 1 && counter == 0) {
                    throw new EmptyDrawableException("no polygon was drawn", e);
                }
                
                throw e;
            }
        }
    }
    
    /**
     * Method, which returns all polygons with defined color.
     * 
     * @param color is used to choose exact polygons
     * @return      all polygons with color defined in parameter "color"  
     */
    public Collection<Polygon> getPolygonsWithColor(Color color) {
        Collection<Polygon> polygonsToReturn;
        polygonsToReturn = this.polygons.stream()
                .filter(p -> p.getColor() == color)
                .map(p -> p.getPolygon())
                .collect(Collectors.toCollection(ArrayList::new));
        
        return polygonsToReturn;
    }
}
