import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InteriaLoginPage {

    private WebDriver driver;

    public InteriaLoginPage (WebDriver webDriver){ this.driver = webDriver;}

    public void InteriaLoginAndMailSubmittion(String email, String password){
        WebElement emailField = driver.findElement(By.id("formEmail"));
        emailField.sendKeys(email);

        WebElement passwordField = driver.findElement(By.id("formPassword"));
        passwordField.sendKeys(password);

        WebElement submitButton = driver.findElement(By.id("formSubmit"));
        submitButton.click();
    }

}
