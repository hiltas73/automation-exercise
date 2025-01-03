package com.demo.steps;

import com.demo.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiStepDefs {

    Response response;

    @When("send GET request to API")
    public void sendGETRequestToAPI() {
        response = given()
                .when().get(ConfigurationReader.getProperty("base_url") + "/productsList")
                .then().extract().response();

        response.prettyPrint();
    }

    @Then("status-code should be {int}")
    public void status_code_should_be(int statusCode) {
        assertEquals("Status Code test", statusCode,response.statusCode());
    }
    @Then("get all product list")
    public void get_all_product_list() {
        JsonPath jsonPath = response.jsonPath();
        List<Map<String,Object>> productsList = jsonPath.getList("products");

        for (Map<String, Object> stringObjectMap : productsList) {
            System.out.println("stringObjectMap = " + stringObjectMap);
        }
    }

    @When("send POST request to API")
    public void send_post_request_to_api() {
        response = given()
                .when().post(ConfigurationReader.getProperty("base_url") + "/productsList")
                .then()
                .extract().response();

        //response.prettyPrint();
    }

    @Then("response-code should be {int}")
    public void response_code_should_be(int code) {
        int responseCode = response.jsonPath().get("responseCode");
        System.out.println("responseCode = " + responseCode);
        System.out.println("code = " + code);
        assertEquals(code, responseCode);
    }

    @Then("response message should be {string}")
    public void response_message_should_be(String string) {
        String message = response.jsonPath().get("message");
        System.out.println("message = " + message);
        assertEquals(string,message);
    }

}
