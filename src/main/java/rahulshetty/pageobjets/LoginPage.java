package rahulshetty.pageobjets;

import Base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public class LoginPage extends Baseclass   {
   WebDriver driver;
   //this is the constructor. why we write consructor here, Before touching anything in this class constructor will be executed.
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

//    WebElement userEmail=driver.findElement(By.id("userEmail"));
//    the above line we can write it down in simple way. i.e, called pagefactory

//********* WebElements ************
    @FindBy(id="userEmail")
    WebElement userEmail;

    @FindBy(id="userPassword")
    WebElement userPassword;

    @FindBy(id="login")
    WebElement loginBtn;

//    ******* Actions *********
    public void loginApplication(String Email, String PWD){
        userEmail.sendKeys(Email);
        userPassword.sendKeys((PWD));
        loginBtn.click();
    }
    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client/");
    }
}
