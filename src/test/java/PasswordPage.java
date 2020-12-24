import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.By.cssSelector;

public class PasswordPage {

    private WebDriver _driver;

    PasswordPage () {
        _driver = null;
    }

    public void setDriver(WebDriver driver) {
        _driver = driver;
    }

    public void setPassword(String password) {
        if (_driver != null) {

            WebDriverWait wait = new WebDriverWait(_driver, 20);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

            _driver.findElement(By.name("password")).sendKeys(password);
        }
    }

    public void confirmNextPage() {
        if (_driver != null) {
            _driver.findElement(By.cssSelector("#passwordNext > div > button > div.VfPpkd-RLmnJb")).click();
        }
    }

}
