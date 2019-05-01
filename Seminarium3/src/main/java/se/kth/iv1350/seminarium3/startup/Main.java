/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.startup;

import se.kth.iv1350.seminarium3.controller.Controller;
import se.kth.iv1350.seminarium3.view.View;
import se.kth.iv1350.seminarium3.dbhandler.Store;
import se.kth.iv1350.seminarium3.dbhandler.PointOfSale;
import se.kth.iv1350.seminarium3.model.Printer;
import se.kth.iv1350.seminarium3.dbhandler.InventorySystem;
import se.kth.iv1350.seminarium3.dbhandler.AccountingSystem;

/**
 *
 * @author Henri
 */
public class Main { //Den klass som står för att initialisera hela programmet
    public static void main(String[] args) { //Metoden som initierar allt som behövs för att programmet skall kunna köra. Det är också från här varje system operation börjar. Erhåller inparametern args. 
        Store store = new Store("Ica", "Fjärdsgatan 12");
        PointOfSale POS = new PointOfSale("Avdelning B3");
        InventorySystem invt = new InventorySystem();
        AccountingSystem acct = new AccountingSystem();
        Printer printer = new Printer();
        Controller contr = new Controller(store, POS, invt, acct, printer);
        View view  = new View(contr);
        view.initializeNewSale(store, POS);
        view.initializeScanItem();
        view.initializeLogCompletedSale(store, POS);
        view.initializeSendSaleInformation();
        view.initializePrintReceipt(store);
    }
}
