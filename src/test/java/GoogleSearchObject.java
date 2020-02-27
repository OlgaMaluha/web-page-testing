import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearchObject {
    private WebDriver driver;

    public GoogleSearchObject(WebDriver webdriver){
        this.driver = webdriver;
    }

    public void GoogleSearchInsertAndSubmit(String searchedWordOrSentence){
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys(searchedWordOrSentence);
        WebElement submitButton = driver.findElement(By.name("btnK"));
        submitButton.submit();

    }

}
