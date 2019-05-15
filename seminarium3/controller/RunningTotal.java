/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.controller;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.seminarium3.dbhandler.ItemForSale;
import se.kth.iv1350.seminarium3.view.RevenueObserver;

/**
 *
 * @author Henri
 */
public class RunningTotal {
    private float runningTotal = 0;
    private List<RevenueObserver> revenueObservers = new ArrayList<>();
    
    public void getRunningTotal(ItemForSale[] itemregistry, int itemIdentifier){  
        runningTotal += itemregistry[itemIdentifier].getPrice() * 1.12;
        notifyObservers(runningTotal);
    }
    
    public void addRevenueObserver(RevenueObserver observer){
        revenueObservers.add(observer);
    }
    
    
    public void notifyObservers(float runningTotal) {
        for(RevenueObserver observer : revenueObservers){
            observer.newRunningTotal(runningTotal);
        }
    }
}

