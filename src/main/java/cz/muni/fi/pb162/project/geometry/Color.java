/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package cz.muni.fi.pb162.project.geometry;

/**
 * Enum representing basic colors in the real world.
 * 
 * @author Benjamin Havlik
 */
public enum Color {
    WHITE, RED, GREEN, BLUE, BLACK, YELLOW, ORANGE;
    
    @Override
    public String toString() {
        return this.name().toLowerCase();
        // return super.toString().toLowerCase();
    }
}
