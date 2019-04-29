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
public class ItemsRegisteredForPurchase {
    private ItemForSale itemInformation;
    private int itemAmount = 0;
    public ItemsRegisteredForPurchase(ItemForSale itemInformation){
        this.itemInformation = itemInformation;
    }
    
    public void increment(){
        itemAmount++;
    }
    
    public int calculatePrice(){
        return 1;
    }
}
