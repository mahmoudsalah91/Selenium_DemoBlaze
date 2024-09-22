package pageOpajects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    String confirmMessage;
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    By txt_UserName_loc = By.id("sign-username");
    By txt_Password_loc = By.id("sign-password");
    By btn_SignUp_loc = By.xpath("//button[normalize-space()='Sign up']");


    public void setUserName(String UserName) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(txt_UserName_loc)));
        driver.findElement(txt_UserName_loc).sendKeys(UserName);
    }

    public void setPassword(String Password) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(txt_Password_loc)));
        driver.findElement(txt_Password_loc).sendKeys(Password);

    }
    public void clickSignUpBtn() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(btn_SignUp_loc)));
        driver.findElement(btn_SignUp_loc).click();
    }

    public String confirmMessage() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            confirmMessage = alert.getText();
            alert.accept();
            System.out.println(confirmMessage);
            return confirmMessage;
        }catch (Exception e)
        {
            return "the Alert not present as :"+e;
        }
    }
}
