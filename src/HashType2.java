import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.math.BigInteger;
/**
 *
 * @author harvey
 */
public class HashType2 implements  HashChecker {
    
    File HashRaw;
       
//    HashType1(String path){
//        
//    }
    HashType2(){
        
    }
    
    /**
     *  Takes a byte array and sums the byte(s)  then mods by a prime ;
     * @param input
     * @return
     */
    protected long Hashsection( byte[] input){
        long total = 0;

        for (byte b : input) {
             total += b ;
        }
        return total % 15487469	 ;
    }

    /**
     *  Takes a file path as a string and reads the comtence 
     *  and returns a hex encoded string
     * @param filename
     * @return
     */
    @Override
    public String produceFileHash(String filename) {
        
        try {
            return Long.toHexString( Hashsection( FileHandling.readFileContent(filename)  ) );
        } catch (IOException ex) {
           System.out.println("Something went wrong with file handling -> " +ex);
           return null;
        }
    }

    /**
     *  Takes a Directory path as a string and reads the files  
     *  and sub-directory's and returns a hex encoded string
     * @param path
     * @return
     */
    @Override
    public String produceDirHash(String path) {
        
        File folder = new File(path);
        BigInteger directoryHash = new BigInteger("0");
        
            for ( File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    
                    directoryHash = directoryHash.add( new BigInteger(produceDirHash(fileEntry.getPath()), 16));
                } else {
                    try {                                            // multiply
                        directoryHash = directoryHash.add( BigInteger.valueOf(Hashsection( FileHandling.readFileContent(fileEntry) ) ));
//                        System.out.println(fileEntry);

                    } catch (IOException ex) {
                        System.out.println("Something went wrong with file handling -> " +ex);

                    }
                }               
            }
         
        return directoryHash.abs().toString(16);
     
    }
    /**
     *  Takes a Directory path as a string and reads the files  
     *  and sub-directory's and returns a hex encoded string
     * @param path
     * @return
     */
    @Override
    public String produceDirMetaHash(String path) {
      File folder = new File(path);
        if ( folder.isDirectory()){
          try {
              BasicFileAttributes atribute = Files.readAttributes(Paths.get(path), BasicFileAttributes.class);
              String Atributes = Long.toHexString(atribute.size() ) + atribute.isDirectory() + atribute.isRegularFile() + atribute.isOther() +atribute.isSymbolicLink() +atribute.lastModifiedTime();
              
//              System.out.println(Atributes);
              byte[] atributesArray = Atributes.getBytes();
              byte[] sizeArray = Long.toString(  (folder.length()+ folder.list().length)*3 ) .getBytes();
              
              ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
              outputStream.write( atributesArray );
              outputStream.write( sizeArray );
              return Long.toHexString(Hashsection(outputStream.toByteArray()));
              
          } catch (Exception ex) {
            
          }
        }
        return null;
        
    }
}
/*
ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
outputStream.write( a );
outputStream.write( b );

byte c[] = outputStream.toByteArray( );

*/