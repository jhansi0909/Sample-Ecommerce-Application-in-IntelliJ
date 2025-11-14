package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Baseclass {
 WebDriver driver;
    public Baseclass(WebDriver driver){
        this.driver=driver;
    }
    public void waitForElementAppear(By findBy){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
    }
    public void waitForElementDisappear(WebElement ele){
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

}
