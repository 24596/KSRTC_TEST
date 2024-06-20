package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class='header-screen-reader-left']")
    private WebElement phoneNumberText;

    @FindBy(id = "imgLoginAccount")
    private WebElement signInLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getPhoneNumber() {
        String phoneNumber = phoneNumberText.getText().split(" ")[4].trim();
        return phoneNumber;
    }

    public void clickSignIn() {
        signInLink.click();
    }
}
