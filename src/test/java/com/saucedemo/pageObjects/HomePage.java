package com.saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    By firstProductAddToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    By firstProductRemoveFromCartButton = By.id("remove-sauce-labs-backpack");
    By secondProductAddToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    By shoppingCartLink = By.id("shopping_cart_container");
    By checkoutButton = By.id("checkout");
    By shoppingCartBadge = By.className("shopping_cart_badge");
    By menuButton = By.id("react-burger-menu-btn");
    By logoutLink = By.id("logout_sidebar_link");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void addFirstProductToCart() {
        driver.findElement(firstProductAddToCartButton).click();
    }

    public void addSecondProductToCart() {
        driver.findElement(secondProductAddToCartButton).click();
    }

    public void removeFirstProductFromCart() {
        driver.findElement(firstProductRemoveFromCartButton).click();
    }

    public void viewCart() {
        driver.findElement(shoppingCartLink).click();
    }

    public void checkout() {
        driver.findElement(checkoutButton).click();
    }

    public void logout() {
        driver.findElement(menuButton).click();
        driver.findElement(logoutLink).click();
    }

    public String getCartItemCount() {
        return driver.findElement(shoppingCartBadge).getText();
    }
}
