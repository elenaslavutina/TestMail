import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class MailBoxPage {

    private WebDriver _driver;
    public static String numEmails ;

    MailBoxPage() {
        _driver = null;
    }

    public void setDriver(WebDriver driver) {
        _driver = driver;
    }

    public String searchByEmail(String email) {

        if (_driver != null) {

            WebDriverWait wait = new WebDriverWait(_driver, 100);
            /*   Wait until search field will visible                  */
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#gs_lc50 > input:nth-child(1)")));
            WebElement webElement = _driver.findElement(By.cssSelector("#gs_lc50 > input:nth-child(1)"));
            webElement.sendKeys(email); /* put in this field email*/
            WebElement webElementSearch = _driver.findElement(By.cssSelector("#aso_search_form_anchor > button.gb_xf.gb_yf > svg"));
            webElementSearch.click(); /* click on search button*/
            /* find element with number of mails and save it*/
            String selector = new String("#\\:4 > div.D.E.G-atb.PY > div.nH.aqK > div.Cr.aqJ > div.ar5.J-J5-Ji");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(selector)));
            WebElement webTmpMails = _driver.findElement(By.cssSelector(selector));

            String str = webTmpMails.getText();
            int idx = str.lastIndexOf(" ");
            if (idx > 0) {
                str = str.substring(idx + 1);
            } else {
                str = "No e-mails were found";
            }
             numEmails = str;
            return numEmails;

        }
        return "";
    }

    public void sendByEmail(String email) {


        /* send new mail*/
        if (_driver != null) {
            WebDriverWait wait = new WebDriverWait(_driver, 100);

            WebElement webElementCompose = _driver.findElement(By.cssSelector(" .aic > div > div"));
            webElementCompose.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name = 'to']")));
            WebElement webElementTo = _driver.findElement(By.cssSelector("[name = 'to']"));
            webElementTo.sendKeys(email);
            WebElement webElementSubject = _driver.findElement(By.cssSelector("[name = 'subjectbox']"));
            webElementSubject.sendKeys("Slavutina Elena");
            WebElement webElementField = _driver.findElement(By.cssSelector("[aria-label='Message Body'][role = 'textbox']"));
            webElementField.sendKeys(numEmails);

            String keysPressed = Keys.chord(Keys.CONTROL, Keys.RETURN);
            webElementField.sendKeys(keysPressed);
        }

    }
    public void confirmNextPage() {
        if (_driver != null) {
            _driver.findElement(By.cssSelector("#passwordNext > div > button > div.VfPpkd-RLmnJb")).click();
        }
    }

}
