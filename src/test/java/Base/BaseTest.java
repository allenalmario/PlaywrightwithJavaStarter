package Base;

import com.example.automation.Factory.PlaywrightFactory;
import com.example.automation.Pages.HomePage;
import com.example.automation.Pages.LoginPage;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.util.Properties;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeEach
    public void setup(TestInfo testInfo) throws IOException {
        System.out.println("<<<<< SETTIGN UP BROWSER >>>>>");
        System.out.println("<<<<< Test Started >>>>>");
        testInfo.getTestMethod().get().getName();

        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);

        loginPage = new LoginPage(page, prop);
        homePage = new HomePage(page);

        System.out.println("<<<<< LOGGING ON >>>>>");
        loginPage.login();
        System.out.println("<<<<< LOGGED IN SUCCESSFULLY >>>>>");
    }

    @AfterEach
    public void teardown(TestInfo testInfo) {
        System.out.println("<<<<< Test Completed >>>>>");
        testInfo.getTestMethod().get().getName();
        System.out.println("<<<<< CLOSING BROWSER >>>>>");
        page.context().browser().close();
    }

}
