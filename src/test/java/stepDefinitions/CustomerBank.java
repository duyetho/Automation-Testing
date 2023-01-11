package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//import java.util.concurrent.TimeUnit;

public class CustomerBank {
    WebDriver driver = null;
    String projectPath = System.getProperty("user.dir");

    @Given("customer is on login page")
    public void customer_is_on_login_page() throws Throwable {
        System.out.println("hello ....");
        System.setProperty("webdriver.chrome.driver", projectPath + "/driver/chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        Thread.sleep(1000);

    }

    //Verify manage page
    @And("verify login page")
    public void verify_login_page() throws Throwable {
        //Verify url
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        //Verify title
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals(loginPageTitle, "XYZ Bank");
        Thread.sleep(1000);

    }
    @When("customer clicks on the Customer login button")
    public void customer_clicks_on_the_Customer_login_button() throws Throwable {
        driver.findElement(By.xpath("//button[contains(text(),'Customer Login')]")).click();
        Thread.sleep(1000);
    }
    @And("customer selects on <CustomerName> option")
    public void customer_Selects_On_CustomerName_Option() throws Throwable{
        Select userSelect = new Select(driver.findElement(By.id("userSelect")));
        userSelect.selectByVisibleText("Hermoine Granger");
//        userSelect.selectByIndex(2);
        Thread.sleep(1000);
    }
    @And("customer clicks on Login button")
    public void customer_clicks_on_Login_button()throws Throwable{
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button")).click();
        Thread.sleep(1000);


    }

    //----------------callback function login
    @Given("login successfully")
    public void login_successfully() throws Throwable{
        customer_is_on_login_page();
        verify_login_page();
        customer_clicks_on_the_Customer_login_button();
        customer_Selects_On_CustomerName_Option();
        customer_clicks_on_Login_button();
//        driver.close();

    }

    // ----------------user logout successfully
    @And("customer clicks on the Logout button")
    public void customer_clicks_on_the_Logout_button() throws Throwable{
        driver.findElement(By.xpath("/html/body/div/div/div[1]/button[2]")).click();
        Thread.sleep(1000);
        driver.close();
    }
    // --------------Deposit
    @And("customer clicks on the Deposit button")
    public void customer_clicks_on_the_Deposit_button()throws Throwable{
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
        Thread.sleep(1000);
    }
    @Then("^input valid data and invalid data in the \"([^\"]*)\" field$")
    public void input_valid_data_and_Invalid_data_In_The_amount_Field(String arg0)throws Throwable {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(arg0);
        Thread.sleep(1000);
    }

    @And("clicks on the Deposit button")
    public void clicks_on_the_Deposit_button() {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
        driver.close();
    }
    //----------------withdraw
    @And("customer clicks on the Withdraw button")
    public void customer_clicks_on_the_Withdraw_button() throws Throwable{
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]")).click();
        Thread.sleep(1000);
    }
    @Then("^withdraw valid data and invalid data in the \"([^\"]*)\" field$")
    public void withdraw_valid_data_and_Invalid_data_In_The_Field(String arg0)throws Throwable {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input")).sendKeys(arg0);
        Thread.sleep(1000);
    }
    @And("clicks on the Withdraw button")
    public void clicks_on_the_Withdraw_button(){
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
        driver.close();
    }
    //-----------------Transaction
    @And("customer clicks on the Transaction button")
    public void customer_clicks_on_the_Transaction_button() throws Throwable{
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]")).click();
        Thread.sleep(1000);
    }
    @Then("clicks on the DateTime the first time")
    public void clicks_on_the_DateTime_the_first_time() throws Throwable{
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/table/thead/tr/td[1]/a")).click();
        Thread.sleep(1000);
    }
    @And("clicks on the DateTime the second times")
    public void clicks_on_the_DateTime_the_second_times() throws Throwable{
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/table/thead/tr/td[1]/a")).click();
        Thread.sleep(1000);
    }
    @When("clicks on the Reset button")
    public void clicks_on_the_Reset_button() throws Throwable{
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")).click();
        Thread.sleep(1000);
    }
    @And("clicks on the Back button")
    public void clicks_on_the_Back_button() {
        driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]")).click();
        driver.close();
    }
    //------------Change account
    @When("customer clicks on the <AccountNumber> sections")
    public void customer_clicks_on_the_AccountNumber_sections() throws Throwable{
        driver.findElement(By.xpath("//*[@id=\"accountSelect\"]")).click();
        Thread.sleep(1000);
    }
    @And("choose any <AccountNumber>")
    public void choose_any_AccountNumber() {
        driver.findElement(By.xpath("//*[@id=\"accountSelect\"]/option[3]")).click();
        driver.close();
    }
    @Then("message display")
    public void message_is_display() {
        driver.quit();
        System.out.println("Successfully excution");
    }



}
