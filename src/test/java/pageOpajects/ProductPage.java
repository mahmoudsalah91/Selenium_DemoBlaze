package pageOpajects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    String confirmMessageProductAdded;
   public ProductPage(WebDriver driver) {
        super(driver);

    }

    By btn_AddToCart_loc= By.xpath("//a[text()='Add to cart']");

    By btn_Home_loc = By.xpath("//a[contains(.,'Home')]");

    By btn_Cart_loc = By.id("cartur");


    public void addProductToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_AddToCart_loc));
        driver.findElement(btn_AddToCart_loc).click();
    }

    public void navigateHomePage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Home_loc));
        driver.findElement(btn_Home_loc).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Home_loc));
    }
    public void navigateCartPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Cart_loc));
        driver.findElement(btn_Cart_loc).click();
    }

    public String confirmMessageProductAdded() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            confirmMessageProductAdded = alert.getText();
            alert.accept();
            System.out.println(confirmMessageProductAdded);
            return confirmMessageProductAdded;
        }catch (Exception e)
        {
            return "the product not add to cart as :"+e;
        }
    }

}
