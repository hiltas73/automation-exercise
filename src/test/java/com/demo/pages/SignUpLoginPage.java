package com.demo.pages;

import com.demo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class SignUpLoginPage extends BasePage{

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    public WebElement signUpNameBtn;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    public WebElement signUpEmailBtn;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    public WebElement signUpBtn;

    @FindBy(id = "id_gender1")
    public WebElement genderMrBtn;

    @FindBy(id = "id_gender2")
    public WebElement genderMrsBtn;

    @FindBy(id = "name")
    public WebElement customerNameBtn;

    @FindBy(id = "email")
    public WebElement customerEmailBtn;

    @FindBy(id = "password")
    public WebElement passwordBtn;

    @FindBy(id = "days")
    public List<WebElement> daysDropdown;

    @FindBy(id = "months")
    public List<WebElement> monthsDropdown;

    @FindBy(id = "years")
    public List<WebElement> yearsDropdown;

    @FindBy(id = "newsletter")
    public WebElement newsletterChkbox;

    @FindBy(id = "optin")
    public WebElement specialOfferChkbox;

    @FindBy(id = "first_name")
    public WebElement firstNameBox;

    @FindBy(id = "last_name")
    public WebElement lastNameBox;

    @FindBy(id = "company")
    public WebElement companyBox;

    @FindBy(id = "address1")
    public WebElement address1Box;

    @FindBy(id = "address2")
    public WebElement address2Box;

    @FindBy(id = "country")
    public List<WebElement> countryDropdown;

    @FindBy(id = "state")
    public WebElement stateBox;

    @FindBy(id = "city")
    public WebElement cityBox;

    @FindBy(id = "zipcode")
    public WebElement zipcodeBox;

    @FindBy(id = "mobile_number")
    public WebElement mobileNumberBox;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    public WebElement createAccountBtn;

    @FindBy(xpath = "//b[.='Account Created!']")
    public WebElement accountCreatedMsg;


    @FindBy(xpath = "//a[@data-qa='continue-button']")
    public WebElement continueBtn;

    @FindBy(xpath = "//*[text()=' Logged in as ']")
    public WebElement profileIcon;

    @FindBy(xpath = "//a[contains(text(),'Delete Account')]")
    public WebElement deleteAccountLink;

    //h2[@data-qa='account-deleted']
    @FindBy(xpath = "//h2[@data-qa='account-deleted']")
    public WebElement accountDeletedMsg;


    public void createAccount(){
        Faker faker = new Faker();
        Random random = new Random();

        genderMrBtn.click();
        customerNameBtn.clear();
        customerNameBtn.sendKeys(faker.name().firstName());
        passwordBtn.clear();
        passwordBtn.sendKeys(faker.internet().password());

        Select selectDays = new Select(Driver.getDriver().findElement(By.id("days")));
        selectDays.selectByIndex(random.nextInt(31));

        Select selectMonths = new Select(Driver.getDriver().findElement(By.id("months")));
        selectMonths.selectByIndex(random.nextInt(12));

        Select selectYears = new Select(Driver.getDriver().findElement(By.id("years")));
        selectYears.selectByIndex(random.nextInt(121));

        newsletterChkbox.click();
        specialOfferChkbox.click();

        firstNameBox.sendKeys(faker.name().firstName());
        lastNameBox.sendKeys(faker.name().lastName());

        companyBox.sendKeys(faker.company().name());

        address1Box.sendKeys(faker.address().streetAddress());
        address2Box.sendKeys(faker.address().secondaryAddress());

        Select selectCountry = new Select(Driver.getDriver().findElement(By.id("country")));
        selectCountry.selectByIndex(1);

        stateBox.sendKeys(faker.address().state());

        cityBox.sendKeys(faker.address().city());

        zipcodeBox.sendKeys(faker.address().zipCode());

        mobileNumberBox.sendKeys(faker.phoneNumber().phoneNumber());
        createAccountBtn.click();

    }

}
