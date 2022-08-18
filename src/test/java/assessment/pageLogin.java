package assessment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class pageLogin {
	
	static WebDriver driver;
	
	public static void openBrowser()
	{
		//System.setProperty("webdriver.chrome.driver", "//Users//tmpofu//Desktop//Eclipse Test Automation//chromedriver");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//ImplicitlyWait
		//PageLoadTimeOut
				
	}
	

	public static void login(String username, String password)
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

}
