import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage extends BasePage{
    private By firstNameInput = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastNameInput = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postCodeInput = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By addCustomerBtn = By.xpath("//*[contains(@class, 'btn-default')]");

    public AddCustomerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /////////////// ENTERING CREDITENTIALS ///////////////
    public void enterFirstName(String firstName){
        getDriver().findElement(this.firstNameInput).sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        getDriver().findElement(this.lastNameInput).sendKeys(lastName);
    }

    public void enterPostCode(String postCode){
        getDriver().findElement(this.postCodeInput).sendKeys(postCode);
    }

    public void addCustomer(String firstName, String lastName, String postCode){
        clearInputField(this.firstNameInput);
        enterFirstName(firstName);
        clearInputField(this.lastNameInput);
        enterLastName(lastName);
        clearInputField(this.postCodeInput);
        enterPostCode(postCode);
    }

    //////////// CLICK /////////////
    public boolean isAddCustomerButtonEnabled() {
        return getDriver().findElement(addCustomerBtn).isEnabled();
    }

    public void clickAddCustomerBtn(){
        if(isAddCustomerButtonEnabled())
            getDriver().findElement(addCustomerBtn).click();
    }

    ////////////// MESSAGE CHECK ////////////////
    public boolean containsMessage(){
        return getDriver().switchTo().alert().getText().contains("Customer added successfully");
    }
}
