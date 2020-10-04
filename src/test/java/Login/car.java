package Login;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class car {

	WebDriver driver;

	@Test
	@BeforeTest
	public void testSetup()
	{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();

	}

	@Test
	public void openBrowser()
	{
	driver.get("https://www.browserstack.com/");
	driver.findElement(By.id("signupModalButton")).click();
	System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
	}

	@Test(description="This method validates the sign up functionality")
	public void signUp()
	{
	driver.findElement(By.id("user_full_name")).sendKeys("Sadhvi Singh");
	driver.findElement(By.id("user_email_login")).sendKeys("sadhvisingh9049+1@gmail.com");
	driver.findElement(By.id("user_password")).sendKeys("BrowserStack123*");
	driver.findElement(By.xpath("//input[@name='terms_and_conditions']")).click();
	driver.findElement(By.id("user_submit")).click();

	}

	@Test
	public void postSignUp()
	{
	System.out.println(driver.getCurrentUrl());

	}

	@AfterTest
	public void afterClass()
	{
	driver.quit();
	}
	
}
