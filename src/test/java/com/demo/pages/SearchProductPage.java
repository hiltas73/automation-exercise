package com.demo.pages;

import com.demo.utilities.BrowserUtils;
import com.demo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchProductPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Search Product']")
    public WebElement searchProductBox;

    @FindBy(id = "submit_search")
    public WebElement searchProductButton;

    @FindBy(xpath = "//div[@class='features_items']//div[@class='col-sm-4']")
    public List<WebElement> searchResultList;

    public void elementIsVisible(String text){
        // first change all letters to lowercase
        String lowerCase = text.toLowerCase();

        // Use Stream to capitalize the first chars of given text
        String streamText = Arrays.stream(lowerCase.split("\\s"))
                .map(word -> Character.toTitleCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
        // check point for data we retrieve
        System.out.println("streamText = " + streamText);

        BrowserUtils.verifyElementDisplayed(By.xpath("//h2[text()='" + streamText + "']"));
        System.out.println(" Displayed Element = " + Driver.getDriver().findElement(By.xpath("//h2[text()='" + streamText + "']")).getText());

    }


}
