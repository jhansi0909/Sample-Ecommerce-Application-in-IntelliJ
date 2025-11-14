package rahulshetty.pageobjets;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args){

        String productName="ZARA COAT 3";
       WebDriverManager.chromedriver().setup();
       WebDriver driver=new ChromeDriver();
       driver.manage().window().maximize();

       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       LoginPage loginpage=new LoginPage(driver); // object of the login page
       loginpage.goTo();
       loginpage.loginApplication("jhansipayyavula@gmail.com","Jhansi@09");

       ProductCart productCart=new ProductCart(driver);
       List<WebElement> products=productCart.getProductList();
       productCart.addProductCard(productName);


        driver.findElement(By.cssSelector("[routerlink*='cart']")).click(); // regular expression
// After adding the cart we need to check the product is added correctly or not.
        List<WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));

      Boolean match=  cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);
        driver.findElement(By.xpath("//button[text()='Checkout']")).click();

        driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
        driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
        driver.findElement(By.xpath("//a[text()='Place Order ']")).click();

        String thankYouMessage= driver.findElement(By.xpath("//h1[@class='hero-primary']")).getText();
        Assert.assertTrue(thankYouMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

       driver.close();
    }
}
