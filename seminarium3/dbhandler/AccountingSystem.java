/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.dbhandler;
import se.kth.iv1350.seminarium3.model.SaleLogDTO;
import se.kth.iv1350.seminarium3.dbhandler.ItemForSale;

/**
 *Denna klass hanterar alla uträkningar (mesta del av dem).
 * @author Henri
 */
public class AccountingSystem { 
    private SaleLogDTO saleLogDTO;
    private float runningTotal = 0;
    private float change = 0;
    
/**
 * Konstruktorn till klassen AccountingSystem.
 */    
    public AccountingSystem(){ 
    }
/**
 * Denna metod kopierar parametern som är en SaleLogDTO till klassens privata SaleLogDTO variabel
 * @param saleLogDTO 
 */    
    public void setLog(SaleLogDTO saleLogDTO)
    {
        this.saleLogDTO = saleLogDTO;
    }
/**
 * Räknar ut "running total", och returnerar sedan "running total".
 * @param itemregistry
 * @param itemIdentifier
 * @return <code>runningTotal</code>
 */

/**
 * Denna metod beräknar växeln och returnerar sedan den.
 * @param amountPaid
 * @param runningTotal
 * @return <code>change</code>
 */    
    public float getChange(float amountPaid, float runningTotal){ //Denna metod beräknar växeln och returnerar sedan den. Metoden erhåller inparametrarna amountPaid och runningTotal. 
        change = amountPaid - runningTotal;
        return change;
    }
}
