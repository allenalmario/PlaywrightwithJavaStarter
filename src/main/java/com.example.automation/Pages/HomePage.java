package com.example.automation.Pages;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;

    // string locators
    private String products_title = "//div[@class='product_label']";

    public HomePage (Page page) {
        this.page = page;
    }

    public String getProductsTitleText() {
        String productsText = page.innerText(products_title);
        return productsText;
    }

}
