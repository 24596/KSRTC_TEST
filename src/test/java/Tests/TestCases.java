package Tests;
import Pages.LoginPage;
import Pages.MainPage;
import Utils.ConfigReader;
import Utils.ExcelUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class TestCases {
    private WebDriver driver;
    private ConfigReader configReader;
    private MainPage mainPage;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() throws InterruptedException {
        configReader = new ConfigReader();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @BeforeMethod
    public void openMainPage() {
        driver.get(configReader.getUrl());
    }

    @Test
    public void verifyPhoneNumber() {
        mainPage = new MainPage(driver);
        Assert.assertEquals(mainPage.getPhoneNumber(), "080-26252625", "phone number is not displayed");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String email, String mobileNo , String password) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickSignIn();
        Thread.sleep(2000);

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), "https://ksrtc.in/login", "URL mismatch after clicking sign in.");
        loginPage.enterEmail(email);
        loginPage.enterMobileNo(mobileNo);
        loginPage.enterPassword(password);
    }

//    @Test(dataProvider = "forgotPasswordData")
//    public void testForgotPassword(String email, String mobileNo) {
//        MainPage mainPage = new MainPage(driver);
//        mainPage.clickSignIn();
//
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.enterEmail(email);
//        loginPage.enterMobileNo(mobileNo);
//        loginPage.clickForgotPassword();
//
//        if (loginPage.isErrorMessageDisplayed()) {
//            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            try {
//                Files.copy(screenshot.toPath(), Paths.get("screenshots", "forgot_password_error.png"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid email.");
//        }
//    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testData.xlsx", "LoginData");
        return excelUtils.getTestData();
    }

//    @DataProvider(name = "forgotPasswordData")
//    public Object[][] getForgotPasswordData() {
//        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testData.xlsx", "ForgotPasswordData");
//        return excelUtils.getTestData();
//    }


    @AfterClass
    public void tearDown() {
            driver.quit();
    }
}

