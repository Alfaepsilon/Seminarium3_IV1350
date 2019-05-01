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
public class ItemForSale { //Denna klassen innehåller alla varor och funktioner för hur man hämtar ut dem (get-funktioner alltså).
    private int itemIdentifier;
    private String itemName;
    private int VAT_rate;
    private int price;
    
    public ItemForSale(int itemIdentifier, String itemName, int VAT_rate, int price){ //Kontruktorn till klassen ItemForSale. Erhåller inparametratna itemIdentifier, itemName, VAT_rate samt price.
        this.itemIdentifier = itemIdentifier;
        this.itemName = itemName;
        this.VAT_rate = VAT_rate;
        this.price = price;
    }
    
    public int getItemIdentifier(){ //returnerar itemIdentifier.
        return this.itemIdentifier;
    }
    
    public String getItemName(){ //returnerar namnet på varan.
        return this.itemName;
    }
    
    public int getVAT_rate(){ //returnerar VAT-rate på varan
        return this.VAT_rate;
    }
    
    public int getPrice(){ //returnerar priset på varan.
        return this.price;
    }
    
    public ItemForSale(int itemIdentifier){
        this.itemIdentifier = itemIdentifier;
    }
    
    public static ItemForSale[] getItems(){ //Denna metod innehåller alla varor som finns i affären och deras information. Dessa lagras i en array av typen ItemForSale. Metoden returnerar sedan arrayen.
         ItemForSale[] itemregistry = new ItemForSale[]{new ItemForSale(0,"banana",12, 50), new ItemForSale(1 ,"apple", 12, 30), new ItemForSale(2, "kiwi", 12, 25), new ItemForSale(3, "strawberry", 12, 5)};
         return itemregistry;
    }
    
    public static boolean checkItemStatus(int itemIdentifier){ //Denna metod kollar om den inmatade "item identifier" finns, om den gör det returneras true, annars false. Metoden erhåller inparametern itemIdentifier. 
        ItemForSale[] itemregistry = getItems();
        for(int i = 0; i < itemregistry.length; i++)
        {
            if(itemIdentifier == itemregistry[i].getItemIdentifier())
            {
                return true;
            }
        }
        return false;
    }
}
