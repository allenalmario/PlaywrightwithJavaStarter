package com.example.automation.tests;

import Base.BaseTest;
import junit.framework.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HomePageTest extends BaseTest {

    @Test
    @DisplayName("Verifying landing on Home Page after successful login")
    public void verifyLandingOnHomePageTest() {
        String productsText = homePage.getProductsTitleText();
        Assert.assertEquals(productsText, "Products");
    }
}
