package com.demo.steps;

import com.demo.pages.SignUpLoginPage;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.ConfigurationReader;
import com.demo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SignUpLogin_StepDefs {

    SignUpLoginPage signUpLoginPage = new SignUpLoginPage();

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("I click on SignupLogin button")
    public void iClickOnSignupLoginButton() {
        signUpLoginPage.signUpBtn.click();
    }

    @And("I see New User Signup page")
    public void iSeeNewUserSignupPage() {
        BrowserUtils.verifyTitle("Automation Exercise - Signup / Login");
    }

    @And("I enter {string} into the name field")
    public void iEnterJohnDoeIntoTheNameField(String name) {
        signUpLoginPage.signUpNameBtn.sendKeys(name);
    }

    @And("I enter email address into the email field")
    public void iEnterEmailAddressIntoTheEmailField() {
        signUpLoginPage.signUpEmailBtn.sendKeys(ConfigurationReader.getProperty("testEmail"));
    }

    @And("I click on Signup button")
    public void iClickOnSignupButton() {
        signUpLoginPage.signUpBtn.click();
    }

    @Then("I see account information page")
    public void iSeeAccountInformationPage() {
        BrowserUtils.verifyTitle("Automation Exercise - Signup");
    }

    @When("I enter necessary information")
    public void iEnterNecessaryInformation() {
        signUpLoginPage.createAccount();
    }

    @Then("I see ACCOUNT CREATED! is visible")
    public void iSeeACCOUNTCREATEDIsVisible() {
        System.out.println("signUpLoginPage.accountCreatedMsg.getText() = " + signUpLoginPage.accountCreatedMsg.getText());
        signUpLoginPage.accountCreatedMsg.isDisplayed();
    }

    @And("I click Continue button")
    public void iClickContinueButton() {
        signUpLoginPage.continueBtn.click();
    }


    @Then("I see Logged in as username is visible")
    public void iSeeLoggedInAsUsernameIsVisible() {
        String profileIconText = signUpLoginPage.profileIcon.getText();
        System.out.println("profileIconText = " + profileIconText);
        Assert.assertTrue(profileIconText.contains("Logged in as"));
    }

    @And("I click on Delete Account button")
    public void iClickOnDeleteAccountButton() {
        signUpLoginPage.deleteAccountLink.click();
    }

    @Then("I see ACCOUNT DELETED! is visible")
    public void iSeeACCOUNTDELETEDIsVisible() {
        System.out.println("signUpLoginPage.accountDeletedMsg.getText() = " + signUpLoginPage.accountDeletedMsg.getText());
        Assert.assertTrue(signUpLoginPage.accountDeletedMsg.isDisplayed());
    }

}
