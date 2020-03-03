import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestInteriaSingIn {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
//        String chromeDriverPath = "C:\\chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get("https://poczta.interia.pl/");
        WebElement rodoDeclarationButton = driver.findElement(By.className("rodo-popup-agree"));
        rodoDeclarationButton.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);

    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void logIntoInteriaMailboxWithCorrectCredentials() {
        InteriaLoginPage loginPage = new InteriaLoginPage(driver);
        loginPage.InteriaLoginAndMailSubmittion("lilly.smith@pisz.to", "YtaJt.nFMrz_r4h");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
        WebElement odebrane = driver.findElement(By.xpath("//h1[@title='Odebrane']"));
        Assert.assertTrue(odebrane.isDisplayed());
    }

    @Test
    public void LogIntoInteriaMailboxWithWrongLoginData() {
        InteriaLoginPage loginPage = new InteriaLoginPage(driver);
        loginPage.InteriaLoginAndMailSubmittion("jkjhjkhkj@pisz.to", "jkldkjksjlkjdl");
        WebElement errorMessage = driver.findElement(By.cssSelector("#pocztaLoginForm > div.errorMsg > div"));
        Assert.assertTrue(errorMessage.getText().contains("#1801"));
    }

    @Test
    public void LogInWithEmptyInput() {
        InteriaLoginPage loginPage = new InteriaLoginPage(driver);
        loginPage.InteriaLoginAndMailSubmittion("", "");
        WebElement emailFieldErrorMessage = driver.findElement(By.cssSelector("#pocztaLoginForm > fieldset > div.row.input.email.input--filled.error > ul > li"));
        WebElement passwordFieldErrorMessage = driver.findElement(By.cssSelector("#pocztaLoginForm > fieldset > div.row.input.password.error > ul"));
        Assert.assertTrue(emailFieldErrorMessage.getText().contains("Uzupełnij") && passwordFieldErrorMessage.getText().contains("Uzupełnij"));

    }

    @Test
    public void LoginWithCapitalizedEmail() {
        InteriaLoginPage loginPage = new InteriaLoginPage(driver);
        loginPage.InteriaLoginAndMailSubmittion("LILLY.SMITH@PISZ.TO", "YtaJt.nFMrz_r4h");
        WebElement odebraneMessage = driver.findElement(By.xpath("//h1[@title='Odebrane']"));
        Assert.assertTrue(odebraneMessage.getText().equalsIgnoreCase("odebrane"));
    }

    @Test
    public void LoginWithCapitalizedPassword() {
        InteriaLoginPage loginPage = new InteriaLoginPage(driver);
        loginPage.InteriaLoginAndMailSubmittion("lilly.smith@pisz.to", "YTAJT.NFMRZ_R4H");
        WebElement errorMessage = driver.findElement(By.cssSelector("#pocztaLoginForm > div.errorMsg > div"));
        Assert.assertTrue(errorMessage.getText().contains("#1801"));

    }

}
