package com.saucedemo.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By txtUserName = By.id("user-name");
    By txtPassword = By.id("password");
    By btnLogin = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String uname) {
        driver.findElement(txtUserName).sendKeys(uname);
    }

    public void setPassword(String pwd) {
        driver.findElement(txtPassword).sendKeys(pwd);
    }

    public void clickSubmit() {
        driver.findElement(btnLogin).click();
    }
}
