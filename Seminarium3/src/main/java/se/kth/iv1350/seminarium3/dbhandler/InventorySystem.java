/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.dbhandler;
import se.kth.iv1350.seminarium3.model.SaleLogDTO;

/**
 *
 * @author Henri
 */
public class InventorySystem { //Denna klass lagrar SaleLogDTO.
    private SaleLogDTO saleLogDTO;
    public InventorySystem(){ //Konstruktorn till klassen SaleLogDTO.
    }
    public void setLog(SaleLogDTO saleLogDTO) //Denna metod lagrar SaleLogDTO.
    {
        this.saleLogDTO = saleLogDTO;
    }
}
