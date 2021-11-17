package logic;

import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.Login;

import java.time.Duration;

public class SetUp {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static final String URL = "http://localhost:4444/wd/hub/";
    public static final String testURL = "http://98.158.107.21:4040";
    public Login homePO;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }
    @BeforeTest
    public void startInit() {
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get(testURL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePO = new Login();
   }

    @AfterTest
    public void close(){
        driver.close();
        driver.quit();
    }
}