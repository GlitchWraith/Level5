/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Harvey
 */
public class FileHandlingTest {
    
    public FileHandlingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of readFileContent method, of class FileHandling.
     * Cant get the test to work since dont know the bytes 
     */
    @Test
    public void testReadFileContent_String() throws Exception {
        System.out.println("readFileContent");
        String pathName = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\Small byte";
        byte[] expResult = new byte[] { 0x54,0x65,0x73,0x74,0x20,0x46,0x69,0x6c,0x65};
        byte[] result = FileHandling.readFileContent(pathName);
        System.out.println(result);
        assertArrayEquals(expResult, result);
       
        
    }

    /**
     * Test of readFileContent method, of class FileHandling.
     * Cant get the test to work since dont know the bytes 
     */
    @Test
    public void testReadFileContent_File() throws Exception {
        System.out.println("readFileContent");
        File input = new File("C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\Small byte");
        byte[] expResult = new byte[] { 0x54,0x65,0x73,0x74,0x20,0x46,0x69,0x6c,0x65};
        byte[] result = FileHandling.readFileContent(input);
        assertArrayEquals(expResult, result);
       
    }

    /**
     * Test of fileExsists method, of class FileHandling.
     */
    @Test
    public void testFileExsists() {
        System.out.println("fileExsists");
        String fileName = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testfile1";
        boolean expResult = true;
        boolean result = FileHandling.fileExsists(fileName);
        assertEquals(expResult, result);
     
    }

    /**
     * Test of directory method, of class FileHandling.
     */
    @Test
    public void testDirectory() {
        System.out.println("directory");
        String directoryName = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\";
        boolean expResult = true;
        boolean result = FileHandling.directory(directoryName);
        assertEquals(expResult, result);
    
    }

    /**
     * Test of Exsists method, of class FileHandling.
     */
    @Test
    public void testExsists() {
        System.out.println("Exsists");
        String fileName = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testfile1";
        boolean expResult = true;
        boolean result = FileHandling.Exsists(fileName);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of addStringToFile method, of class FileHandling.
     */
    @Test
    public void testAddStringToFile() {
        System.out.println("addStringToFile");
        String fileName = "";
        String Data = "";
        FileHandling.addStringToFile(fileName, Data);
     
    }

    /**
     * Test of saveStringToFile method, of class FileHandling.
     */
    @Test
    public void testSaveStringToFile() {
        System.out.println("saveStringToFile");
        String File = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\Test.txt";
        String Data = "Hello";
        FileHandling.saveStringToFile(File, Data);
        String[] result = FileHandling.fileByLines("C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\Test.txt");
        //assertArrayEquals(Data, result[0]);
    }

    /**
     * Test of fileByLines method, of class FileHandling.
     */
    @Test
    public void testFileByLines_String_int() {
        System.out.println("fileByLines");
        String pathName = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testfile1";
        int Additional = 1;
        String[] expResult = new String[] { "This is test file 1. It should produce a unique hash compared to files with different content.",null};
        String[] result = FileHandling.fileByLines(pathName, Additional);
        assertArrayEquals(expResult, result);
 
    }

    /**
     * Test of fileByLines method, of class FileHandling.
     */
    @Test
    public void testFileByLines_String() {
        System.out.println("fileByLines");
        String pathName = "C:\\Users\\Harvey\\Documents\\NetBeansProjects\\Year2JavaProject\\SSDtestFiles\\testfile1";
        String[] expResult = new String[] { "This is test file 1. It should produce a unique hash compared to files with different content."};
        String[] result = FileHandling.fileByLines(pathName);
        assertArrayEquals(expResult, result);
      
    }
    
}
