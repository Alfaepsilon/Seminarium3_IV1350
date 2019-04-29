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
public class ItemForSale {
    private int itemIdentifier;
    private String itemName;
    private int VAT_rate;
    private int price;
    
    public ItemForSale(int itemIdentifier, String itemName, int VAT_rate, int price){
        this.itemIdentifier = itemIdentifier;
        this.itemName = itemName;
        this.VAT_rate = VAT_rate;
        this.price = price;
    }
    
    public int getItemIdentifier(){
        return this.itemIdentifier;
    }
    
    public String getItemName(){
        return this.itemName;
    }
    
    public int getVAT_rate(){
        return this.VAT_rate;
    }
    
    public int getPrice(){
        return this.price;
    }
    
    public ItemForSale(int itemIdentifier){
        this.itemIdentifier = itemIdentifier;
    }
    
    public ItemForSale[] getItems(){
         ItemForSale[] itemregistry = new ItemForSale[]{new ItemForSale(0,"banana",12, 50), new ItemForSale(1 ,"apple", 12, 30), new ItemForSale(2, "kiwi", 12, 25), new ItemForSale(3, "strawberry", 12, 5)};
         return itemregistry;
    }
    
    public boolean checkItemStatus(int itemIdentifier){
        if (itemIdentifier == getItemIdentifier()){
            return true;
        }
        else {
            return false;
        }
    }
}
