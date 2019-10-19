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
public class HashType2Test {
    
    public HashType2Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of Hashsection method, of class HashType2.
     */
    @Test
    public void testHashsection() {
        System.out.println("Hashsection");
        byte[] input = new byte[] { (byte)0xe0, 0x4f, (byte)0xd0,    0x20, (byte)0xea, 0x3a, 0x69, 0x10, (byte)0xa2, (byte)0xd8, 0x08, 0x00, 0x2b,    0x30, 0x30, (byte)0x9d};
        HashType2 instance = new HashType2();
        long expResult = 102L;
        long result = instance.Hashsection(input);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of produceFileHash method, of class HashType2.
     */
    @Test
    public void testProduceFileHash() {
        System.out.println("produceFileHash");
        String filename = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testfile1";
        HashType2 instance = new HashType2();
        String expResult = "21f4";
        String result = instance.produceFileHash(filename);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of produceDirHash method, of class HashType2.
     */
    @Test
    public void testProduceDirHash() {
        System.out.println("produceDirHash");
        String path = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testdir1\\";
        HashType2 instance = new HashType2();
        String expResult = "65df";
        String result = instance.produceDirHash(path);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of produceDirMetaHash method, of class HashType2.
     */
    @Test
    public void testProduceDirMetaHash() {
        System.out.println("produceDirMetaHash");
        String path = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testdir1\\";
        HashType2 instance = new HashType2();
        String expResult = "df1";
        String result = instance.produceDirMetaHash(path);
        assertEquals(expResult, result);
        
    }
    
}
