import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestGroup1 {

    private WebDriver driver;
    private InitialisationPage pageOrder = new InitialisationPage();
    private PasswordPage pagePassword = new PasswordPage();
    private MailBoxPage mailBoxPage = new MailBoxPage();
    static String myTestEmail = "elena.testing77@gmail.com";
    static String email1 = "farit.valiahmetov@simbirsoft.com";// user1     -   farit.valiahmetov@simbirsoft.com
    static String email2 = "slavutina@rambler.ru";//  user2      -   slavutina@rambler.ru
    static String emailsFromUser1 = "2";
    static String emailsFromUser2 = "1";
    static String drivePath = new String("C:\\Users\\Alexander\\Desktop\\my_study\\TestMail\\chromedriver\\chromedriver.exe");
    //static String drivePath = new String("C:\\Users\\Alexander\\Desktop\\my_study\\TestMail\\driver\\msedgedriver.exe");

    @BeforeAll
    static void setUpAll() {
     System.setProperty("webdriver.chrome.driver", drivePath);
       // System.setProperty("webdriver.edge.driver", drivePath);
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }


    @Test
    void shouldTestV1() throws InterruptedException {
        pageOrder.setDriver(driver);
        pageOrder.setLogin(myTestEmail);
        pageOrder.confirmNextPage();

        pagePassword.setDriver(driver);
        pagePassword.setPassword("Torpedo123");
        pagePassword.confirmNextPage();

        mailBoxPage.setDriver(driver);
        String numberEmails = mailBoxPage.searchByEmail(email1);
        mailBoxPage.sendByEmail(email1);

        assertEquals(emailsFromUser1,numberEmails);



    }
@Test
    void shouldTestV2() throws InterruptedException {
        pageOrder.setDriver(driver);
        pageOrder.setLogin(myTestEmail);
        pageOrder.confirmNextPage();

        pagePassword.setDriver(driver);
        pagePassword.setPassword("Torpedo123");
        pagePassword.confirmNextPage();

        mailBoxPage.setDriver(driver);
        String numberEmails = mailBoxPage.searchByEmail(email2);
        mailBoxPage.sendByEmail(email2);
    assertEquals(emailsFromUser2,numberEmails);


    }


}