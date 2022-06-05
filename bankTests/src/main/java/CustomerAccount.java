import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//Deposit Successful Transaction successful
public class CustomerAccount extends BasePage{
    private By depositBtn = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By withdrawlBtn = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private By amountInput = By.xpath("//*[contains(@type, 'number')]");
    private By submitBtn = By.xpath("//*[contains(@class, 'btn-default')]");
    private By infoMessage = By.xpath("//*[contains(@class, 'error')]");
    private By logoutBtn = By.xpath("//*[contains(text(), 'Logout')]");

    public CustomerAccount(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    ///////////////// CLICKS /////////////////
    public void clickDepositBtn(){
        getDriver().findElement(this.depositBtn).click();
    }

    public void clickWithdrawlBtn(){
        getDriver().findElement(this.withdrawlBtn).click();
    }

    public void clickSubmit(){
        getDriver().findElement(this.submitBtn).click();
    }
    public void clickLogoutBtn(){
        getDriver().findElement(this.logoutBtn).click();
    }

    /////////////// ENTER AMOUNT //////////////////
    public void enterAmount(int number){
        getDriver().findElement(this.amountInput).sendKeys(String.valueOf(number));
    }

    ///////////////// MESSAGE //////////////////
    public String getMessage() {
        return getDriver().findElement(this.infoMessage).getText();
    }

    //////////////////// WAITERS /////////////////////
    public void waitDepositBtn(){
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.depositBtn));
    }

    public void waitAmountInput(){
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(this.amountInput));
    }

    public void waitInfoMessage(){
        getDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(this.infoMessage));
    }
}
