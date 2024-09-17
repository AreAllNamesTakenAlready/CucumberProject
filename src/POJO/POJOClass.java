// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
package POJO;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class POJOClass {
	public static class Country {
		@JsonProperty("Country")
		public String country;
		@JsonProperty("Data")
		public Data data;
	}

	public static class Data {
		@JsonProperty("Capital")
		public String capital;
		public int minimumtemp;
		public int maximumtemp;
		@JsonProperty("Currency")
		public String currency;
	}

	public static class Root {
		@JsonProperty("Description")
		public String description;
		@JsonProperty("Region")
		public String region;
		@JsonProperty("Countries")
		public ArrayList<Country> countries;
	}
}
