/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.dbhandler;
import se.kth.iv1350.seminarium3.dbhandler.NoItemDescriptionException; //?????????????Skall man skapa ett nytt packet som innehåller exceptions?????
import java.lang.Exception;
import se.kth.iv1350.seminarium3.dbhandler.NoDatabaseException;

/**
 *Denna klassen innehåller alla varor och funktioner för hur man hämtar ut dem (get-funktioner alltså).
 * @author Henri
 */
public class ItemForSale { 
    private int itemIdentifier;
    private String itemName;
    private int VAT_rate;
    private int price;
/**
 * Kontruktorn till klassen ItemForSale. Erhåller inparametratna itemIdentifier, itemName, VAT_rate samt price.
 * @param itemIdentifier
 * @param itemName
 * @param VAT_rate
 * @param price 
 */    
    public ItemForSale(int itemIdentifier, String itemName, int VAT_rate, int price){ 
        this.itemIdentifier = itemIdentifier;
        this.itemName = itemName;
        this.VAT_rate = VAT_rate;
        this.price = price;
    }
/**
 * returnerar itemIdentifier.
 * @return <code>this.itemIdentifier</code>
 */    
    public int getItemIdentifier(){ 
        return this.itemIdentifier;
    }
/**
 * returnerar namnet på varan.
 * @return <code>String getItemName()</code>
 */    
    public String getItemName(){ 
        return this.itemName;
    }
 /**
  * returnerar VAT-rate på varan
  * @return <code>this.VAT_rate</code>
  */   
    public int getVAT_rate(){ 
        return this.VAT_rate;
    }
 /**
  * returnerar priset på varan.
  * @return <code>this.price</code>
  */   
    public int getPrice(){ 
        return this.price;
    }
/**
 * En till konstruktor till ItemForSale.
 * @param itemIdentifier 
 */    
    public ItemForSale(int itemIdentifier){
        this.itemIdentifier = itemIdentifier;
    }
/**
 * Denna metod innehåller alla varor som finns i affären och deras information. Dessa lagras i en array av typen ItemForSale. Metoden returnerar sedan arrayen.
 * @return <code>itemregistry</code> 
 */    
    public static ItemForSale[] getItems(){ 
         ItemForSale[] itemregistry = new ItemForSale[]{new ItemForSale(0,"banana",12, 50), new ItemForSale(1 ,"apple", 12, 30), new ItemForSale(2, "kiwi", 12, 25), new ItemForSale(3, "strawberry", 12, 5)};
         return itemregistry;
    }
/**
 * Denna metod kollar om den inmatade "item identifier" finns, om den gör det returneras <code>true</code>, annars <code>false</code>.
 * @param itemIdentifier
 * @return <code>true</code>
 * @return <code>false</code>
 * @throws NoItemDescriptionException if the entered item identifier did not exist.
 * @throws NoDatabaseException if NoItemDescriptionException were not thrown.
 */    
    public static boolean checkItemStatus(int itemIdentifier) throws NoDatabaseException, NoItemDescriptionException
    {           
                ItemForSale[] itemregistry = getItems();
                if(itemIdentifier > itemregistry.length){
                    throw new NoItemDescriptionException("No item matched the given itemidentifier");
                }
                else {
                    throw new NoDatabaseException("No database found");
                }
                /*
                    for(int i = 0; i < itemregistry.length; i++)
                    {
                        if(itemIdentifier == itemregistry[i].getItemIdentifier())
                        {
                            return true;
                        }
                    } 
                return false;
*/
    }
}
