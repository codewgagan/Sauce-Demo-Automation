package com.saucedemo.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.saucedemo.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() {
        // Open the base URL
        driver.get(baseURL);

        // Create LoginPage object
        LoginPage lp = new LoginPage(driver);

        // Set username and password, then click submit
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clickSubmit();

        
    }
}
