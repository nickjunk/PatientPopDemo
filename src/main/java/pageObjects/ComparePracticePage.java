package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComparePracticePage {
	
	public WebDriver driver;
	
	private By practiceName = By.xpath("//input[@name='practicename']");
	private By streetAddress = By.xpath("//input[@name='streetaddress']");
	private By city = By.xpath("//input[@name='city']");
	private By state = By.xpath("//input[@name='state']");
	private By zipCode = By.xpath("//input[@name='zipcode']");
	private By website = By.xpath("//input[@name='website']");
	private By specialty = By.xpath("//input[@name='specialty']");
	private By compareNowButton = By.id("diagnose-submit");
	
	public ComparePracticePage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPracticeName() {
		return driver.findElement(practiceName);
	}
	
	public WebElement getStreetAddress() {
		return driver.findElement(streetAddress);
	}
	
	public WebElement getCity() {
		return driver.findElement(city);
	}
	
	public WebElement getState() {
		return driver.findElement(state);
	}
	
	public WebElement getZipCode() {
		return driver.findElement(zipCode);
	}
	
	public WebElement getWebsite() {
		return driver.findElement(website);
	}
	
	public WebElement getSpecialty() {
		return driver.findElement(specialty);
	}
	
	public CompareResultsPage getCompareNowButton() {
		driver.findElement(compareNowButton).click();
		CompareResultsPage compareResultsPage = new CompareResultsPage(driver);
		return compareResultsPage;
	}
	
}
