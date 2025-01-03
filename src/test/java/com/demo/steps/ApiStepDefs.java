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

    @Then("status-code should be {string}")
    public void status_code_should_be(String statusCode) {
        assertEquals("200", statusCode);
    }
    @Then("get all product list")
    public void get_all_product_list() {
        JsonPath jsonPath = response.jsonPath();
        List<Map<String,Object>> productsList = jsonPath.getList("products");

        for (Map<String, Object> stringObjectMap : productsList) {
            System.out.println("stringObjectMap = " + stringObjectMap);
        }
    }


}
