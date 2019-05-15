/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.model;

/**
 *
 * @author Henri
 */
public class PurchaseTime { //Själva klassen PurchaseTime
    private String dateOfPurchase;
    private String timeOfPurchase;
    
    public PurchaseTime(String dateOfPurchase, String timeOfPurchase){ //Konstruktorn till PurchaseTime
        this.dateOfPurchase = dateOfPurchase;
        this.timeOfPurchase = timeOfPurchase;
    }
}
