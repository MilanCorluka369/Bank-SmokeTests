import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerLogin extends BasePage{
    private By yourNameLocator = By.id("userSelect");
    private By loginBtn = By.xpath("//*[contains(@class, 'btn-default')]");

    private By loginMessage = By.xpath("//*[contains(text(), 'Milan Corluka')]");

    public CustomerLogin(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    /////////////////// SELECTING ////////////////////
    public void selectYourName(String yourNameOption){
        Select name = new Select(getDriver().findElement(this.yourNameLocator));
        name.selectByVisibleText(yourNameOption);
    }

    ///////////////// CLICK ////////////////
    public boolean isLoginBtnDisplayed (){
        return getDriver().findElement(this.loginBtn).isDisplayed();
    }

    public void clickLoginBtn(){
        if(isLoginBtnDisplayed())
            getDriver().findElement(this.loginBtn).click();
    }

    ///////////////// isDISPLAYED /////////////////
    public boolean isMessageDisplayed(){
        return getDriver().findElement(this.loginMessage).isDisplayed();
    }

    public boolean isYourNameDisplayed(){
        return getDriver().findElement(this.yourNameLocator).isDisplayed();
    }

    //////////////// WAITERS //////////////////
    public void waitYourNameSelect(){
        getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(this.yourNameLocator));
    }
}
