/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.dbhandler;

/**
 *
 * @author Henri
 */
public class Store { //Denna klass innehåller all information om affären som köpet inträffar i. 
    private String storeAdress;
    private String storeName;
    
    public Store(String storeAdress, String storeName){ //Konstruktorn till klassen Store.
        this.storeAdress = storeAdress;
        this.storeName = storeName;
    }
    public String getStoreInformation(){ //Denna metod returnerar informationen av affären.
        return storeAdress + " " + storeName;
    }
}
