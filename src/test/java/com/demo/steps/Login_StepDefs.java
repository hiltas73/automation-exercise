package com.demo.steps;

import com.demo.pages.LoginPage;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class Login_StepDefs {

    LoginPage loginPage = new LoginPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginUrl"));
    }
    @When("user fill in username")
    public void user_fill_in_username() {
        loginPage.emailInputField.sendKeys(ConfigurationReader.getProperty("email"));
    }
    @When("user fill in password")
    public void user_fill_in_password() {
        loginPage.passwordInputField.sendKeys(ConfigurationReader.getProperty("password"));
    }
    @When("user click on the Login button")
    public void user_click_on_the_login_button() {
        loginPage.loginBtn.click();
    }
    @Then("user should be redirected to the home page")
    public void user_should_be_redirected_to_the_home_page() {
        Assert.assertTrue(loginPage.profileIcon.getText().contains("Logged in as"));
        //System.out.println("loginPage.profileIcon.getText() = " + loginPage.profileIcon.getText());
    }

}
