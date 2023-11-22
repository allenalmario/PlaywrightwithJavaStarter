package com.example.automation.Factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    public Page initBrowser(Properties prop) {
        String browserName = prop.getProperty("browser").trim();
        Boolean headless = Boolean.parseBoolean(prop.getProperty("headless"));

        System.out.println("Browser name is: " + browserName);

        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(headless));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(headless));
                break;
        }

        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));

        page = browserContext.newPage();

        page.navigate(prop.getProperty("base.url"));

        return page;
    }

    public Properties init_prop() throws IOException {
        FileInputStream ip = new FileInputStream("./src/main/resources/config.properties");
        prop = new Properties();
        prop.load(ip);
        return prop;
    }

}
