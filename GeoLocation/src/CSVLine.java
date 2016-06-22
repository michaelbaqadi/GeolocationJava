import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import org.json.JSONObject;

public class CSVLine {

	private String  Address	
		   ,City	
		   ,Country	
		   ,Postal_Code	
		   ,State_Province	
		   ,FullCountryName
		   ,VerifiedAddress
		   ,Latitude	
		   ,Longitude;
	
	public CSVLine(String address, String city, String country, String postal_Code, String state_Province,
			String fullCountryName) {
		Address = address;
		City = city;
		Country = country;
		Postal_Code = postal_Code;
		State_Province = state_Province;
		FullCountryName = fullCountryName != null?fullCountryName:"USA";
		try {
			this.geocoding(address+","+city+","+state_Province +","+postal_Code+" "+country);
	
		} catch (Exception e) {
			System.out.println("Error Verifying Address!");
			e.printStackTrace();
		}
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPostal_Code() {
		return Postal_Code;
	}

	public void setPostal_Code(String postal_Code) {
		Postal_Code = postal_Code;
	}

	public String getState_Province() {
		return State_Province;
	}

	public void setState_Province(String state_Province) {
		State_Province = state_Province;
	}

	public String getFullCountryName() {
		return FullCountryName;
	}

	public void setFullCountryName(String fullCountryName) {
		FullCountryName = fullCountryName;
	}

	public String getVerifiedAddress() {
		return VerifiedAddress;
	}

	public void setVerifiedAddress(String verifiedAddress) {
		VerifiedAddress = verifiedAddress;
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}
	
	public void geocoding(String addr) throws Exception
	{
		// build a URL
	    String s = "https://maps.google.com/maps/api/geocode/json?" +
	                    "sensor=false&address=";
	    
	
	    s += URLEncoder.encode(addr, "UTF-8")+"&key=AIzaSyCmnZXTwRbWxbIotpc9O62M2HrZT_BysEU";
	    URL url = new URL(s);
	 
	    // read from the URL
	    Scanner scan = new Scanner(url.openStream());
	    String str = new String();
	    while (scan.hasNext())
	        str += scan.nextLine();
	    scan.close();
	 
	    // build a JSON object
	    JSONObject obj = new JSONObject(str);
	    if (! obj.getString("status").equals("OK"))
	        return;
	
	    // get the first result
	    JSONObject res = obj.getJSONArray("results").getJSONObject(0);
	    JSONObject loc =
	       res.getJSONObject("geometry").getJSONObject("location");
	       this.VerifiedAddress = res.getString("formatted_address").replace(",", " ");
		   this.Latitude = String.valueOf(loc.getDouble("lat")) != null?String.valueOf(loc.getDouble("lat")):"Can not find location";	
		   this.Longitude = String.valueOf(loc.getDouble("lng")) != null?String.valueOf(loc.getDouble("lng")):"Can not find location";
		  
	}
	
	
}
