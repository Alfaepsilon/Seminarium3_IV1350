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
import se.kth.iv1350.seminarium3.controller.OperationFailedException;
import java.lang.Exception;
import se.kth.iv1350.seminarium3.view.ErrorMessageHandler;
import se.kth.iv1350.seminarium3.view.TotalRevenueView;
import se.kth.iv1350.seminarium3.observer.RunningTotal;
/**
 *
 * @author Henri
 * 
 * Själva vyn. Det är här användaren matar in och visas information.
 */
public class View { 
    private Controller contr;
    
 /**
  * Konstruktorn till klassen View.
  * @param contr 
  */
    public View(Controller contr){ 
        this.contr = contr;
        //contr.addRevenueObserver(new TotalRevenueView());
    }
    /**
     * Målet med denna metod är att skriva ut information som skall skrivas ut i början av varje nytt köp. 
     * @param store
     * @param POS 
     */
    public void initializeNewSale(Store store, PointOfSale POS){ 
        System.out.println(contr.newSale(store, POS));
    }
    /**
     * Målet med denna metod är att hantera all inmatning och utskrift som sker när varor skannas in. 
     */
    public void initializeScanItem(){ //Metoden som initialiserar inskanningen av alla varor.
        int input = 0;
        Scanner myObj = new Scanner(System.in);
        while(input != 2)
        {
            System.out.println("Please enter itemIdentifier of item: ");
            int itemIdentifier = myObj.nextInt();
            try{
            System.out.println(contr.scanItem(itemIdentifier));
            }
            catch(OperationFailedException c){
                ErrorMessageHandler.showErrorMsg("The operation could not be fullfilled");
                ErrorMessageHandler.showErrorMsg("LOGG: ");
                c.printStackTrace(System.out);
            }
        }
        System.out.println("Input 1 for additional identifiers and 2 to stop");
        input = myObj.nextInt();
        //System.out.println("Total price is " + contr.getTotal());
        System.out.println("How much has customer paid?");
        float floatInput = myObj.nextInt();
        contr.setPaid(floatInput);
    }
    /**
     * Målet med denna metod är att kalla på metoden logCompletedSale
     * @param store
     * @param POS 
     */
    public void initializeLogCompletedSale(Store store, PointOfSale POS) 
    {
        contr.logCompletedSale(store, POS);
    }
    /**
     * Målet med denna metod är att kalla på metoden sendSaleInformation
     */
    public void initializeSendSaleInformation() //Metoden som initialiserar sendSaleInformation. Kallar på sendSaleInformation() i Controller.
    {
        contr.sendSaleInformation();
    }
   /**
    * Målet med denna metod är att skriva ut kvittot. 
    * @param store 
    */
    public void initializePrintReceipt(Store store){ //Metoden som initialiserar printReceipt(store). Skriver ut returvärdet av printReceipt(store) på skärmen. Erhåller inparametern store. 
        System.out.println(contr.printReceipt(store));
    }
}
