package TakeScreenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.io.File;
import java.io.*;

public class takeScreenShot {
    public static WebDriver driver;

    public static void main(String[] args) throws IOException  {

        String browser = "chrome";

        if (browser.toUpperCase().equals("CHROME")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\morgan.nwaiku\\Downloads\\app\\web Drivers\\chrome driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.toUpperCase().equals("EDGE")) {
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
        FileUtils.copyFile(screenshotFile,new File("C:\\Users\\morgan.nwaiku\\Documents\\OPS SERVICE MGT\\QA\\QA-PROJECT\\SeleniumProjectScreenShot\\screenshots\\testshots.png"));

       //Close browser
        driver.quit();

    }
}
