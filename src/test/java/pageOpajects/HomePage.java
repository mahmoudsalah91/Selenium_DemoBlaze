package pageOpajects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.FileUtility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      String  productName1 = FileUtility.getFile("productDetails").getString("productName1");
      String  productName2 = FileUtility.getFile("productDetails").getString("productName2");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    By btn_Signup_loc = By.id("signin2");

    By btn_Login_loc = By.id("login2");

    By txt_ProductName1_loc = By.linkText(productName1);
    By txt_ProductName2_loc = By.linkText(productName2);
    By list_ProductNames_loc= By.xpath("//h4[@class='card-title']");
    By btn_Phones_loc = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    By btn_LapTops_loc = By.xpath("//a[@onclick=\"byCat('notebook')\"]");



    //By btn_Cart_loc = By.id("cartur");

    public void  ClickSignupBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Signup_loc));
        driver.findElement(btn_Signup_loc).click();
    }

    public void  ClickLoginBtn(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Login_loc));
        driver.findElement(btn_Login_loc).click();
    }


    public void getProduct1Page (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_ProductName1_loc));
        driver.findElement(txt_ProductName1_loc).click();
    }
    public void getProduct2Page (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(txt_ProductName2_loc));
        driver.findElement(txt_ProductName2_loc).click();
    }

    public List<String> getProductList() {
        List<WebElement> products = driver.findElements(list_ProductNames_loc);
        List<String> productNames = new ArrayList<>();

        for (WebElement product : products) {
            productNames.add(product.getText());
        }

        return productNames;
    }


    public void  ClickPhoneBtn() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Phones_loc));
        driver.findElement(btn_Phones_loc).click();
        Thread.sleep(3000);


    }

    public void  ClickLapTopsBtn() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_LapTops_loc));
        driver.findElement(btn_LapTops_loc).click();
        Thread.sleep(3000);

    }

}
