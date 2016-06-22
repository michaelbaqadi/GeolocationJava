import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSVDocument {
	ArrayList<CSVLine>  lines = new ArrayList<CSVLine>();
	
	public void readCSVFile(String csvFileName) throws Exception {

		  BufferedReader stream = new BufferedReader(
		                          new InputStreamReader(
		                          new FileInputStream(csvFileName)));

		  String line;
		  int count = 0;
		  while ((line = stream.readLine()) != null) {
			if(count == 0){
				count++;
				continue;
			}
		    String[] values = line.split(",");  
		    //(String address, String city, String country, String postal_Code, String state_Province,
			//String fullCountryName, String verifiedAddress, String latitude, String longitude)
		    CSVLine  csvRow = new CSVLine(values[0],values[1],values[2],values[3],values[4],values[5]);
		    lines.add(csvRow);
		    
		
		    
		  }
		}
	public void writeToCSVFile(String fileName){
	    StringBuilder strBuilder = new StringBuilder();
	    
	    try {
			FileWriter writer = new FileWriter(fileName,false);
			strBuilder.append("Address,"+"City,"+"Country,"+"Postal_Code,"+"State_Province,"+"Country,"+"Google Verified Address,"+"Latitude,"+"Longitude"+"\n");
			for(CSVLine line : this.lines){
								
				strBuilder.append(line.getAddress()+","+line.getCity()+","+line.getCountry()+","+line.getPostal_Code()+","+line.getState_Province()+
					 ","+line.getFullCountryName()+","+line.getVerifiedAddress()+","+line.getLatitude()+","+line.getLongitude()+"\n");
			 
			}

		    writer.append(strBuilder);
				
		    writer.flush();
		    writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	    finally{
	    	System.out.println("Done!");
	    }

	}
}
