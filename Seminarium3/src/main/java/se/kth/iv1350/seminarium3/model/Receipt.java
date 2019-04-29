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
public class Receipt {
    private PurchaseTime timeOfPurchase;
    private Store store;
    private int totalPrice;
    private ItemsRegisteredForPurchase registeredItems;
    private int amountPaidTotal;
    private int change;
    
    public Receipt(PurchaseTime timeOfPurchase, Store store, int totalPrice, ItemsRegisteredForPurchase registeredItems, int amountPaidTotal, int change){
        this.amountPaidTotal = amountPaidTotal;
        this.change = change;
        this.registeredItems = registeredItems;
        this.store = store;
        this.timeOfPurchase = timeOfPurchase;
        this.totalPrice = totalPrice;
    }
    
    
}
