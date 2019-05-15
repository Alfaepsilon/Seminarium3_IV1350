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
import se.kth.iv1350.seminarium3.observer.RunningTotal;
import se.kth.iv1350.seminarium3.view.TotalRevenueView;
import se.kth.iv1350.seminarium3.dbhandler.NoItemDescriptionException;
import se.kth.iv1350.seminarium3.controller.OperationFailedException;
import se.kth.iv1350.seminarium3.dbhandler.NoDatabaseException;
import java.lang.Exception;
/**
 *Den klass som delar upp alla "requests" till rätt funktioner.
 * @author Henri
 */
public class Controller { 
    private Store store;
    private PointOfSale POS;
    private Printer printer;
    private RunningTotal runningTotal;
    private InventorySystem inventorysystem;
    private AccountingSystem accountingsystem;
    private SaleLogDTO saleLogDTO;
    private float amountPaid = 0;
    private int[] quantity = {0, 0, 0, 0};
    private float amountInRegister = 0;
    private float change = 0;
    AccountingSystem acct = new AccountingSystem();
    
    /**
     * Konstruktorn till Controller
     * @param store
     * @param POS
     * @param invt
     * @param acct
     * @param printer 
     * @param runningTotal
     */
    public Controller(Store store, PointOfSale POS, InventorySystem invt, AccountingSystem acct, Printer printer, RunningTotal runningTotal){
        this.store = store;
        this.POS = POS;
        this.printer = printer;
        this.inventorysystem = invt;
        this.accountingsystem = acct;
        this.runningTotal = runningTotal;
    }
    /**
     * Denna metod returnerar en string som berättar i vilken affär köpet inträffar i.
     * @param store
     * @param POS
     * @return <code> "New sale started in: " + store.getStoreInformation()</code>
     */
    public String newSale(Store store, PointOfSale POS){ 
        return "New sale started in: " + store.getStoreInformation();
    }
    /**
     * Denna metod kollar om den givna "item identifier" är giltig, om den är det lägger vi till en av varan som matchar "item identifier". 
     * Därefter beräknar vi "running total" samt returnerar all namn, pris och pris + vat av varan.
     * @param itemIdentifier
     * @return <code> itemregistry[itemIdentifier].getItemName() + " Price: " + itemregistry[itemIdentifier].getPrice()
     *           + " Running Price: " + runningTotal</code>
     * @throws OperationFailedException to the View layer if item identifier was not found OR if NoDatabaseException was thrown.
     */
    public String scanItem(int itemIdentifier) throws OperationFailedException {
        try{
        boolean itemStatus = ItemForSale.checkItemStatus(itemIdentifier); 
        if(itemStatus)
        {
            quantity[itemIdentifier]++;
        }
        ItemForSale[] itemregistry = getItems();
        //runningTotal.updateRunningTotal(itemregistry, itemIdentifier);
        runningTotal.getRunningTotal(itemregistry, itemIdentifier);
        //runningTotal = RunningTotal.getRunningTotal(itemregistry, itemIdentifier);
        return itemregistry[itemIdentifier].getItemName() + " Price: " + itemregistry[itemIdentifier].getPrice();
        }
        catch(NoItemDescriptionException a){
            throw new OperationFailedException("No item identifier found", a);
        }
        catch(NoDatabaseException b){
            throw new OperationFailedException("No database found", b);
        }
    }
    /**
     * Denna metod tar en "time-stamp", räknar ut växeln och skickar all information till en saleLogDTO. Metoden erhåller inparametrarna store och POS.
     * @param store
     * @param POS 
     */
    public void logCompletedSale(Store store, PointOfSale POS) 
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        //change = acct.getChange(amountPaid, runningTotal);
        String time = formatter.format(date);
        //saleLogDTO = new SaleLogDTO(runningTotal, "Crowns", "Cash", change, quantity, POS, time, store);
    }
    /**
     * Denna metod skickar all information om "sale" till InventorySystem samt AccountingSystem.
     */
    public void sendSaleInformation() 
    {
        inventorysystem.setLog(saleLogDTO);
        accountingsystem.setLog(saleLogDTO);
    }
    /**
     * Denna metod returnerar "running total".
     * @return <code>runningTotal</code>
     */
    public void getTotal() 
    {
        //return runningTotal;
        return;
    }
    /**
     * Denna metod lägger in det kunden betalat in i kassasystemet
     * @param paid 
     */
    public void setPaid(float paid) 
    {
        amountPaid = paid;
        amountInRegister += amountPaid;
    }
    /**
     * Denna metod returnerar all väsentlig information som behövs för att skriva ut kvittot.
     * @param store
     * @return <code>receipt.print()</code>
     */
    public String printReceipt(Store store){ 
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date(); 
        //Receipt receipt = new Receipt(formatter.format(date), store, runningTotal, quantity, amountPaid, change);
      //  return receipt.print();
        return "HEJ";
    }
    
    public void sendObserverObjekt(TotalRevenueView revenueView){
        runningTotal.addRevenueObserver(revenueView);
    }
}
