import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Locators
    private final By searchBox = By.xpath("//textarea[@class='gLFyf']");
    private final By resultItems = By.xpath("//span[@jscontroller='msmzHf']//h3");

    //Methods
    public void enterText(String query) {
        // 1.Wait for search Box to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox));
        // 2.Find element and send query
        driver.findElement(searchBox).sendKeys(query);

    }

    public void submitButton() {
        driver.findElement(searchBox).submit();
    }

    public boolean assertAllResults(String query) {
        wait.until(ExpectedConditions.presenceOfElementLocated(resultItems));
        List<WebElement> results = driver.findElements(resultItems);

        for (WebElement e : results) {
            System.out.println("the result is: " + e.getText());
        }

        boolean matchFound = results.stream()
                .allMatch(r -> r.getText().toLowerCase().contains(query));
        return matchFound;
    }

    public boolean assertOnOfResults(String query) {
        wait.until(ExpectedConditions.presenceOfElementLocated(resultItems));
        List<WebElement> results = driver.findElements(resultItems);

        for (WebElement e : results) {
            System.out.println("the result is: " + e.getText());
        }

        boolean matchFound = results.stream()
                .anyMatch(r -> r.getText().toLowerCase().contains(query));
        return matchFound;
    }

    public boolean assertFirstResult(String query) {
        boolean matchFound = false;
        WebElement result = driver.findElement(By.xpath("(//span[@jscontroller='msmzHf'])[1]"));
        System.out.println("the result: "+result.getText());
        if (result.getText().toLowerCase().contains(query)) {
            matchFound = true;
        }
        return matchFound;
    }

    /* loop on list using normal for loop
    for (int i = 0; i < results.size(); i++) {
        System.out.println(" The result Number " + (i + 1) + ": " + results.get(i).getText());
    }
    */

    /* All Element == AllMach()
    boolean matchFound = true;
    for (Result r : results) {
        if (!r.getText().toLowerCase().contains(query)) {
            matchFound = false;
            break;
        }
    }
    */

    /*  Any Elements == anyMach()
     boolean matchFound = true;
     for (WebElement r : results) {
         if (!r.getText().toLowerCase().contains(query)) {
             matchFound = false;
             break;
         }
     }
     */

}
