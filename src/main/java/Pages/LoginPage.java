package Pages;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(xpath="//label[text()='Email ID']/preceding-sibling::input")
    private WebElement emailField;

    @FindBy(xpath="//input[@type='tel']")
    private WebElement mobileNoField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='linkForgotPassword']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//div[text()='AGREE']")
    private WebElement tcAgreeButton;

    @FindBy(xpath = "//div[@class='alert--content error login--alert']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailField.click();
        emailField.sendKeys(email);
    }

    public void enterMobileNo(String mobileNo) {
        mobileNoField.click();
        mobileNoField.sendKeys(mobileNo);
    }

    public void enterPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickForgotPassword(){
        forgotPasswordLink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(tcAgreeButton));
        tcAgreeButton.click();
        forgotPasswordLink.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}
