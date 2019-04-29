/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.view;

import se.kth.iv1350.seminarium3.controller.Controller;
import se.kth.iv1350.seminarium3.dbhandler.ItemForSale;
import se.kth.iv1350.seminarium3.model.Receipt;
import se.kth.iv1350.seminarium3.model.PurchaseTime;
import se.kth.iv1350.seminarium3.dbhandler.Store;
import se.kth.iv1350.seminarium3.dbhandler.PointOfSale;
import se.kth.iv1350.seminarium3.dbhandler.Store;
import java.util.Scanner;
/**
 *
 * @author Henri
 */
public class View {
    private Controller contr;
    
    public View(Controller contr){
        this.contr = contr;
    }
    
    public void initializeNewSale(Store store, PointOfSale POS){
        contr.newSale(store, POS);
    }
    
    public void initializeScanItem(){
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please enter itemIdentifier of item: ");
        int itemIdentifier = myObj.nextInt();
        ItemForSale itemInformation = new ItemForSale(itemIdentifier);
        itemInformation = contr.scanItem(itemIdentifier);
        
    }
    
    public void initializePrintReceipt(Store store){
        //Receipt receipt = new Receipt(timeOfPurchase, store);
    }
}
