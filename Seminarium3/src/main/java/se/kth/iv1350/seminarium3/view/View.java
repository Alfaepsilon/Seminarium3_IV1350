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
public class View { //Själva vyn. Det är här användaren matar in och visas information.
    private Controller contr;
    
    public View(Controller contr){ //Konstruktorn till klassen View. Erhåller inparametern contr.
        this.contr = contr;
    }
    
    public void initializeNewSale(Store store, PointOfSale POS){ //Den metod som initierar newSale(). Skriver ut det som hämtas från newSale(). Erhåller inparametrarna store och POS. 
        System.out.println(contr.newSale(store, POS));
    }
    
    public void initializeScanItem(){ //Metoden som initialiserar inskanningen av alla varor.
        int input = 0;
        Scanner myObj = new Scanner(System.in);
        while(input != 2)
        {
            System.out.println("Please enter itemIdentifier of item: ");
            int itemIdentifier = myObj.nextInt();
            System.out.println(contr.scanItem(itemIdentifier));
            System.out.println("Input 1 for additional identifiers and 2 to stop");
            input = myObj.nextInt();
        }
        System.out.println("Total price is " + contr.getTotal());
        System.out.println("How much has customer paid?");
        float floatInput = myObj.nextInt();
        contr.setPaid(floatInput);
    }
    
    public void initializeLogCompletedSale(Store store, PointOfSale POS) //Metoden som initialiserar logCompletedSale. Kallar på logCompletedSale(store, POS) i Controller. Erhåller inparametrarna store och POS. 
    {
        contr.logCompletedSale(store, POS);
    }
    
    public void initializeSendSaleInformation() //Metoden som initialiserar sendSaleInformation. Kallar på sendSaleInformation() i Controller.
    {
        contr.sendSaleInformation();
    }
    
    public void initializePrintReceipt(Store store){ //Metoden som initialiserar printReceipt(store). Skriver ut returvärdet av printReceipt(store) på skärmen. Erhåller inparametern store. 
        System.out.println(contr.printReceipt(store));
    }
}
