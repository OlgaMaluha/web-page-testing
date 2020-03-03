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

import java.util.List;

public class TestFormularWebpage {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
//        String chromeDriverPath = "C:\\chromedriver.exe";
//        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @AfterMethod
    public void cleanUp() {
        driver.quit();
    }

    @Test
    public void findInGoogleRequestTestyFunkcjonalne() {
        GoogleSearchObject searchObject = new GoogleSearchObject(driver);
        searchObject.GoogleSearchInsertAndSubmit("Testy Funkcjonalne");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mBMHK")));

//
//        WebElement element = new WebDriverWait(driver, 10)
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("mBMHK")));

        Assert.assertTrue(el.getText().contains("wyników"));
    }

    @Test
    public void doNotFindPointlessWordInGoogle() {
        GoogleSearchObject searchObject = new GoogleSearchObject(driver);
        searchObject.GoogleSearchInsertAndSubmit("jdhfksjhfjdhfksjhfjshfkjsdhfk");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement res = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("res")));
        WebElement searchResults = res.findElement(By.cssSelector("[role='heading']"));
        Assert.assertTrue(searchResults.getText().contains("nie została odnaleziona"));
    }

    @Test
    public void webElementsExercise() {
        GoogleSearchObject searchObject = new GoogleSearchObject(driver);
        searchObject.GoogleSearchInsertAndSubmit("hello world");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> citeElements = driver.findElements(By.tagName("cite"));
        for (WebElement element : citeElements) {
            if (element.getText().contains("wikipedia")) {
                element.click();
                break;
            }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("wikipedia"));
    }
}
