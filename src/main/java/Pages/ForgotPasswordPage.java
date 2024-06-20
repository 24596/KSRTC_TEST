package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "submitBtn")
    private WebElement submitButton;

    @FindBy(xpath = "//div[contains(text(),'Login Name not found in the system')]")
    private WebElement errorMessage;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }
}
