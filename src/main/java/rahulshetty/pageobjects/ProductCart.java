package rahulshetty.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCart extends rahulshetty.pageobjets.Baseclass {
   WebDriver driver;
   //this is the constructor. why we write constructor here, Before touching anything in this class constructor will be executed.
    public ProductCart(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

//********* WebElements ************
    @FindBy(css=".mb-3")
    List<WebElement> products;

    @FindBy(css=".ng-animating")
    WebElement spinner;

    By productsBy= By.cssSelector(".mb-3");
    By addToCart=By.cssSelector(".card-body button:last-of-type");
    By toastMessage=By.cssSelector("#toast-container");

//    ******* Actions *********
    public List<WebElement> getProductList(){
        waitForElementAppear(productsBy);
        return products;
    }

    public WebElement getProductNames(String productName){
        WebElement prod= getProductList().stream().filter(product->
                product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
        //products → A list of web elements (probably all product cards on a webpage).
//.stream() → Converts that list of web elements into a stream.
//.filter(...) → Filters out only those products where the <b> tag text equals "ZARA COAT 3".
//product.findElement(By.cssSelector("b")) → Finds the <b> tag inside each product card.
//.getText() → Gets the text of that <b> tag.
//.equals("ZARA COAT 3") → Checks if the text matches "ZARA COAT 3".
// .findFirst() → returns the first matching element from the filtered list.
//.orElse(null) → returns null if no product matches.
    }
    public void addProductCard(String productName){
        WebElement prod=getProductNames(productName);
        prod.findElement(addToCart).click();
        waitForElementAppear(toastMessage);
        waitForElementDisappear(spinner);
        // It will go to the matching text card and there are two buttons i.e, why we are using last-of-type (css selector) it will select last element.
    }

}
