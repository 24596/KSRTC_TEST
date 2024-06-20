package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "userName")
    private WebElement emailField;

    @FindBy(id="")
    private WebElement mobileNoField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(linkText = "Forgot Password")
    private WebElement forgotPasswordLink;

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
}
