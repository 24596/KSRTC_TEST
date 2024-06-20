package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//div[@class='inp-container extra err']/input")
    private WebElement emailField;

    @FindBy(xpath="//div[@class='inp-container'][2]")
    private WebElement mobileNoField;

    @FindBy(xpath = "//div[@class='inp-container'][3]")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='linkForgotPassword']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//div[@class='alert--content error login--alert']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterMobileNo(String mobileNo) {
        mobileNoField.sendKeys(mobileNo);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}
