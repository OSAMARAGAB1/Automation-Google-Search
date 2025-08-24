import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.Arrays;

public class BaseTest {

    private WebDriver driver;
    public GoogleHomePage googleHomePage;

    @BeforeTest
    public void openBrowser() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        driver = new ChromeDriver(options);
        driver.get("https://google.com");
        googleHomePage = new GoogleHomePage(driver);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
