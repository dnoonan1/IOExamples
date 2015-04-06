package labs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author dnoonan1
 */
public class Lab1 {
    
    public static void main(String[] args) throws IOException {
        
        boolean APPEND = true;
        File file;
        
        file = new File(
                  "C:" + File.separatorChar
                + "Temp" + File.separatorChar
                + "Lab1" + File.separatorChar
                + "contacts.txt"
        );
        
        if (file.exists()) {
            
            BufferedReader in = null;
            BufferedWriter out = null;
            try {
                
                in = new BufferedReader(new FileReader(file));
                out = new BufferedWriter(new FileWriter(file, APPEND));
                
                // Read Contacts from file
                String line;
                while ((line = in.readLine()) != null) {                
                    
                    String[] names = line.split(" ");

                    String street = in.readLine();
                    line = in.readLine();
                    String[] cityStateZip = line.split(",");
                    String city = cityStateZip[0];
                    String[] stateZip = cityStateZip[1].split(" ");

                    Contact contact = new Contact(names[0], names[1],
                            street, city, stateZip[0], stateZip[1]);

                    System.out.println(contact + "\n");
                
                }
                
                // Create new Contacts and append them to file
                Contact c1 = new Contact("Bob", "Somebody",
                        "444 S Oil Rd", "Rich", "AK", "99999");
                Contact c2 = new Contact("Ashur", "Banipal",
                        "777 E Shamash St", "Nineveh", "Mesopotamia", "00001");
                
                out.write(c1.toString() + "\n");
                out.write(c2.toString() + "\n");
                
            } finally {
                if (in != null) {
                    in.close(); 
                }
                if (out != null) {
                    out.close();   
                }
            }
        }
        
    }
    
}
