/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * I'll Be honest whilst it passes tests thats because i haven't fully don't it
 * TLDR improper paseing ment the junit testing was rusheda and this classes testing has not been dont properly;
 * @author Harvey
 */
public class DataManagementTest {
    
    public DataManagementTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of addHashDetails method, of class DataManagement.
     */
    @Test
    public void testAddHashDetails() {
        System.out.println("addHashDetails");
        String fileName = "";
        String newHash = "";
        DataManagement instance = new DataManagement("DataTest.dat",1);
        instance.addHashDetails(fileName, newHash);
        
    }

    /**
     * Test of replaceHashDetails method, of class DataManagement.
     */
    @Test
    public void testReplaceHashDetails() {
        System.out.println("replaceHashDetails");
        String fileName = "";
        String newHash = "";
        DataManagement instance = new DataManagement("DataTest.dat",1);
        instance.replaceHashDetails(fileName, newHash);
        
    }

    /**
     * Test of removeDetails method, of class DataManagement. fails
     */
    @Test
    public void testRemoveDetails() {
        System.out.println("removeDetails");
        String fileName = "Line1";
        DataManagement instance = new DataManagement("DataTest.dat",1);
        instance.removeDetails(fileName);
        
       assertEquals(instance.Data[0] , null );
    }

    /**
     * Test of loadData method, of class DataManagement.
     */
    @Test
    public void testLoadData() {
        System.out.println("loadData");
        DataManagement instance = new DataManagement("DataTest.dat",2);
        instance.loadData();
        String expResult = "Line2";
        assertEquals(expResult ,instance.Data[1] );
      
    }

    /**
     * Test of flushDataToDisk method, of class DataManagement.
     */
    @Test
    public void testFlushDataToDisk() {
        System.out.println("flushDataToDisk");
        DataManagement instance = new DataManagement("DataTest.dat",1);
        instance.flushDataToDisk();
    
    }

    /**
     * Test of validateHash method, of class DataManagement.
     */
    @Test
    public void testValidateHash() {
        System.out.println("validateHash");
        String fileName = "";
        String hash = "";
        DataManagement instance = new DataManagement("DataTest.dat",1);
        boolean expResult = false;
        boolean result = instance.validateHash(fileName, hash);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of fileHashed method, of class DataManagement.
     */
    @Test
    public void testFileHashed() {
        System.out.println("fileHashed");
        String fileName = "IsnotHere";
        DataManagement instance = new DataManagement("DataTest.dat",1);
        boolean expResult = false;
        boolean result = instance.fileHashed(fileName);
        assertEquals(expResult, result);
   
    }
    
}
