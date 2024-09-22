package pageOpajects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    String nameOfUser;
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By txt_UserName_loc = By.id("loginusername");
    By txt_Password_loc = By.id("loginpassword");
    By btn_Login_loc = By.xpath("//button[normalize-space()='Log in']");
    By txt_nameOfUser_loc = By.id("nameofuser");

    public void setUserName(String UserName) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(txt_UserName_loc)));
        driver.findElement(txt_UserName_loc).sendKeys(UserName);

    }

    public void setPassword(String Password) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(txt_Password_loc)));
        driver.findElement(txt_Password_loc).sendKeys(Password);

    }
    public void clickLoginBtn() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(btn_Login_loc)));
        driver.findElement(btn_Login_loc).click();
    }
    public String verifyUserLogin() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(txt_nameOfUser_loc));
            //Thread.sleep(6000);
            nameOfUser = driver.findElement(txt_nameOfUser_loc).getText();
            System.out.println(nameOfUser);
            return nameOfUser;
        } catch (Exception e) {
            return "the user is not present as :" + e;
        }


    }
}


