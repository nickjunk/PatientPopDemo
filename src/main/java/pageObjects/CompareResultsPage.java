package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompareResultsPage {
	
	public WebDriver driver;
	
	private By googleRankingLink = By.xpath("//*[text()='Google Ranking']");
	private By overallLink = By.cssSelector("li.steps-number.steps-number-5");
	private By overallScores = By.cssSelector("text.score-value");
	
	public CompareResultsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getGoogleRankingLink() {
		return driver.findElement(googleRankingLink);
	}
	
	public ArrayList<String> getOverallScores() {
		List<String> scores = new ArrayList<String>();
		List<WebElement> scoresList = driver.findElements(overallScores);
		for(WebElement s: scoresList) {
			if(!s.getText().isBlank()) {
				scores.add(s.getText());
			}
		}
		return (ArrayList<String>) scores;
	}
	
	public WebElement getOverallLink() {
		return driver.findElement(overallLink);
	}
	
}
