/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.view;

/**
 *
 * @author Henri
 */
public class TotalRevenueView implements RevenueObserver {
    @Override
    public void newRunningTotal(float runningTotal){
        printCurrentState(runningTotal);
    }
    
    private void printCurrentState(float runningTotal){
        System.out.println("The current running price is: ");
        System.out.println(runningTotal);
    }
}
