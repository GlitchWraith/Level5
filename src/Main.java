/**
 * @author harvey
 */
public class Main {
    
    private static boolean metaFlag = false , noFile = false , remove = false , replace = false;
    private static int  hashMeth = 1 ; 
    public static String FilePath ="" ,HashOutput = "",Type =""; 
    
    /**
     * Main function takes in the arguments and then interprets the parts 
     * to set off the required objects 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
      if ( args.length < 1){
            System.out.print("No Arguments have been Set\nArguments are:\n\t-h1,-h2,-h3\tThese dectermin which hash is used" 
                             + "\n\t Path of the file or directory\n\t-meta\tOnly Hashes the metadata of a directory");
        }else{
            try{
                for ( int i = 0 ; i < args.length; i++){
//                    System.out.println(args[i]);
                    flagCheck(args[i]);
                    if ( FileHandling.Exsists(args[i])){
                        FilePath = args[i];
                    } 
                }
            }catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Something Messed up -> " + e);
            }
            
            //      Producing the hash

            HashChecker Hasher;

            switch (hashMeth) {
                case 2:
                    Hasher = new HashType2();
                    break;
                case 3:
                   Hasher = new HashType3();
                    break;
                default:
                    Hasher = new HashType1();
                    break;
            }
            
            // Deciding which hashing function is needed to run;
            if ( FileHandling.directory(FilePath) && metaFlag == true){
                HashOutput = Hasher.produceDirMetaHash(FilePath);
                Type = "Directory (meta)";
            }else if(FileHandling.directory(FilePath)){
                HashOutput = Hasher.produceDirHash(FilePath);
                Type = "Directory";
            }else if(FileHandling.fileExsists(FilePath)){
                HashOutput = Hasher.produceFileHash(FilePath);
                Type = "File";
            }else{
                System.out.println("Path not usable " +FileHandling.directory(FilePath) +" " 
                        +FileHandling.fileExsists(FilePath)
                        +"\n Path->" + FilePath);
            }           
            
            System.out.println( Type + " \"" + FilePath + "\" Hash: " + HashOutput);
            
            HashDataManagement PastHashes = new DataManagement("Data.dat",hashMeth);
            
            if(PastHashes.validateHash(FilePath, HashOutput) && remove == false && replace == false){
                if( PastHashes.validateHash(FilePath, HashOutput)){
                    System.out.println("Result: File contents have been not changed");
                }else{
                    System.out.println("Result: Warning – file contents have been changed");
                }
            }else{
                if ( remove ){
                    PastHashes.removeDetails(FilePath);
                    System.out.println("Result: Entry removed from data file");
                }else
                if ( replace ){
                    PastHashes.replaceHashDetails(FilePath, HashOutput);
                    System.out.println("Result: Entry replaced within data file");
                }else
                if (noFile ==false ){
                    PastHashes.addHashDetails(FilePath, HashOutput);
                    System.out.println("Result: new entry added to data file");
                }
            }
            PastHashes.flushDataToDisk();
       }
      
    }
     /**
      * Takes the input runs some normalisation and sets the corresponding flag
      * @param Input 
      */
    private static void flagCheck(String Input){
        Input = Input.toLowerCase();
        switch (Input) {
            case "-meta" :
                metaFlag = true;
                break;
            case "-nofile":
                noFile = true;
                break;
            case "-h1":
                hashMeth = 1 ;
                break;
            case "-h2":
                hashMeth = 2 ;
                break;
            case "-h3":
                hashMeth = 3 ;
                break;
            case "-remove":
                remove = true;
                break;
            case "-replace":
                replace = true;
            
            default:
                break;
        }
    }
    
}
