package test.java;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.cucumber.java.en.Given;
import pages.ReqresPage;

public class Reqres_stepdefinitions {

	ReqresPage req = new ReqresPage();

	@Given("I GET List of Users from {string} Reqres")
	public void i_get_list_of_users_from_reqres(String string) {
		req.getUser(string);
	}

	@Given("I POST from {string} Reqres using JSON {string}")
	public void i_post_from_reqres_using_json(String url, String filePath) throws IOException {
		req.postRequestUsingFile(url, filePath);
	}

	@Given("I POST from {string} Reqres using POJO")
	public void i_post_from_reqres_using_pojo(String string) throws IOException {
		req.postRequestPOJO(string);
	}

	@Given("I Parse JSON")
	public void i_parse_json() throws JsonMappingException, JsonProcessingException {
		req.parseJSON();
	}

}
