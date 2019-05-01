/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.dbhandler;
import se.kth.iv1350.seminarium3.model.SaleLogDTO;
import se.kth.iv1350.seminarium3.dbhandler.ItemForSale;

/**
 *
 * @author Henri
 */
public class AccountingSystem { //Denna klass hanterar alla uträkningar (mesta del av dem). 
    private SaleLogDTO saleLogDTO;
    private float runningTotal = 0;
    private float change = 0;
    public AccountingSystem(){ //Konstruktorn till klassen AccountingSystem. 
    }
    public void setLog(SaleLogDTO saleLogDTO) //Lagrar 
    {
        this.saleLogDTO = saleLogDTO;
    }
    public float getRunningTotal(ItemForSale[] itemregistry, int itemIdentifier){ //Räknar ut "running total", och returnerar sedan "running total". Metoden erhåller inparametrarna itemregistry och itemIdentifier. 
        runningTotal += itemregistry[itemIdentifier].getPrice() * 1.12;
        return runningTotal;
    }
    
    public float getChange(float amountPaid, float runningTotal){ //Denna metod beräknar växeln och returnerar sedan den. Metoden erhåller inparametrarna amountPaid och runningTotal. 
        change = amountPaid - runningTotal;
        return change;
    }
}
