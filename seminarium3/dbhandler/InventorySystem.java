/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.dbhandler;
import se.kth.iv1350.seminarium3.model.SaleLogDTO;

/**
 *Denna klass lagrar SaleLogDTO.
 * @author Henri
 */
public class InventorySystem { 
    private SaleLogDTO saleLogDTO;
/**
 * Konstruktorn till klassen SaleLogDTO.
 */    
    public InventorySystem(){ 
    }
/**
 * Denna metod kopierar parametern som är en SaleLogDTO till klassens privata SaleLogDTO variabel
 * @param saleLogDTO 
 */    
    public void setLog(SaleLogDTO saleLogDTO) 
    {
        this.saleLogDTO = saleLogDTO;
    }
}
