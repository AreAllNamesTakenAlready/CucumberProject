package support;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiHelper {

	public Response getRequest(String url) {
		RestAssured.baseURI = url;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.request(Method.GET, "");
		return response;
	}

//	public Response postRequest(String url, String filePath) throws IOException {
//		byte[] b = Files.readAllBytes(Paths.get(filePath));
//		String bdy = new String(b);
//		RestAssured.baseURI = url;
//		RequestSpecification request = RestAssured.given();
//		request.header("Content-type", "application/json").body(bdy);
//		Response response = request.post();
//		return response;
//	}

	public Response postRequest(String url, String json) throws IOException {
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		request.header("Content-type", "application/json").body(json);
		Response response = request.post();
		return response;
	}

}
