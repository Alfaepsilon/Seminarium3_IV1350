/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.model;

import se.kth.iv1350.seminarium3.dbhandler.QuantityOfOneItem;
import se.kth.iv1350.seminarium3.dbhandler.PointOfSale;
import se.kth.iv1350.seminarium3.model.ItemsRegisteredForPurchase;
import se.kth.iv1350.seminarium3.model.PurchaseTime;
import se.kth.iv1350.seminarium3.dbhandler.Store;
/**
 *Denna klass lagrar all information som skapas i samband med köpet. Detta lagras i en DTO.
 * @author Henri
 */

public class SaleLogDTO {  
    private float amountPaidTotal;
    private String currency;
    private String typeOfPayment;
    private float change;
    private int[] quantity;
    private PointOfSale POS;
    private String timeOfPurchase;
    private Store store;
    /**
     * Konstruktorn till SaleLogDTO.
     * @param amountPaidTotal
     * @param currency
     * @param typeOfPayment
     * @param change
     * @param quantity
     * @param POS
     * @param timeOfPurchase
     * @param store 
     */
    public SaleLogDTO(float amountPaidTotal, String currency, String typeOfPayment, float change, int[] quantity, PointOfSale POS, String timeOfPurchase, Store store){ 
    this.POS = POS;
    this.amountPaidTotal = amountPaidTotal;
    this.change = change;
    this.currency = currency;
    this.quantity = quantity;
    this.store = store;
    this.typeOfPayment = typeOfPayment;
    this.timeOfPurchase = timeOfPurchase;
    }
}
