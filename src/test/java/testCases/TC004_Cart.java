package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageOpajects.CartPage;
import pageOpajects.HomePage;
import pageOpajects.ProductPage;
import testBase.BaseClass;
import utilities.FileUtility;

import java.util.ArrayList;
import java.util.List;

public class TC004_Cart extends BaseClass {
    String actualProduct1Name = FileUtility.getFile("productDetails").getString("productName1");
    String actualProduct1Price = FileUtility.getFile("productDetails").getString("productPrice1");

    String actualProduct2Name =  FileUtility.getFile("productDetails").getString("productName2");
    String actualProduct2Price =  FileUtility.getFile("productDetails").getString("productPrice2");

    String actualTotal = FileUtility.getFile("productDetails").getString("Total");

    String actualConfirmMessageProductAdded;
    String expectedConfirmMessage = "Product added";
    SoftAssert softAssert=new SoftAssert();

    @Test
    public void ShoppingCart () throws InterruptedException {

        addProduct();
        CartPage cart = new CartPage(driver);
        String expectedProduct1Name= cart.verifyProductName1AddToCart();
        String expectedProduct2Name= cart.verifyProductName2AddToCart();
        String expectedProduct1Price= cart.verifyProductPrice1AddToCart();
        String expectedProduct2Price= cart.verifyProductPrice2AddToCart();
        String expectedTotal= cart.verifyTotalUpdated();
        List<String> productNameList = new ArrayList<>();
        productNameList.add(actualProduct1Name);
        productNameList.add(actualProduct2Name);
        List<String> productPricesList = new ArrayList<>();
        productPricesList.add(actualProduct1Price);
        productPricesList.add(actualProduct2Price);

        softAssert.assertTrue(productNameList.contains(expectedProduct1Name) && productNameList.contains(expectedProduct2Name));
        softAssert.assertTrue(productPricesList.contains(expectedProduct1Price) && productPricesList.contains(expectedProduct2Price));

        softAssert.assertEquals(actualTotal, expectedTotal);

        cart.deleteProduct2();
        Thread.sleep(5000);
        ArrayList<String> productList=cart.ProductsInCart();
        System.out.println("Product List: " + productList);

        boolean isProductPresent=productList.contains(actualProduct1Name) && productList.contains(actualProduct2Name);
        System.out.println(isProductPresent);
        softAssert.assertFalse(isProductPresent);
        String expectedUpdateTotal= cart.verifyTotalUpdated();
        softAssert.assertNotEquals(actualTotal,expectedUpdateTotal);

        softAssert.assertAll();
        cart.clickCheckOut();




    }



    public void addProduct() {
        HomePage home = new HomePage(driver);
        home.getProduct1Page();
        ProductPage product = new ProductPage(driver);
        product.addProductToCart();
        actualConfirmMessageProductAdded =product.confirmMessageProductAdded();
        Assert.assertTrue(actualConfirmMessageProductAdded.contains(expectedConfirmMessage));
        product.navigateHomePage();
        home.getProduct2Page();
        product.addProductToCart();
        actualConfirmMessageProductAdded =product.confirmMessageProductAdded();
        Assert.assertTrue(actualConfirmMessageProductAdded.contains(expectedConfirmMessage));
        product.navigateCartPage();

    }
}
