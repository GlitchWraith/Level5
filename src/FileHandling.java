import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileHandling {

        /**
         *  Reads a path in the form of a string and returns the entire file as a byte array
         * @param pathName
         * @return
         * @throws IOException
         */
        public static byte[] readFileContent(String pathName) throws IOException {
		
		return Files.readAllBytes(Paths.get(pathName));
	}
        /**
         *  Returns the entire file as a byte array
         * @param input
         * @return
         * @throws IOException
         */
        public static byte[] readFileContent(File input) throws IOException {
		
		return Files.readAllBytes(Paths.get(input.getAbsolutePath()));
	}
        
        /**
         *  Checks if the path it has been given is a file
         * @param fileName
         * @return true or false
         */
        public static boolean fileExsists(String fileName){            
            File f = new File(fileName);           
            return f.exists() && fileName.equalsIgnoreCase("") != true && f.isFile();
        }
        /**
         * Checks if the path it has been given is a directory
         * @param directoryName
         * @return 
         */
        public static boolean directory(String directoryName){
            File f = new File(directoryName);           
            return  f.isDirectory();
        }
        /**
         * Checks if the path it has been given Exsists on disk
         * @param fileName
         * @return 
         */
        public static boolean Exsists(String fileName){            
            File f = new File(fileName);           
            return f.exists() && fileName.equalsIgnoreCase("") != true && ( f.isFile() || f.isDirectory()    );
        }
        /**
         * Adds Data to the end of a given file
         * @param fileName
         * @param Data 
         */
        public static void addStringToFile(String fileName,String Data){
            File arc = new File(fileName);
            try {
                FileWriter fileWriter = new FileWriter(arc,true);
                try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                    bufferedWriter.newLine();
                    bufferedWriter.write(Data);
                }
                fileWriter.close();
            } catch (IOException e1) {
                    
            }
        }
        
        /**
         *  Takes A file location as a string and string and then saves it to a file
         * @param File
         * @param Data 
         */
	public static void saveStringToFile(String File,String Data){
                File file = new File(File);
		try{// Attempting to write the file
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(Data);
			fileWriter.flush();
			fileWriter.close();
                        //System.out.print("\n\tFile Output Finished\n");
		}catch(Exception e){
			System.out.print("\n\tError In File Output\n");
		}
                
	}
        /**
         * Returns an Array of type string of each line of a text file 
         * plus Additional amount of empty entries
         * @param pathName
         * @param Additional
         * @return 
         */
        public static String[] fileByLines(String pathName,int Additional){
            
                try{
                     List<String> fileLines = Files.readAllLines(Paths.get(pathName));
                     String[] fileLinesArray = new String[fileLines.size() + Math.abs(Additional) ];
                     fileLinesArray = fileLines.toArray(fileLinesArray);
                     return fileLinesArray;
                } catch (IOException ex) {
                   
                } 
            
            return new String[ 1 + Math.abs(Additional)];
        }
        /**
         * Returns an Array of type string of each line of a text file 
         * @param pathName
         * @return 
         */
        public static String[] fileByLines(String pathName){
            
                try{
                     List<String> fileLines = Files.readAllLines(Paths.get(pathName));
                     String[] fileLinesArray = new String[fileLines.size()];
                     fileLinesArray = fileLines.toArray(fileLinesArray);
                     return fileLinesArray;
                } catch (IOException ex) {
                    Logger.getLogger(FileHandling.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            return new String[1];
        }
        
        
        
    
	//
        //      OLD Functions Disused / Need To be updated   
        //
        //
//	public static void SaveText(String StuffToSave){
//		
//		try{// Attempting to write the file
//                        File qu = new File("/Scripts/RenameME");
//			FileWriter fileWriter = new FileWriter(qu);
//			fileWriter.write(StuffToSave);
//			fileWriter.flush();
//			fileWriter.close();
//                         System.out.print("\n\tFile Output Finished\n");
//		}catch(Exception e){
//			System.out.print("\n\tError In File Output\n");
//                        try{// Attempting to write the file
//                            File qu = new File("\\Scripts\\RenameME");
//                            FileWriter fileWriter = new FileWriter(qu);
//                            fileWriter.write(StuffToSave);
//                            fileWriter.flush();
//                            fileWriter.close();
//                            System.out.print("\n\tFile Output Finished\n");
//                        }catch(Exception x){
//                            try{// Attempting to write the file
//                            File qu = new File("RenameME");
//                            FileWriter fileWriter = new FileWriter(qu);
//                            fileWriter.write(StuffToSave);
//                            fileWriter.flush();
//                            fileWriter.close();
//                             System.out.print("\n\tFile Output Finished\n");
//                            }catch(Exception xe){
//                                System.out.print("\n\tError In File Output\n");
//                            }
//                        }
//		}
//	}
//        /**
//         *  Takes A file location and string and then saves the file it 
//         * @param File
//         * @param StuffToSave 
//         */
//	public static void SaveText(File File,String StuffToSave){
//		try{// Attempting to write the file
//			FileWriter fileWriter = new FileWriter(File);
//			fileWriter.write(StuffToSave);
//			fileWriter.flush();
//			fileWriter.close();
//                        System.out.print("\n\tFile Output Finished\n");
//		}catch(Exception e){
//			System.out.print("\n\tError In File Output\n");
//		}
//                File f = new File("/Scripts/RenameME");
//                try{// Attempting to write the file
//			FileWriter fileWriter = new FileWriter(f);
//			fileWriter.write(StuffToSave);
//			fileWriter.flush();
//			fileWriter.close();
//                        System.out.print("\n\tFile Output Finished\n");
//		}catch(Exception e){
//			System.out.print("\n\tError In File Output\n");
//		}
//	}
//         
//        /**
//         * Takes A file an tries to retrieve the file and return it as a string 
//         * @param File
//         * @return 
//         */
//        public static String LoadText(File File,File File2 ){
//                String Temp1 ="";
//            try{		
//			Scanner FS = new Scanner(File);
//			while (FS.hasNextLine()){
//				Temp1 = Temp1 + FS.nextLine() + "\n";
//                                System.out.println(Temp1);
//			}
//			FS.close();
//		}catch(Exception e){
//			System.out.print("\n  " + e + " ");
////                        try{		
////                            Scanner FS = new Scanner(File2);
////                            while (FS.hasNextLine()){
////                                    Temp1 = Temp1 + FS.nextLine() + "\n";
////                                    System.out.println(Temp1);
////                            }
////                                FS.close();
////                        }catch(Exception ee){
////			System.out.print("\n  " + ee + " ");
////                    }
//		}
//            
//		return Temp1;
//        }
//        
//        public static String LoadText(File File ){
//                String Temp1 ="";
//            try{		
//			Scanner FS = new Scanner(File);
//			while (FS.hasNextLine()){
//				Temp1 = Temp1 + FS.nextLine() + "\n";
//                                System.out.println(Temp1);
//			}
//			FS.close();
//		}catch(Exception e){
//			System.out.print("\n  " + e + " ");
//		}
//           
//		return Temp1;
//        }
//        
//
//        public static boolean FileExsists_S(String fileName){
//            System.out.println("FileExsists: "+fileName);
//            File f = new File("/Scripts/" + fileName);
//            System.out.println("FileExsists Path: "+ f.getPath().toString());
//            if(f.exists() /*&& !f.isDirectory()*/) { 
//                    System.out.println("FileExsists: Yes");
//                    return true;
//            }else{
//                    return false;
//            }
//        }

    
}
