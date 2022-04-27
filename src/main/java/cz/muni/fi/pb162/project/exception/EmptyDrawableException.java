/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.exception;

/**
 * Class that represents checked exception when there is nothing painted on the drawing object.
 * 
 * @author Benjamin Havlik
 */
public class EmptyDrawableException extends Exception {
    
    /**
     * Constructor for EmptyDrawableException objects without parameters.
     * 
     */
    public EmptyDrawableException() {
        super();
    }
    
    /**
     * Constructor for EmptyDrawableException objects with one string parameter (message).
     * 
     * @param s defines error message
     */
    public EmptyDrawableException(String s) {
        super(s);
    }
    
    /**
     * Constructor for EmptyDrawableException objects with two parameters - message and cause.
     * 
     * @param s     defines error message
     * @param cause defines cause of this exception
     */
    public EmptyDrawableException(String s, Throwable cause) {
        super(s, cause);
    }
}
