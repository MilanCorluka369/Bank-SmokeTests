import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankManagerPage extends BasePage{
    private By bankManagerLoginBtn = By.xpath("//*[contains(text(), 'Bank Manager Login')]");
    private By addCustomerSectionBtn = By.xpath("//*[contains(text(), 'Add Customer')]");
    private By openAccountSectionBtn = By.xpath("//*[contains(text(), 'Open Account')]");
    private By bankManagerLogoutBtn = By.xpath("/html/body/div/div/div[1]/button[2]");

    public BankManagerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /////////////// CLICKS /////////////////
    public void clickBankManagerLogin(){
        getDriver().findElement(this.bankManagerLoginBtn).click();
    }

    public void clickAddCustomerSection(){
        getDriver().findElement(this.addCustomerSectionBtn).click();
    }

    public void clickOpenAccountSection(){
        getDriver().findElement(this.openAccountSectionBtn).click();
    }

    public void clickLogoutBtn(){
        WebElement element = getDriver().findElement(bankManagerLogoutBtn);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    //////////// WAITERS //////////////
    public void waitBankManagerLoginBtn (){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.bankManagerLoginBtn));
    }

    public void waitAddCustomerSectionBtn(){
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(this.addCustomerSectionBtn));
    }

    ///////////// isDISPLAYED //////////////
    public boolean isDisplayedAddCustomerBtn(){
        return getDriver().findElement(this.addCustomerSectionBtn).isDisplayed();
    }
}
