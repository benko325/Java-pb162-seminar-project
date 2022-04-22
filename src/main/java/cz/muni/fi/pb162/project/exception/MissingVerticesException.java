/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.muni.fi.pb162.project.exception;

/**
 * Class that represents the unchecked exception when there are not enough vertices in the collection.
 * 
 * @author Benjamin Havlik
 */
public class MissingVerticesException extends RuntimeException {
    
    /**
     * Constructor of a MissingVerticesException objects without parameters.
     * 
     */
    public MissingVerticesException() {
        super();
    }
    
    /**
     * Constructor of a MissingVerticesException objects with one string parameter (message).
     * 
     * @param s defines error message
     */
    public MissingVerticesException(String s) {
        super(s);
    }
    
    /**
     * Constructor of a MissingVerticesException objects with two parameters - message and cause.
     * 
     * @param s     defines error message
     * @param cause defines cause of this exception
     */
    public MissingVerticesException(String s, Throwable cause) {
        super(s, cause);
    }
}
