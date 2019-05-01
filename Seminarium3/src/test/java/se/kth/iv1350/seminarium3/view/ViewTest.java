/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.iv1350.seminarium3.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.seminarium3.dbhandler.PointOfSale;
import se.kth.iv1350.seminarium3.dbhandler.Store;
import se.kth.iv1350.seminarium3.controller.Controller;
import se.kth.iv1350.seminarium3.dbhandler.AccountingSystem;
import se.kth.iv1350.seminarium3.dbhandler.InventorySystem;
import se.kth.iv1350.seminarium3.model.Printer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author Henri
 */
public class ViewTest { //Själva test klassen.
    private View testView;
    ByteArrayOutputStream psudoPrintln;
    PrintStream originalPrintln;

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }
/**
 * Denna metod exekveras innan varje test körs. Målet med koden i denna metod är att lagra output till skärmen i minnet, därefter kan man kontrollera att korrekt data skrivs ut till skärmen. Denna metod baseras på Leif Lindbäcks
 * video om hur man skapar tester för "println". 
 * @throws Exception 
 */
    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception { //Det som händer före varje test.
        Store store = new Store("Ica", "Fjärdsgatan 12");
        PointOfSale POS = new PointOfSale("Avdelning B3");
        InventorySystem invt = new InventorySystem();
        AccountingSystem acct = new AccountingSystem();
        Printer printer = new Printer();
        Controller contr = new Controller(store, POS, invt, acct, printer);
        testView = new View(contr);
        psudoPrintln = new ByteArrayOutputStream();
        PrintStream fromMemToSysOut = new PrintStream(psudoPrintln);
        originalPrintln = System.out;
        System.setOut(fromMemToSysOut);
    }
/**
 * Denna metod körs efter varje test. Målet med koden i denna metod är att återställa allting till hur det var inann testet påbörjades. 
 * @throws Exception 
 */
    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception { //Det som händer efter varje test.
        System.setOut(originalPrintln);
        psudoPrintln = null;
    }

    /**
     * Denna metod testar initializeNewSale(). Vilken skall skriva ut information till skärmen. 
     */
    @org.junit.jupiter.api.Test
    public void testInitializeNewSale(){ //Den metod som testar metoden initializeNewSale().
        Store store = new Store("Ica", "Fjärdsgatan 12");
        PointOfSale POS = new PointOfSale("Avdelning B3");
        testView.initializeNewSale(store, POS);
        String result = psudoPrintln.toString();
        String correctResult = ("New sale started in: ");
        assertTrue(result.contains(correctResult), "Wrong printout for initializeNewSale");
    }

    /**
     * Test of initializeScanItem method, of class View.
     */
    /*
    @org.junit.jupiter.api.Test
    public void testInitializeScanItem() {
        System.out.println("initializeScanItem");
        View instance = null;
        instance.initializeScanItem();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeLogCompletedSale method, of class View.
     */
    /*
    @org.junit.jupiter.api.Test
    public void testInitializeLogCompletedSale() {
        System.out.println("initializeLogCompletedSale");
        Store store = null;
        PointOfSale POS = null;
        View instance = null;
        instance.initializeLogCompletedSale(store, POS);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializeSendSaleInformation method, of class View.
     */
    /*
    @org.junit.jupiter.api.Test
    public void testInitializeSendSaleInformation() {
        System.out.println("initializeSendSaleInformation");
        View instance = null;
        instance.initializeSendSaleInformation();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initializePrintReceipt method, of class View.
     */
    /*
    @org.junit.jupiter.api.Test
    public void testInitializePrintReceipt() {
        System.out.println("initializePrintReceipt");
        Store store = null;
        View instance = null;
        instance.initializePrintReceipt(store);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */
    
}
