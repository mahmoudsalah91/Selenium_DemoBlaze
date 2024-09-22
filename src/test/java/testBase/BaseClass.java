package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseClass {
    public static WebDriver driver;

    @BeforeTest
    public void Setup()
    {
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @AfterTest
    public static void TearDown()
    {
        driver.close();
    }

    public static String randomString(){
        return RandomStringUtils.randomAlphabetic(5);
    }

    public static String randomNumber(){
        return RandomStringUtils.randomNumeric(5);
    }

    public String captureScreen(String testName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()); // time stamp to specify each Screen

        TakesScreenshot  ts = (TakesScreenshot)driver;
        BufferedImage sourceFile = ImageIO.read(ts.getScreenshotAs(OutputType.FILE));

        String targetFilePath = System.getProperty("user.dir")+"/ScreenShots/"+testName+"_"+timeStamp+".png";
        File targetFile = new File(targetFilePath);
        ImageIO.write(sourceFile ,"png",targetFile);

        return targetFilePath;

    }

}

