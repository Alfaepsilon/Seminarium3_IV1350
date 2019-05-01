/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import se.kth.iv1350.seminarium3.dbhandler.Store;
import se.kth.iv1350.seminarium3.dbhandler.PointOfSale;
import se.kth.iv1350.seminarium3.model.Printer;
import se.kth.iv1350.seminarium3.dbhandler.InventorySystem;
import se.kth.iv1350.seminarium3.dbhandler.AccountingSystem;
import se.kth.iv1350.seminarium3.dbhandler.ItemForSale;
import static se.kth.iv1350.seminarium3.dbhandler.ItemForSale.getItems;
import se.kth.iv1350.seminarium3.model.ItemsRegisteredForPurchase;
import se.kth.iv1350.seminarium3.model.Receipt;
import se.kth.iv1350.seminarium3.model.SaleLogDTO;
/**
 *
 * @author Henri
 */
public class Controller { //Den klass som delar upp alla "requests" till rätt funktioner. 
    private Store store;
    private PointOfSale POS;
    private Printer printer;
    private InventorySystem inventorysystem;
    private AccountingSystem accountingsystem;
    private SaleLogDTO saleLogDTO;
    private float runningTotal = 0;
    private float amountPaid = 0;
    private int[] quantity = {0, 0, 0, 0};
    private float amountInRegister = 0;
    private float change = 0;
    AccountingSystem acct = new AccountingSystem();
    
    
    public Controller(Store store, PointOfSale POS, InventorySystem invt, AccountingSystem acct, Printer printer){ //Konstruktorn till Controller. Erhåller inparametrarna store, POS, invt, acct, printer.
        this.store = store;
        this.POS = POS;
        this.printer = printer;
        this.inventorysystem = invt;
        this.accountingsystem = acct;
    }
    
    public String newSale(Store store, PointOfSale POS){ //Denna metod returnerar en string som berättar i vilken affär köpet inträffar i. Erhåller inparametrarna store och POS. 
        return "New sale started in: " + store.getStoreInformation();
    }
    
    public String scanItem(int itemIdentifier){ //Denna metod kollar om den givna "item identifier" är giltig, om den är det lägger vi till en av varan som matchar "item identifier". Därefter beräknar vi "running total" samt returnerar all namn, pris och pris + vat av varan. 
        boolean itemStatus = ItemForSale.checkItemStatus(itemIdentifier); //Metoden erhåller inparametern itemIdentifer. 
        if(itemStatus)
        {
            quantity[itemIdentifier]++;
        }
        ItemForSale[] itemregistry = getItems();
        runningTotal = acct.getRunningTotal(itemregistry, itemIdentifier);
        return itemregistry[itemIdentifier].getItemName() + " Price: " + itemregistry[itemIdentifier].getPrice()
                + " Running Price: " + runningTotal;
    }
    
    public void logCompletedSale(Store store, PointOfSale POS) //Denna metod tar en "time-stamp", räknar ut växeln och skickar all information till en saleLogDTO. Metoden erhåller inparametrarna store och POS.
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        change = acct.getChange(amountPaid, runningTotal);
        String time = formatter.format(date);
        saleLogDTO = new SaleLogDTO(runningTotal, "Crowns", "Cash", change, quantity, POS, time, store);
    }
    
    public void sendSaleInformation() //Denna metod skickar all information om "sale" till InventorySystem samt AccountingSystem.
    {
        inventorysystem.setLog(saleLogDTO);
        accountingsystem.setLog(saleLogDTO);
    }
    
    public float getTotal() //Denna metod returnerar "running total".
    {
        return runningTotal;
    }
    
    public void setPaid(float paid) //Denna metod lägger in det kunden betalat in i kassasystemet. Metoden erhåller inparametern paid.
    {
        amountPaid = paid;
        amountInRegister += amountPaid;
    }
    
    public String printReceipt(Store store){ //Denna metod returnerar all väsentlig information som behövs för att skriva ut kvittot. Metoden erhåller inparametern store. 
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(); 
        Receipt receipt = new Receipt(formatter.format(date), store, runningTotal, quantity, amountPaid, change);
        return receipt.print();
    }
}
