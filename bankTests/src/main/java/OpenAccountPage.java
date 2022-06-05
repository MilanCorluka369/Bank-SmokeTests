import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenAccountPage extends BasePage{
    private By customerLocator = By.id("userSelect");
    private By currencyLocator = By.id("currency");
    private By processBtn = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    public OpenAccountPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    ////////////// SELECTING /////////////////
    public void selectCustomer(String customerOption){
        Select customer = new Select(getDriver().findElement(this.customerLocator));
        customer.selectByVisibleText(customerOption);
    }

    public void selectCurrency(String currencyOption){
        Select currency = new Select(getDriver().findElement(this.currencyLocator));
        currency.selectByVisibleText(currencyOption);
    }

    public void openAccount(String customerOption, String currencyOption){
        selectCustomer(customerOption);
        selectCurrency(currencyOption);
    }

    //////////////// CLICK /////////////////
    public void clickProcessBtn(){
        getDriver().findElement(this.processBtn).click();
    }

    /////////////// MESSAGE CHECK ///////////////
    public boolean containsMessage(){
        return getDriver().switchTo().alert().getText().contains("Account created successfully");
    }
}
