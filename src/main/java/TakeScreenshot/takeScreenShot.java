package TakeScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.io.File;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class takeScreenShot {
    public static WebDriver driver;

    public static void main(String[] args) throws IOException  {

        String browser = "chrome";

        if (browser.equalsIgnoreCase("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Documents\\Selenium Webdriver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("EDGE")) {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\Edge driver\\msedgedriver.exe");
            driver = new EdgeDriver();
        }

                //This url is used for a prompt
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();

        String browsertitle = driver.getTitle();
        System.out.println("Page title: " + browsertitle);

                //Take screenshot, this was gotten from: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/TakesScreenshot.html
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                //Save the screenshot using commons io from : https://mvnrepository.com/artifact/commons-io/commons-io/2.11.0 on your mavin
                              //source                      //destination
        FileUtils.copyFile(screenshotFile,new File("C:\\Users\\user\\Documents\\Selenium Projects\\SeleniumProjectScreenShot\\screenshots\\testshots_" + getCurrentDateAndTime() + ".png"));

       //Close browser
        driver.quit();
    }
    //This would add date and time stamp to the screenshot
    private static String getCurrentDateAndTime(){
        return  new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
    }
}
