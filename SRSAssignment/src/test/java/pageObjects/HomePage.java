package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	protected WebDriver driver;
	public HomePage(WebDriver driver) 
	{           
	   this.driver = driver; 
	   PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Shop by Category')]")
	private WebElement shopByCategory;
	
	public WebElement getShopByCategory() {
		return shopByCategory;
	}
	
	@FindBy(xpath="//a[@ng-href='/cl/beverages/?nc=nb' and @qa='catL1']")
	private WebElement beverages;
	
	public WebElement getBeverages() {
		return beverages;
	}
	
	@FindBy(xpath="//div[@ng-if=\"filter.filter_name === 'Category' && vm.sectionModel.alloffersubtype != 'offer-by-category'\"]//span[@class='ng-binding'][normalize-space()='Tea']")
	private WebElement tea;
	
	public WebElement getTea() {
		return tea;
	}
	
	@FindBy(xpath="//div[@ng-if=\"filter.filter_name === 'Category' && vm.sectionModel.alloffersubtype != 'offer-by-category'\"]//span[@class='ng-binding'][normalize-space()='Green Tea']")
	private WebElement greenTea;
	
	public WebElement getGreenTea() {
		return greenTea;
	}
	
	@FindBy(xpath="//div[4]/div[2]/div/input[@placeholder='Search by Brand']")
	private WebElement searchByBrand;
	
	public WebElement getSearchByBrand() {
		return searchByBrand;
	}
	
	@FindBy(xpath="//div[4]/div[2]/section/div[@ng-repeat='brand in filter.values | filter:vm.brandSearch']/label/input[@type='checkbox']")
	private List<WebElement> greenTeaOptions;
	
	public List<WebElement> getGreaanTesOptions(){
		return greenTeaOptions;
	}
	
	@FindBy(xpath="//div[@qa='product']//span[@class='discnt-price']/span[@class='ng-binding']")
	private List<WebElement> products;
	
	public List<WebElement> getProducts(){
		return products;
	}
	
	@FindBy(xpath="//input[@ng-model='vm.startQuantity']")
	private List<WebElement> quantity;
	
	public List<WebElement> getQuantityTextBox(){
		return quantity;
	}
	
	@FindBy(xpath="//button[@ng-click='vm.addToBasket(vm.selectedProduct);']")
	private List<WebElement> addToCartBtn;
	
	public List<WebElement> getAddToCartBtn(){
		return addToCartBtn;
	}
	
	@FindBy(xpath="//div[@class='toast-title']")
	private WebElement banner;
	
	public WebElement getBanner() {
		return banner;
	}
	
	@FindBy(xpath="//span[@class='basket-content']")
	private WebElement myCart;
	
	public WebElement getMyCart() {
		return myCart;
	}
	
	@FindBy(xpath="//button[@ng-click='vm.goToBasketPage(vm.cart.cart_no_items);']")
	private WebElement goToMyCartPage;
	
	public WebElement getGoToMyCartPage() {
		return goToMyCartPage;
	}
	
	@FindBy(xpath="//span[@qa='subTotalMB']")
	private WebElement subTotal;
	
	public WebElement getSubTotal() {
		return subTotal;
	}
	
}
