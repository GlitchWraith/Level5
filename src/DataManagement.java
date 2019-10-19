/**
 *
 * @author Harvey
 */
public class DataManagement implements HashDataManagement{

    
    String DiskDataLocation ="" ;
    static String hashMethID;
            
    String[] Data;
    
    /**
     *  By default loads data from disk and hash methord used
     * @param Location
     * @param Type 
     */
    DataManagement(String Location, int Type){
        DiskDataLocation = Location;
        loadData();
        switch (Type) {
                case 2:
                    hashMethID = "[@2@]";
                    break;
                case 3:
                   hashMethID = "[@3@]";
                    break;
                default:
                    hashMethID = "[@1@]";
                    break;
            }
//        System.out.println(hashMethID);
//        for (String Data1 : Data) {
//            System.out.println(Data1);
//        }
    }
    /**
     * Adds the file path with its hash to the data store
     * @param fileName
     * @param newHash 
     */
    @Override
    public void addHashDetails(String fileName, String newHash) {
        Data[ Data.length -1 ] = fileName + " | " + newHash+"  " + hashMethID;
//         for (String Data1 : Data) {
//            System.out.println(Data1);
//        }
    }
    /**
     * If the File is in the data store it will replace the hash it has stored with the one in provided
     * @param fileName
     * @param newHash 
     */
    @Override
    public void replaceHashDetails(String fileName, String newHash) {
           for (int i = 0 ; i < Data.length  ; i++) {
            try{
                if ( Data[i].contains(fileName) ){

                    Data[i] = fileName + " | " + newHash +"  " + hashMethID;
                }
             }catch (NullPointerException e){
                 
             }
        }
    }
    /**
     *  Removes a file from data store
     * @param fileName 
     */
    @Override
    public void removeDetails(String fileName) {
        
        for (int i = 0 ; i < Data.length  ; i++) {
            try{
                if ( Data[i].contains(hashMethID) && Data[i].contains(fileName)  ){
                    Data[i] = null;
                }
            }catch(NullPointerException e){
                
            }
        }
    }
    /**
     * Loads the data from the disk refreshing the in memory databank 
     */
    @Override
    public void loadData() {
       Data = FileHandling.fileByLines(DiskDataLocation, 2);
        
    }
    /**
     * Saves the in memory databank to the disk
     */
    @Override
    public void flushDataToDisk() {
        String Temp="";
        for (String Data1 : Data) {
            if ( Data1 == null || Data1.equals("") || Data1.equals(" | ") || Data1.equals(" | null")){
                
            }else{
                Temp += Data1;
                Temp += "\n"  ;
            }
        }
        FileHandling.saveStringToFile(DiskDataLocation, Temp);
//        System.out.print(Temp);
    }
    /**
     * Trys to find the file name part of a data entry 
     * @param input
     * @return 
     */
    private static String fileNameSplit(String input){ 
        return  input.substring(0, input.indexOf("|")-1).trim();
    }
    /*      //   Reduced Function
    private static String hashSplit(String input){        
        return  input.substring( input.indexOf("|")+1 , input.indexOf(hashMethID)-1 ).trim();
        
    }*/
    /**
     * Checks the file name and hash to whats in the databank
     * @param fileName
     * @param hash
     * @return 
     */
    @Override
    public boolean validateHash(String fileName, String hash) {
        
        for (String Data1 : Data) {
            try{
                if ( fileName.equals(fileNameSplit(Data1)) ){
                    if (Data1.contains(hash) && Data1.contains(hashMethID)){
                        return true;
                    }
                }
            }catch(NullPointerException buzkill){

            }
        }
       
        return false;
    }
    
    /**
     * Sees if file is in the databank
     * @param fileName
     * @return
     */
    @Override
    public boolean fileHashed(String fileName) {
        for (String Data1 : Data) {
            try{
                if (Data1.contains(fileName) && Data1.contains(hashMethID)){                
                    return true;     
                }
            }catch (NullPointerException e){} 
            
        }
        return false;
    }
    
}
