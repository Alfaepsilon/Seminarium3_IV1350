/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.model;

import se.kth.iv1350.seminarium3.dbhandler.ItemForSale;
/**
 *
 * @author Henri
 */
public class ItemsRegisteredForPurchase { //Själva klassen ItemsRegisteredForPurchase
    private int itemIdentifier;
    private int itemAmount = 0;
    public ItemsRegisteredForPurchase(int itemIdentifier){ //Konstruktorn till klassen ItemsRegisteredForPurchase. Erhåller itemIdentifier som inparameter. 
        this.itemIdentifier = itemIdentifier;
        increment();
    }
    
    public void increment(){ //Ökar antalet av en vara vi 
        itemAmount++;
    }
    
    public int getAmount()
    {
        return itemAmount;
    }
    
    public void resetAmount()
    {
        itemAmount = 0;
    }
    
    public int getIdentifier()
    {
        return itemIdentifier;
    }
    
    public int calculatePrice(){
        return 1;
    }
}
