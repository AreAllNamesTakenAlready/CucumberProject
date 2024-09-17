package pages;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJO.POJOClass.Root;
import POJO.User;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import support.ApiHelper;

public class ReqresPage extends BasePage {

	ApiHelper api = new ApiHelper();

	public void getUser(String url) {
		Response response = api.getRequest(url);
		System.out.println("Status received => " + response.getStatusLine());
		System.out.println("Response=>" + response.prettyPrint());
	}

	public void postRequestUsingFile(String url, String jsonFilePath) throws IOException {
		byte[] b = Files.readAllBytes(Paths.get(jsonFilePath));
		String bdy = new String(b);
		Response response = api.postRequest(url, bdy);

		// Get Validatable response to perform validation
		ValidatableResponse validatableResponse = response.then();
		validatableResponse.statusCode(201);
		JsonPath jsnPath = response.jsonPath();
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(jsnPath.getString("name"));
		System.out.println(jsnPath.getString("password"));
		System.out.println(jsnPath.getString("id"));
		System.out.println(jsnPath.getString("createdAt"));
	}

	public void postRequestPOJO(String url) throws IOException {
		User inputuser = new User();
		inputuser.setName("Mohit");
		inputuser.setPassword("Mohit123");

		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		String userJSON = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(inputuser);
		System.out.println(userJSON);

		Response response = api.postRequest(url, userJSON);

		// convert output response to Class
		User outputUser = response.getBody().as(User.class);
		System.out.println(outputUser.getName());
		System.out.println(outputUser.getPassword());
		System.out.println(outputUser.getCreatedAt());
		System.out.println(outputUser.getID());

		Assert.assertEquals(outputUser.getName(), inputuser.getName());

	}

	public void parseJSON() throws JsonMappingException, JsonProcessingException {
		String jsonStr = "{\r\n"
				+ "    \"Description\": \"Map containing Country, Capital, Currency, and some States of that Country\",\r\n"
				+ "    \"Region\": \"Asia\",\r\n" + "    \"Countries\": [\r\n" + "        {\r\n"
				+ "            \"Country\": \"India\",\r\n" + "            \"Data\": {\r\n"
				+ "                \"Capital\": \"New Delhi\",\r\n" + "                \"minimumtemp\": 6,\r\n"
				+ "                \"maximumtemp\": 45,\r\n" + "                \"Currency\": \"Rupee\"\r\n"
				+ "            }\r\n" + "        },\r\n" + "        {\r\n" + "            \"Country\": \"Nepal\",\r\n"
				+ "            \"Data\": {\r\n" + "                \"Capital\": \"Katmandu\",\r\n"
				+ "                \"minimumtemp\": 9,\r\n" + "                \"maximumtemp\": 23,\r\n"
				+ "                \"Currency\": \"Nepalese rupee\"\r\n" + "            }\r\n" + "        }\r\n"
				+ "    ]\r\n" + "}";

		ObjectMapper mapper = new ObjectMapper();
		JsonNode node = mapper.readTree(jsonStr);
		System.out.println(node.get("Description"));
		System.out.println(node.get("Region"));
		System.out.println(node.get("Countries"));
		System.out.println(node.get("Countries"));
		Root root = mapper.readValue(jsonStr, POJO.POJOClass.Root.class);
		System.out.println("JSON Parsing using jackson -------------------");
		System.out.println(root.description);
		System.out.println(root.region);
		System.out.println(root.countries.get(0).country);
		System.out.println(root.countries.get(0).data.capital);
		System.out.println(root.countries.get(1).country);
		System.out.println(root.countries.get(1).data.capital);
	}
}
