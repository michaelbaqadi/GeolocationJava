import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;


public class GeoLocation {

    public static void main(String[] args) {
    	CSVDocument doc = new CSVDocument();
    	
    	
    	try{
			doc.readCSVFile("Addresses.csv");
			doc.writeToCSVFile("Addresses8.csv");
    	}
    	catch (FileNotFoundException e){
    		System.out.println("Error File is not found");
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }

	
}
