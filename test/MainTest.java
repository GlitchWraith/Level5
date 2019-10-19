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
public class MainTest {
    
    public MainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = new String[] { "-h3","C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testfile1"};
        Main.main(args);
        String  Type = Main.Type;
        String Hash = Main.HashOutput;
        String  Path = Main.FilePath;
        String expResult ="ALkDuicdiOiQ";
        assertEquals(expResult, Hash);
    }
   /* public void testMain_1() {
        System.out.println("main2");
        String[] args = new String[] { "-h3","C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testfile1"};
        Main.main(args);
        String  Type = Main.Type;
        String Hash = Main.HashOutput;
        String  Path = Main.FilePath;
        String expResult ="File";
        assertEquals(expResult, Type);
    }
    public void testMain_2() {
        System.out.println("main3");
        String[] args = new String[] { "-h3","C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testfile1"};
        Main.main(args);
        String  Type = Main.Type;
        String Hash = Main.HashOutput;
        String  Path = Main.FilePath;
        String expResult ="File";
        assertEquals(args[1], Path);
    }*/
    
}
