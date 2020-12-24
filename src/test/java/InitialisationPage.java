import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static org.openqa.selenium.By.cssSelector;


/*import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;*/


public class InitialisationPage {

  /*  private SelenideElement form;*/
    private WebDriver _driver;

    InitialisationPage () {
        _driver = null;
    }

    public void setDriver(WebDriver driver) {
        _driver = driver;
    }

    public void setLogin(String login) {
        if (_driver != null) {
            _driver.get("https://mail.google.com/");
            _driver.findElement(By.id("identifierId")).sendKeys(login);
        }
    }

        public void setLoginForRambler(String login) {
            if (_driver != null) {
                _driver.get("https://mail.rambler.ru/");
          //      _driver.findElement(By.cssSelector(".page-0-3-6 page-d2-0-3-9 ")).isDisplayed();
                WebElement element = _driver.findElement(By.cssSelector("[type = 'email'].rui-FormGroup-inner"));

                element.sendKeys(login);


            }

    }

    public void setPasswordForRambler(String password) {
        if (_driver != null) {
            _driver.get("https://mail.rambler.ru/");

            _driver.findElement(By.id("password")).sendKeys(password);

        }
    }
    public void confirmNextPage() {

        _driver.findElement(By.cssSelector("#identifierNext > div > button")).click();

    }

    public void confirmNextPageForRambler() {


        _driver.findElement(By.cssSelector("[data-cerber-id='login_form::main::login_button']")).click();

    }


}