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
 *
 * @author Henri
 */
public class SaleLogDTO {
    private int amountPaidTotal;
    private String currency;
    private String typeOfPayment;
    private int price;
    private int change;
    private int priceAfterDiscount;
    private QuantityOfOneItem quantity;
    private PointOfSale POS;
    private ItemsRegisteredForPurchase registeredItems;
    private PurchaseTime timeOfPurchase;
    private Store store;
    
    public SaleLogDTO(int amountPaidTotal, String currency, String typeOfPayment, int price, int change, int priceAfterDiscount, QuantityOfOneItem quantity, PointOfSale POS, ItemsRegisteredForPurchase registeredItems, PurchaseTime timeOfPurchase, Store store){
    this.POS = POS;
    this.amountPaidTotal = amountPaidTotal;
    this.change = change;
    this.currency = currency;
    this.price = price;
    this.priceAfterDiscount = priceAfterDiscount;
    this.quantity = quantity;
    this.store = store;
    this.typeOfPayment = typeOfPayment;
    this.registeredItems = registeredItems;
    this.timeOfPurchase = timeOfPurchase;
    }
}
