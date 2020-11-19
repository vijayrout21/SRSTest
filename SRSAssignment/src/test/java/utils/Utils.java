package utils;

import java.io.FileInputStream;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

	protected WebDriver driver;
	public String readProperties(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Resources\\Config.properties");
		prop.load(fis);
		return prop.getProperty(key);
	}
	
	public void browser(String browserName, String URL) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "BrowserDriver\\chromedriver.exe");  
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
		}
	}
	
	public void explicitWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}
