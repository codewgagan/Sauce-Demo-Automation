package com.saucedemo.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.pageObjects.LoginPage;
import com.saucedemo.pageObjects.HomePage;

public class AddToCartTest extends BaseClass {

    @Test
    public void testAddToCart() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.setUserName(username);
        loginPage.setPassword(password);
        loginPage.clickSubmit();

        homePage.addFirstProductToCart();
        homePage.addSecondProductToCart();

        String itemCount = homePage.getCartItemCount();
        Assert.assertEquals(itemCount, "2", "The number of items in the cart is not as expected");
    }
}
