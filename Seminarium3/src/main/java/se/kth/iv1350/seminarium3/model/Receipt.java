/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.model;

import se.kth.iv1350.seminarium3.model.PurchaseTime;
import se.kth.iv1350.seminarium3.dbhandler.Store;
import se.kth.iv1350.seminarium3.model.ItemsRegisteredForPurchase;
/**
 *
 * @author Henri
 */
public class Receipt { //Klassen som innehåller allt som skall visas på kvittot.
    private String timeOfPurchase;
    private Store store;
    private float totalPrice;
    private int[] registeredItems;
    private float amountPaidTotal;
    private float change;
    
    public Receipt(String timeOfPurchase, Store store, float totalPrice, int[] registeredItems, float amountPaidTotal, float change){ //Konstruktorn till klassen Receipt. 
        this.amountPaidTotal = amountPaidTotal;
        this.change = change;
        this.registeredItems = registeredItems;
        this.store = store;
        this.timeOfPurchase = timeOfPurchase;
        this.totalPrice = totalPrice;
    }
    
    public String print() //Denna metod returnerar allt som skall skrivas ut på skärmen när kvittot skrivs ut. 
    {
        return "Thank you for shopping \n" + timeOfPurchase + "\n" + store.getStoreInformation() + "\n" + 
                "Total Price: " + totalPrice + "\n" + registeredItems[0] + " bananas " + registeredItems[1] + 
                " apples " + registeredItems[2] + " kiwis " + registeredItems[3] + " strawberries \n" + 
                "Amount Paid: " + amountPaidTotal + " \n" + "Change: " + change;
    }
    
}
