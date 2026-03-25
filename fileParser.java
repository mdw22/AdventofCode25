package AdventofCode25;

import java.io.*;
import java.util.Scanner;

public class fileParser {
    public static String parseFile(String filePath) {
        try {
            File myFile = new File(filePath);
            Scanner scan = new Scanner(myFile);
            String result = "";
            while(scan.hasNextLine()) {
                result += scan.nextLine();
                if(scan.hasNextLine()) result += "\n";
            }
            scan.close();
            return result;
        } catch (Exception e) {
            System.out.println("Exception Occured: " + e);
        }
        return null;
    }
}
