package testCases;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageOpajects.HomePage;
import testBase.BaseClass;

import java.util.List;

public class TC003_ProductFilter extends BaseClass {
    SoftAssert softAssert = new SoftAssert();
    @Test
    public void productDetails() throws InterruptedException {
        HomePage home = new HomePage(driver);
        home.ClickLapTopsBtn();
        List<String> laptopsList = home.getProductList();

        home.ClickPhoneBtn();
        List<String> phonsList = home.getProductList();

        for (String laptops : laptopsList) {
            softAssert.assertFalse(phonsList.contains(laptops));
        }
        softAssert.assertAll();
    }
}
