package pageOpajects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    public CartPage(WebDriver driver) {
        super(driver);
    }
    By txt_ProductNameA1dded_loc= By.xpath("//div[@class='table-responsive']//tr[2]//td[2]");
    By txt_ProductPrice1Added_loc= By.xpath("//div[@class='table-responsive']//tr[2]//td[3]");

    By txt_ProductNameA2dded_loc= By.xpath("//div[@class='table-responsive']//tr[1]//td[2]");
    By txt_ProductPrice2Added_loc= By.xpath("//div[@class='table-responsive']//tr[1]//td[3]");
    By txt_Total_loc=By.id("totalp");

    By btn_DeleteProduct2_loc=By.xpath("//div[@class='table-responsive']//tr[1]//td[4]//a[text()='Delete']");
    By btn_CheckOut_loc= By.xpath("//button[normalize-space()='Place Order']");

    public String verifyProductName2AddToCart() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(txt_ProductNameA2dded_loc));
            WebElement ProductName2 = driver.findElement(txt_ProductNameA2dded_loc);
            String ProductName2AddToCart = ProductName2.getText();
            return ProductName2AddToCart;

        } catch (Exception e)
        {
            return "the product not present on the cart as :"+e;
        }
    }
    public String verifyProductPrice2AddToCart() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(txt_ProductPrice2Added_loc));
            WebElement ProductPrice2 = driver.findElement(txt_ProductPrice2Added_loc);
            String ProductPrice2AddToCart = ProductPrice2.getText();
            return ProductPrice2AddToCart;

        } catch (Exception e)
        {
            return "the product not present on the cart as :"+e;
        }
    }


    public String verifyProductName1AddToCart() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(txt_ProductNameA1dded_loc));

            WebElement ProductName1 = driver.findElement(txt_ProductNameA1dded_loc);
            String ProductName1AddToCart = ProductName1.getText();
            return ProductName1AddToCart;

        } catch (Exception e)
        {
            return "the product not present on the cart as :"+e;
        }
    }

    public String verifyProductPrice1AddToCart() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(txt_ProductPrice1Added_loc));
            WebElement ProductPrice1 = driver.findElement(txt_ProductPrice1Added_loc);
            String ProductPrice1AddToCart = ProductPrice1.getText();
            return ProductPrice1AddToCart;

        } catch (Exception e)
        {
            return "the product not present on the cart as :"+e;
        }
    }




    public String verifyTotalUpdated() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(txt_Total_loc));

            WebElement TotalAmount = driver.findElement(txt_Total_loc);
            String TotalAmountOnCart = TotalAmount.getText();
            return TotalAmountOnCart;

        } catch (Exception e)
        {
            return "the Total Amount On Cart not updated as :"+e;
        }
    }

    public void deleteProduct2()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_DeleteProduct2_loc));
        driver.findElement(btn_DeleteProduct2_loc).click();
    }


   List <WebElement> totalRow = driver.findElements(By.xpath("//div[@class='table-responsive']//tr"));
    ArrayList<String> productList = new ArrayList<>();
    public ArrayList<String> ProductsInCart()
    {
        for (int r=1;r<=totalRow.size();r++)
        {
            String productNames =driver.findElement(By.xpath("//div[@class='table-responsive']//tr["+r+"]//td[2]")).getText();

            productList.add(productNames);
        }

       return productList;
    }


    public void clickCheckOut()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_CheckOut_loc));
        driver.findElement(btn_CheckOut_loc).click();
    }


}
