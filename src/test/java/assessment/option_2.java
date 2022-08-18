package assessment;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class option_2 {
	
	WebDriver driver;
	
	
	@BeforeMethod
	void setUp()
	{
		//System.setProperty("webdriver.chrome.driver", "//Users//tmpofu//Desktop//Eclipse Test Automation//chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//ImplicitlyWait
		//PageLoadTimeOut
		//pageLogin.openBrowser();
		login("standard_user", "secret_sauce");
		
	}

	
	@Test(priority=1)
	public void buyItems()
	
	{
		addToCart();
		/*//adding items to cart
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		
		//clicking on cart
		driver.findElement(By.className("shopping_cart_link")).click();
		
		
		//validating cart items
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText(), "Sauce Labs Backpack");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).getText(), "Sauce Labs Bolt T-Shirt");
		
		//clicking checkout button
		driver.findElement(By.id("checkout")).click();*/
		
	
	}
	
	@Test(dependsOnMethods = {"buyItems"})
	public void checkout()
	{
	
		addToCart();
		verifyOrder();
		
/*//entering checkout information
	driver.findElement(By.id("first-name")).sendKeys("Nonte");
	driver.findElement(By.name("lastName")).sendKeys("Mtshingila");
	driver.findElement(By.id("postal-code")).sendKeys("0158");
	driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();*/
		
	}
	
	
	@Test (dependsOnMethods = {"checkout"})
	void checkoutOverview()
	{
		addToCart();
		verifyOrder();
		validateTotal();
		
	}
	
	@Test (priority=3)
	void orderComplete()
	{
		addToCart();
		verifyOrder();
		validateTotal();
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText(), "CHECKOUT: OVERVIEW");
	}

	
	@AfterMethod
	void tearDown()
	{
	
		driver.quit();
	}
	
	
	
	//Login into the website
	public void login(String username, String password)
	{
		//username
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(username);
				
				//password
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(password);
				
				//login button
		driver.findElement(By.cssSelector("#login-button")).click();
	}
	
	
	//adding items to cart
	public void addToCart()
	{
		//adding items to cart
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		driver.findElement(By.name("add-to-cart-sauce-labs-bolt-t-shirt")).click();
		
		//clicking on cart
		driver.findElement(By.className("shopping_cart_link")).click();
		
		
		//validating cart items
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText(), "Sauce Labs Backpack");
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).getText(), "Sauce Labs Bolt T-Shirt");
		
		//clicking checkout button
		driver.findElement(By.id("checkout")).click();
	}
	
	//checkout details
	public void verifyOrder()
	{
		//entering checkout information
		driver.findElement(By.id("first-name")).sendKeys("Nonte");
		driver.findElement(By.name("lastName")).sendKeys("Mtshingila");
		driver.findElement(By.id("postal-code")).sendKeys("0158");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
	}
	
	public void validateTotal()
	{

		String price1 = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")).getText();
		String price2 = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[4]/div[2]/div[2]/div")).getText();
		String price3 = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[5]")).getText();

		System.out.println(price1);
		System.out.println(price2);
		System.out.println(price3);
		
	}
}
