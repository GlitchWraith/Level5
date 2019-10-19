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
 *
 * @author Harvey
 */
public class HashType1Test {
    
    public HashType1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of Hashsection method, of class HashType1.
     */
    @Test
    public void testHashsection() {
        System.out.println("Hashsection");
        byte[] input = new byte[] { (byte)0xe0, 0x4f, (byte)0xd0,    0x20, (byte)0xea, 0x3a, 0x69, 0x10, (byte)0xa2, (byte)0xd8, 0x08, 0x00, 0x2b,    0x30, 0x30, (byte)0x9d};;
        HashType1 instance = new HashType1();
        long expResult = 11526L;
        long result = instance.Hashsection(input);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of produceFileHash method, of class HashType1.
     */
    @Test
    public void testProduceFileHash() {
        System.out.println("produceFileHash");
        String filename = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testfile1";
        HashType1 instance = new HashType1();
        String expResult = "efcb4";
        String result = instance.produceFileHash(filename);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of produceDirHash method, of class HashType1.
     */
    @Test
    public void testProduceDirHash() {
        System.out.println("produceDirHash");
        String path = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testdir1\\";
        HashType1 instance = new HashType1();
        String expResult = "2cf76f";
        String result = instance.produceDirHash(path);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of produceDirMetaHash method, of class HashType1.
     */
    @Test
    public void testProduceDirMetaHash() {
        System.out.println("produceDirMetaHash");
        String path = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testdir1\\";
        HashType1 instance = new HashType1();
        String expResult = "62761";
        String result = instance.produceDirMetaHash(path);
        assertEquals(expResult, result);
        
    }
    
}
