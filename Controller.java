/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.controller;

import se.kth.iv1350.seminarium3.dbhandler.Store;
import se.kth.iv1350.seminarium3.dbhandler.PointOfSale;
import se.kth.iv1350.seminarium3.model.Printer;
import se.kth.iv1350.seminarium3.dbhandler.InventorySystem;
import se.kth.iv1350.seminarium3.dbhandler.AccountingSystem;
import se.kth.iv1350.seminarium3.dbhandler.ItemForSale;
import se.kth.iv1350.seminarium3.model.ItemsRegisteredForPurchase;
/**
 *
 * @author Henri
 */
public class Controller {
    private Store store;
    private PointOfSale POS;
    private Printer printer;
    private InventorySystem inventorysystem;
    private AccountingSystem accountingsystem;
    
    
    
    public Controller(Store store, PointOfSale POS, InventorySystem invt, AccountingSystem acct, Printer printer){
        this.store = store;
        this.POS = POS;
        this.printer = printer;
        this.inventorysystem = invt;
        this.accountingsystem = acct;
    }
    
    public void newSale(Store store, PointOfSale POS){
        System.out.println("New sale started in: " + store.getStoreInformation());
    }
    
    
    public int totalPricePlusVat(){
        //return ItemsRegisteredForPurchase.calculatePrice();
        return 1;
    }
    
    public ItemForSale scanItem(int itemIdentifier){
        boolean itemStatus = ItemForSale.checkItemStatus(itemIdentifier); 
    }
    
    public void printReceipt(){
        
    }
}
