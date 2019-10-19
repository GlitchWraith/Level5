/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Harvey
 */
public interface HashDataManagement {
    //void loadDataFile();   // called to load the contents of the data file
    //void saveDataFile();   // called to save the contents of the data file
    void loadData();
    void flushDataToDisk();
    void addHashDetails(String fileName, String newHash/*,String Type, String Function*/);
    void replaceHashDetails(String fileName, String newHash);
    void removeDetails(String fileName);
    boolean validateHash(String fileName, String hash);
    boolean fileHashed(String fileName);
//    byte[] readFileContent(String pathName);
//    boolean fileExsists(String fileName)
}
