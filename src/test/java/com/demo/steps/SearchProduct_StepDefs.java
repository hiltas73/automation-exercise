package com.demo.steps;

import com.demo.pages.SearchProductPage;
import com.demo.utilities.BrowserUtils;
import com.demo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class SearchProduct_StepDefs {

    SearchProductPage searchProductPage = new SearchProductPage();

    @When("user click on the {string} page button")
    public void userClickOnThePageButton(String mainMenuTab) {
        searchProductPage.clickOnBaseMenuTabs(mainMenuTab);
    }

    @Then("user is navigated to {string} page successfully")
    public void user_is_navigated_to_page_successfully(String mainMenuTab) {
        BrowserUtils.verifyTitleContains(mainMenuTab);
        System.out.println("Driver.getDriver().getTitle() = " + Driver.getDriver().getTitle());
    }
    @When("enter product name {string}")
    public void enter_product_name(String searchProductName) {
        searchProductPage.searchProductBox.sendKeys(searchProductName);
        searchProductPage.searchProductButton.click();
    }
    @Then("verify {string} is visible")
    public void verify_is_visible(String text) {
        searchProductPage.elementIsVisible(text);
    }
    @Then("Verify all the products related to search are visible")
    public void verify_all_the_products_related_to_search_are_visible() {
        //System.out.println("searchProductPage.searchResultList.size() = " + searchProductPage.searchResultList.size());
        if (!searchProductPage.searchResultList.isEmpty()){
            for (WebElement each : searchProductPage.searchResultList) {
                System.out.println("each.getText() = " + each.getText());
                Assert.assertTrue(each.isDisplayed());
            }
        } else {
            System.out.println("NO ITEM FOUND");
        }
    }

}
