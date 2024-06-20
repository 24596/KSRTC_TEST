package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='header-screen-reader-left']")
    private WebElement phoneNumberText;

    @FindBy(id = "imgLoginAccount")
    private WebElement signInLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getPhoneNumber() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(phoneNumberText));
        String phoneNumber = phoneNumberText.getText().split(" ")[4].trim();
        return phoneNumber;
    }

    public void clickSignIn() {
        signInLink.click();
    }
}
