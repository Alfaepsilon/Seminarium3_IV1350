/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.dbhandler;
import java.lang.Exception;

/**
 *This exception will be executed if someone were to enter an item identifier that is not listed in the database. Specifically, if you get an ArrayIndexOutOfBoundsException. However, because we only have dbhandler, Controller 
 * and the View layer to work with, I thought it better if I made this exception execute if the entered item identifier is larger than the length of the item array. 
 * @author Henri
 */
public class NoItemDescriptionException extends Exception {
    
    public NoItemDescriptionException(String message){
        super(message);
    }
    
}
