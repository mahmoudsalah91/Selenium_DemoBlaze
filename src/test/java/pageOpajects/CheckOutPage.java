package pageOpajects;



import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Year;

public class CheckOutPage extends BasePage{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    Faker faker = new Faker();
   public CheckOutPage(WebDriver driver) {
        super(driver);
    }

     By CheckOutName = By.id("name");
     By CheckOutCountry = By.id("country");
     By CheckOutCity = By.id("city");
     By CheckOutCreditCard = By.id("card");
     By CheckOutMonth = By.id("month");
     By CheckOutYear = By.id("year");

    By btn_Purchase_loc = By.xpath("//button[normalize-space()='Purchase']");

    By txt_confirmPurchase_loc = By.xpath("//h2[normalize-space()='Thank you for your purchase!']");

    By btn_OK_loc = By.xpath("//button[normalize-space()='OK']");


    public String confirmPurchase() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(txt_confirmPurchase_loc));
            String confirmPurchaseMessage =driver.findElement(txt_confirmPurchase_loc).getText();
            return confirmPurchaseMessage;
        }catch (Exception e)
        {
            return "the confirm Purchase Message not present as :"+e;
        }
    }
    public void clickOK() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_OK_loc));
        driver.findElement(btn_OK_loc).click();
    }

    public void SetCheckOutName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOutName));
        driver.findElement(CheckOutName).sendKeys(name);
    }
    public void SetCheckOutCity(String City) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOutCity));
        driver.findElement(CheckOutCity).sendKeys(City);
    }

    public void SetCheckOutCountry(String Country) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOutCountry));
        driver.findElement(CheckOutCountry).sendKeys(Country);
    }

    public void SetCheckOutCreditCard(String CreditCard) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOutCreditCard));
        driver.findElement(CheckOutCreditCard).sendKeys(CreditCard);
    }

    public void SetCheckOutMonth(String Month) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOutMonth));
        driver.findElement(CheckOutMonth).sendKeys(Month);
    }

    public void SetCheckOutYear(String Year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CheckOutYear));
        driver.findElement(CheckOutYear).sendKeys(Year);
    }
    public void fillCheckOutForm()
    {

        SetCheckOutName(faker.name().name());
        SetCheckOutCountry(faker.country().countryCode2());
        SetCheckOutCity(faker.country().capital());
        SetCheckOutCreditCard(faker.finance().creditCard());
        SetCheckOutMonth(String.valueOf(faker.number().numberBetween(1,12)));
        SetCheckOutYear(Year.now().toString());

    }




    public void clickPurchase() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_Purchase_loc));
        driver.findElement(btn_Purchase_loc).click();
    }
}
