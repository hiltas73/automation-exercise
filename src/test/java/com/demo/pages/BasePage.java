package com.demo.pages;

import com.demo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    public WebElement loginBtn;

    public void clickOnButton(String buttonName){
        Driver.getDriver().findElement(By.xpath("//button[text()='" + buttonName + "']")).click();
    }

    public void clickOnBaseMenuTabs(String tabName){
        Driver.getDriver().findElement(By.xpath("//a[text()=' " + tabName + "']")).click();
    }

}
