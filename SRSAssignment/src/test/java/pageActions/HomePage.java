package pageActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import utils.Utils;

public class HomePage extends pageObjects.HomePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	

	public void hoverOverShopByCategory() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(getShopByCategory()));
		
		Actions action = new Actions(driver);

		action.moveToElement(getShopByCategory()).perform();
	}

	public void clickBeverages() {

		getBeverages().click();
	}
	
	public void clickTea() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(getTea()));
		getTea().click();
	}
	
	public void clickGreenTea() {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(getGreenTea()));
		getGreenTea().click();
	}
	
	public void enterSearchByBrand(String brand) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(getSearchByBrand()));
		getSearchByBrand().sendKeys(brand);
	}
	
	public void selectGreenTeaOptions() throws InterruptedException{
		Thread.sleep(3000);
		int options = getGreaanTesOptions().size();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", getGreaanTesOptions().get(0));
		Thread.sleep(5000);
		executor.executeScript("arguments[0].click();", getGreaanTesOptions().get(options-1));
		
		}
	
	public void getNumberOfProductsAfterSearch () throws InterruptedException{
		Thread.sleep(4000);
		int i = getProducts().size();
		System.out.println("Number of products after search is:"+i);
		Assert.assertEquals(8, i);
	}
	
	public void getPriceOfFirstProduct() {
		System.out.println("Price of the first product is:"+getProducts().get(0).getText());
		Assert.assertEquals("249", getProducts().get(0).getText());
	}
	
	public void enterQuantityAndAddToCart(String quantity) {
		getQuantityTextBox().get(0).clear();
		getQuantityTextBox().get(0).sendKeys(quantity);
		getAddToCartBtn().get(0).click();
	}
	
	public void verifyBanner() {
		//getQuantityTextBox().get(0).click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", getQuantityTextBox().get(0));
		getAddToCartBtn().get(0).sendKeys(Keys.F8);
		System.out.println(getBanner().getText());
		
	}
	
	public void goToCartAndVerifySubTotal() throws InterruptedException{
		driver.navigate().refresh();
		getMyCart().click();
		Thread.sleep(3000);
		System.out.println("Sub Total is:"+getSubTotal().getText());
		Assert.assertEquals("498.00", getSubTotal().getText());
	}
}
