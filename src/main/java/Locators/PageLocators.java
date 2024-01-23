package Locators;

import org.openqa.selenium.By;

public class PageLocators {

	public static By CustomerLoginButton = By.xpath("//button[text()='Customer Login']");
	public static By UserSelectDropdown = By.xpath("//select[@name='userSelect']");
	public static By UserSelectOption = By.xpath("//option[text()='Ron Weasly']");
	public static By LoginButton = By.xpath("//button[text()='Login']");
	public static By WelcomeMessage = By.xpath("//strong[text()=' Welcome ']");
	public static By DepositButton = By.xpath("//button[@ng-click='deposit()']");
	public static By AmountInput = By.xpath("//input[@placeholder='amount']");
	public static By DepositAmountButton = By.xpath("//button[text()='Deposit']");
	public static By Transactionbutton = By.xpath("//button[@ng-click='transactions()']");
	public static By TableRows = By.xpath("//tr[@id='anchor0']");
	public static By LogoutButton = By.xpath("//button[text()='Logout']");
	public static By BackButton = By.xpath("//button[text()='Back']");
}
