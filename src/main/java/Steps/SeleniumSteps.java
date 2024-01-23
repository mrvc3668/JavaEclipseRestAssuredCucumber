package Steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Locators.PageLocators;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SeleniumSteps {

	private WebDriver _driver = null;
	private WebDriverWait wait = null;

	public SeleniumSteps() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");
		_driver = new ChromeDriver(option);
		wait = new WebDriverWait(_driver, Duration.ofSeconds(10));
		_driver.get("https://www.way2automation.com/angularjs-protractor/banking/#/login");
	}

	@Given("I log in as a customer")
	public void i_log_in_as_a_customer() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PageLocators.CustomerLoginButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(PageLocators.UserSelectDropdown)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(PageLocators.UserSelectOption)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(PageLocators.LoginButton)).click();

		Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(PageLocators.WelcomeMessage)).isDisplayed());
	}

	@Given("I deposit the {string} amount")
	public void i_deposit_the_amount(String string) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PageLocators.DepositButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(PageLocators.AmountInput)).sendKeys(string);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PageLocators.DepositAmountButton)).click();
	}

	@When("I validate the deposit is successful")
	public void i_validate_the_deposit_is_successful() {

		/**_driver.findElement(PageLocators.Transactionbutton).click();
		_driver.findElement(PageLocators.BackButton).click();
		_driver.findElement(PageLocators.Transactionbutton).click();**/
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(PageLocators.Transactionbutton)).click();
		String results = wait.until(ExpectedConditions.visibilityOfElementLocated(PageLocators.TableRows)).getText();
		Assert.assertTrue(results.contains("10"));
		Assert.assertTrue(results.contains("Credit"));
	}

	@Then("I log out")
	public void i_log_out() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(PageLocators.LogoutButton)).click();
	}

	@Then("I close driver")
	public void i_close_driver() {
		_driver.quit();
	}

}
