/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.dbhandler;
import java.lang.*;

/**
 *This exception is thrown if the NoItemDescriptionException isn't thrown. This is because there is no database. 
 * @author Henri
 */
public class NoDatabaseException extends Exception {
    public NoDatabaseException(String message){
        super(message);
    }
}
