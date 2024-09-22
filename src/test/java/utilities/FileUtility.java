package utilities;


import java.util.ResourceBundle;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
    public static ResourceBundle getFile (String fileName){
        ResourceBundle Data=ResourceBundle.getBundle(fileName);
        return Data;
    }

}
