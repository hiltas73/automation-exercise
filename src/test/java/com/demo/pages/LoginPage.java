package com.demo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement emailInputField;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    public WebElement passwordInputField;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    public WebElement loginBtn;

    @FindBy(xpath = "//*[text()=' Logged in as ']")
    public WebElement profileIcon;
}
