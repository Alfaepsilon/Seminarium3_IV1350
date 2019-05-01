/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.dbhandler;

/**
 *Denna klass innehåller all information om affären som köpet inträffar i. 
 * @author Henri
 */
public class Store {
    private String storeAdress;
    private String storeName;
/**
 * Konstruktorn till klassen Store.
 * @param storeAdress
 * @param storeName 
 */    
    public Store(String storeAdress, String storeName){
        this.storeAdress = storeAdress;
        this.storeName = storeName;
    }
/**
 * Denna metod returnerar informationen av affären.
 * @return <code> storeAdress + " " + storeName</code>
 */    
    public String getStoreInformation(){ 
        return storeAdress + " " + storeName;
    }
}
