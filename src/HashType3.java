import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.math.BigInteger;
import java.util.Base64;
/**
 *  
 * @author harvey
 */
public class HashType3 implements  HashChecker {
    
    File HashRaw;
      
//    HashType1(String path){
//        
//    }
    HashType3(){
        
    }
    
    /**
     *  Takes a byte array adds the bytes togeter based on there postion in the file 
     *  then does some maths with thoese numbers
     * @param input
     * @return
     */
    protected BigInteger Hashsection( byte[] input){
         BigInteger BaseSize = new BigInteger("1000000");
         
         
        long s1 = 0 ,s2 =0,s3 =0,s4 =0 ,s5 = 0,s6 = 0, s7=0;
            for (int i = 0 ; i < input.length  ; i++) {
                
                    if ( (i % 5) == 0){
                        s1 += input[i] *2657 *input[Math.abs(i-4)];
                    }else if ( (i % 8) == 0){
                        s2 += input[i] *4271;
                    }else if ( (i % 12) == 0){
                        s3 += input[i] *8699;
                    }else if ( (i % 41) == 0){
                        s4 += input[i] * 105727 * input[Math.abs(i-1)];
                    }else {
                        s5 += input[i] *149;
                    }
                    s7 += input[i] * 1223;
                
            }
            
            s6 = s1 * s5;
            s4 += s5;
            s1 = Math.abs(s1 -s2) ;
            
            
            BaseSize = BaseSize.multiply(BigInteger.valueOf(s7));
            BaseSize =BaseSize.add(BigInteger.valueOf(s4));
            BaseSize = BaseSize.mod(new BigInteger("105943"));             
            BaseSize =BaseSize.mod(BigInteger.valueOf(s2).abs());
            BaseSize =BaseSize.multiply(BigInteger.valueOf(s1));
            BaseSize= BaseSize.add( BigInteger.valueOf(s3));
            BaseSize=BaseSize.add( BigInteger.valueOf(s4));
            BaseSize=BaseSize.multiply( BigInteger.valueOf(s5).abs());
            BaseSize=BaseSize.add( BigInteger.valueOf(s6));
            
        return BaseSize.abs();
    }

    /**
     *  Takes a file path as a string and reads the comtence 
     *  and returns a Base64 encoded string
     * @param filename
     * @return
     */
    @Override
    public String produceFileHash(String filename) {
        
        try {
            return  Base64.getEncoder().encodeToString(Hashsection( FileHandling.readFileContent(filename)  ).toByteArray()) ;
        } catch (IOException ex) {
           System.out.println("Something went wrong with file handling -> " +ex);
           return null;
        }
    }

    /**
     *  Takes a Directory path as a string and reads the files  
     *  and sub-directory's and returns a Base64 encoded string
     * @param path
     * @return
     */
    @Override
    public String produceDirHash(String path) {
        
        File folder = new File(path);
        BigInteger directoryHash = new BigInteger("0");
        
            for ( File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    
                    directoryHash = directoryHash.add( new BigInteger(Base64.getDecoder().decode(produceDirHash(fileEntry.getPath()))));
                } else {
                    try {                                            // multiply
                        directoryHash = directoryHash.add( Hashsection( FileHandling.readFileContent(fileEntry) ) );
//                        System.out.println(fileEntry);

                    } catch (IOException ex) {
                        System.out.println("Something went wrong with file handling -> " +ex);

                    }
                }               
            }
         
        return Base64.getEncoder().encodeToString(directoryHash.toByteArray());
     
    }
    /**
     *  Takes a Directory path as a string and reads the files  
     *  and sub-directory's and returns a Base64 encoded string
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
              return Base64.getEncoder().encodeToString(Hashsection( outputStream.toByteArray()  ).toByteArray());
              
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