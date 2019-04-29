/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.dbhandler;

/**
 *
 * @author Henri
 */
public class QuantityOfOneItem {
    private String itemIdentifier;
    private int soldQuantity;
    private int priceForGivenQuantity;
    
    public QuantityOfOneItem(String itemIdentifier, int soldQuantity, int priceForGivenQuantity){
        this.itemIdentifier = itemIdentifier;
        this.priceForGivenQuantity = priceForGivenQuantity;
        this.soldQuantity = soldQuantity;
    }
}
