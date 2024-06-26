package com.saucedemo.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.saucedemo.pageObjects.LoginPage;
import com.saucedemo.pageObjects.HomePage;
import com.saucedemo.pageObjects.CheckOutPage;

public class CheckOutTest extends BaseClass {

    @Test
    public void testCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CheckOutPage checkoutPage = new CheckOutPage(driver);

        // Step 1: Login
        loginPage.setUserName(username);
        takeScreenshot("LoginPage_UsernameEntered");
        loginPage.setPassword(password);
        takeScreenshot("LoginPage_PasswordEntered");
        loginPage.clickSubmit();
        takeScreenshot("LoginPage_AfterLogin");

        // Step 2: Add products to cart
        homePage.addFirstProductToCart();
        takeScreenshot("HomePage_FirstProductAdded");
        homePage.addSecondProductToCart();
        takeScreenshot("HomePage_SecondProductAdded");
        homePage.viewCart();
        takeScreenshot("HomePage_ViewCart");

        // Step 3: Remove first product from cart
        homePage.removeFirstProductFromCart();
        takeScreenshot("HomePage_FirstProductRemoved");

        // Verify cart items
        String itemCount = homePage.getCartItemCount();
        Assert.assertEquals(itemCount, "1", "The number of items in the cart is not as expected");

        // Step 4: Checkout
        homePage.checkout();
        takeScreenshot("HomePage_Checkout");

        // Step 5: Enter checkout information
        checkoutPage.enterFirstName("Gagan");
        takeScreenshot("CheckoutPage_FirstNameEntered");
        checkoutPage.enterLastName("Gowda");
        takeScreenshot("CheckoutPage_LastNameEntered");
        checkoutPage.enterPostalCode("123456");
        takeScreenshot("CheckoutPage_PostalCodeEntered");
        checkoutPage.clickContinue();
        takeScreenshot("CheckoutPage_Continue");

        // Step 6: Finish checkout
        checkoutPage.clickFinish();
        takeScreenshot("CheckoutPage_Finish");

        // Step 7: Logout
        homePage.logout();
        takeScreenshot("HomePage_Logout");
        
        // Add assertions or further checks as needed for successful checkout and logout
    }

    @AfterMethod
    public void afterEachTestMethod() {
        // Ensure driver state is cleaned up after each test method
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
    }
}
