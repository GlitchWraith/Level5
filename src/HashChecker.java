/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harvey
 */
public interface HashChecker {
    
    String produceFileHash(String filename);
    
    String produceDirHash(String path);
    
    String  produceDirMetaHash(String path);
    
}
