package patientPop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	public static WebDriver driver;
	
	public static WebDriver initializeDriver() {
		
		String driverPath = System.getProperty("user.dir")+"/src/geckodriver";
		
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
}


