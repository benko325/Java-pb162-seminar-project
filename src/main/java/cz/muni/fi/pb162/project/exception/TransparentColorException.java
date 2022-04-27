/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.exception;

/**
 * Class that represents checked exception when drawing in the same color 
 * on the same background, e.g., white pencil on white paper.
 * 
 * @author Benjamin Havlik
 */
public class TransparentColorException extends Exception {
    
    /**
     * Constructor of a TransparentColorException objects without parameters.
     * 
     */
    public TransparentColorException() {
        super();
    }
    
    /**
     * Constructor of a TransparentColorException objects with one string parameter (message).
     * 
     * @param s defines error message
     */
    public TransparentColorException(String s) {
        super(s);
    }
    
    /**
     * Constructor of a TransparentColorException objects with two parameters - message and cause.
     * 
     * @param s     defines error message
     * @param cause defines cause of this exception
     */
    public TransparentColorException(String s, Throwable cause) {
        super(s, cause);
    }
}
