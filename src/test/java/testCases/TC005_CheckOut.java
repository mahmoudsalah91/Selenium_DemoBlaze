package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageOpajects.CheckOutPage;
import testBase.BaseClass;

public class TC005_CheckOut extends BaseClass {
    String actualConfirmMessage;
    String expectedSuccessfulMessage = "Thank you for your purchase!";
    @Test
    public void CheckOut()
    {
        CheckOutPage checkOut = new CheckOutPage(driver);
        checkOut.fillCheckOutForm();
        checkOut.clickPurchase();
        actualConfirmMessage= checkOut.confirmPurchase();
        Assert.assertEquals(actualConfirmMessage,expectedSuccessfulMessage);
        checkOut.clickOK();

    }
}
