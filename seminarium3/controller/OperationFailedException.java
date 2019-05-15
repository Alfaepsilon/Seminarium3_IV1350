/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.controller;
import java.lang.Exception;

/**
 *This exception is the exception I have decided to catch in the View layer. It is stated that the user doesn't need information about a database failure etc. And therefore this exception is thrown to the View instead of the 
 * other two. This exception is thrown always, because it represents both NoDatabaseException OR NoItemDescriprionException.
 * @author Henri
 */
public class OperationFailedException extends Exception {
    public OperationFailedException(String message, Exception cause){
    super(message, cause);
}
    
    public OperationFailedException(String message){
    super(message);
}
}
