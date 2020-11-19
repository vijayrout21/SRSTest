package testCases;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageActions.HomePage;
import utils.Utils;
public class UITestCase extends Utils{
	
	//Control+Shift+O: for fixing imports

	@BeforeTest
	public void beforeTest() throws IOException{
		browser(readProperties("browser"),readProperties("url"));
	}
	
	@Test
	public void test () throws InterruptedException {
		HomePage hp = new HomePage(driver);
		//Thread.sleep(5000);
		hp.hoverOverShopByCategory();
		hp.clickBeverages();
		//Thread.sleep(5000);
		hp.clickTea();
		//Thread.sleep(5000);
		hp.clickGreenTea();
		//Thread.sleep(5000);
		hp.enterSearchByBrand("Tea");
		//Thread.sleep(5000);
		hp.selectGreenTeaOptions();
		//Thread.sleep(5000);
		hp.getNumberOfProductsAfterSearch();
		hp.getPriceOfFirstProduct();
		hp.enterQuantityAndAddToCart("2");
		//Not working
		//hp.verifyBanner();
		hp.goToCartAndVerifySubTotal();
		
	}
}
