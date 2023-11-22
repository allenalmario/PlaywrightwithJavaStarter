package com.example.automation.Pages;

import com.microsoft.playwright.Page;

import java.util.Properties;

public class LoginPage {

    Page page;
    Properties prop;

    //string locators
    private String user_name_field = "input[id='user-name']";
    private String password_field = "input[id='password']";
    private String login_button = "input[id='login-button']";

    public LoginPage (Page page, Properties prop) {
        this.page = page;
        this.prop = prop;
    }

    public void login() {
        page.fill(user_name_field, prop.getProperty("username"));
        page.fill(password_field, prop.getProperty("password"));
        page.click(login_button);
    }
}
