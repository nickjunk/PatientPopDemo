package patientPopTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.ComparePracticePage;
import pageObjects.CompareResultsPage;
import patientPop.Base;

public class ComparePracticeTest extends Base {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void initialize() {
		driver = initializeDriver();
		driver.get("https://compare-staging.patientpop.com/checkup");
	}
	
	@Test(dataProvider="getData")
	public void formEntryTest(String providerName, String address, String specialty) throws InterruptedException {
		
		ComparePracticePage comparePracticePage = new ComparePracticePage(driver);
		
		comparePracticePage.getPracticeName().sendKeys(providerName);
		Thread.sleep(1500);
		while(!comparePracticePage.getPracticeName().getAttribute("value").contains(address)) {
			comparePracticePage.getPracticeName().sendKeys(Keys.DOWN);
		}
		comparePracticePage.getPracticeName().sendKeys(Keys.ENTER);
		
		Thread.sleep(1000);
		
		//Assert fields auto populate form data
		Assert.assertTrue(comparePracticePage.getStreetAddress().getAttribute("value").length()>0);
		Assert.assertTrue(comparePracticePage.getCity().getAttribute("value").length()>0);
		Assert.assertTrue(comparePracticePage.getState().getAttribute("value").length()>0);
		Assert.assertTrue(comparePracticePage.getZipCode().getAttribute("value").length()>0);
		Assert.assertTrue(comparePracticePage.getWebsite().getAttribute("value").length()>0);
		
		comparePracticePage.getSpecialty().sendKeys(specialty);
		Thread.sleep(500);
		comparePracticePage.getSpecialty().sendKeys(Keys.DOWN);
		comparePracticePage.getSpecialty().sendKeys(Keys.ENTER);
		Thread.sleep(500);
		
		
		CompareResultsPage compareResultsPage = comparePracticePage.getCompareNowButton();
		
		Thread.sleep(1000);
		
		compareResultsPage.getGoogleRankingLink().click();
		compareResultsPage.getOverallLink().click();
		
		ArrayList<String> scores = compareResultsPage.getOverallScores();
		
		int total = 0;
		for (int i=1; i<scores.size(); i++) {
			int n = Integer.parseInt(scores.get(i));
			total+=n;
		}
		
		//Assert Overall score equals average of all others
		Assert.assertEquals(Integer.parseInt(scores.get(0)), total/(scores.size()-1));

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3];
		
		data[0][0] = "Amersi";
		data[0][1] = "Santa Monica Boulevard";
		data[0][2] = "Obstetrician and Gynecologist (OBGYN)";
		
		data[1][0] = "Prakash Neal";
		data[1][1] = "East Duarte Road";
		data[1][2] = "Neurologist";
		
		return data;
	}
	
}
