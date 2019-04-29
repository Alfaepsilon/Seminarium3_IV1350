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
public class Main {
    public static void main(String[] args) {
        Store store = new Store("Ica", "Fjärdsgatan 12");
        PointOfSale POS = new PointOfSale("Avdelning B3");
        AccountingSystem acct = new AccountingSystem();
        InventorySystem invt = new InventorySystem();
        Printer printer = new Printer();
        Controller contr = new Controller(store, POS, invt, acct, printer);
        View view  = new View(contr);
        view.initializeNewSale(store, POS);
        view.initializeScanItem();
        //view.initializeTotalPricePlusVat();
        //view.initializePrintReceipt(store);
        //view.initializeLogCompletedSale(store, POS);
        //view.initializeSendSaleInformation();
    }
}
