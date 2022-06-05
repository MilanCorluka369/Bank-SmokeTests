import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankTests {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private BankManagerPage managerPage;
    private AddCustomerPage addCustomerPage;
    private OpenAccountPage accountPage;
    private CustomerLogin customerLogin;
    private CustomerAccount customerAccount;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "G:\\Dev & QA\\IT Bootcamp\\Materijal\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        managerPage = new BankManagerPage(driver, driverWait);
        addCustomerPage = new AddCustomerPage(driver, driverWait);
        accountPage = new OpenAccountPage(driver, driverWait);
        customerLogin = new CustomerLogin(driver, driverWait);
        customerAccount = new CustomerAccount(driver, driverWait);

        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @Test (priority = 1)
    public void testManagerPage(){
        managerPage.waitBankManagerLoginBtn();
        managerPage.clickBankManagerLogin();
        managerPage.waitAddCustomerSectionBtn();
        Assert.assertTrue(managerPage.isDisplayedAddCustomerBtn());
    }

    @Test (priority = 2)
    public void testAddCustomer() throws InterruptedException {
        managerPage.clickAddCustomerSection();
        Thread.sleep(1000);
        addCustomerPage.addCustomer("Milan", "Corluka", "023ZR");
        addCustomerPage.clickAddCustomerBtn();
        Assert.assertTrue(addCustomerPage.containsMessage());
        driver.switchTo().alert().accept();
    }

    @Test (priority = 3)
    public void testAccountPage() throws InterruptedException {
        managerPage.clickOpenAccountSection();
        Thread.sleep(1000);
        accountPage.openAccount("Milan Corluka", "Dollar");
        accountPage.clickProcessBtn();
        Assert.assertTrue(accountPage.containsMessage());
        driver.switchTo().alert().accept();
    }

    @Test (priority = 5)
    public void testCustomerLogin() throws InterruptedException {
        Thread.sleep(2000);
        customerLogin.selectYourName("Milan Corluka");
        customerLogin.clickLoginBtn();
        Assert.assertTrue(customerLogin.isMessageDisplayed());
    }

    @Test (priority = 6)
    public void testDeposit(){
        customerAccount.waitDepositBtn();
        customerAccount.clickDepositBtn();
        customerAccount.waitAmountInput();
        customerAccount.enterAmount(100);
        customerAccount.clickSubmit();
        Assert.assertEquals(customerAccount.getMessage(), "Deposit Successful");
    }

    @Test (priority = 7)
    public void testWithdrawal() {
        customerAccount.clickWithdrawlBtn();
        customerAccount.waitInfoMessage();
        customerAccount.enterAmount(100);
        customerAccount.clickSubmit();
        Assert.assertEquals(customerAccount.getMessage(), "Transaction successful");
    }

    @Test (priority = 4)
    public void logoutBankManagerTest(){
        managerPage.clickLogoutBtn();
        customerLogin.waitYourNameSelect();
        Assert.assertTrue(customerLogin.isYourNameDisplayed());
    }

    @Test (priority = 8)
    public void logutCustomerTest(){
        customerAccount.clickLogoutBtn();
        customerLogin.waitYourNameSelect();
        Assert.assertTrue(customerLogin.isYourNameDisplayed());
    }

    @AfterClass
    public void afterClass(){ driver.close(); }
}
