package com.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class FacebookAutomation {
	WebDriver driver;
	@BeforeSuite
	public void startup ()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver85.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/r.php");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("open browser");
	  }
	
	@Test(priority=-1)
	public void entercredential(){
		WebElement username = driver.findElement(By.name("firstname"));
        username.sendKeys("pratiksha");
		String nameValue = username.getAttribute("name");
		System.out.println("Attribute of name is>>" + nameValue);
		driver.findElement(By.name("lastname")).sendKeys("Gunjal");
		System.out.println("valid");
		
	}
	
	@Test
	public void enteremailpsw(){
		//driver.findElement(By.name("reg_email__")).sendKeys("888888");
		driver.findElement(By.name("reg_emai")).sendKeys("888888");
		driver.findElement(By.name("reg_passwd__")).sendKeys("888888");
		System.out.println("valid credential is pass");
		
	}
	@Test
	public void take_screenshot() throws Exception{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\VerveSquare\\TestNGWork\\screenshotupdate.png"));
	}
	
	
	@AfterSuite
	public void endup(){
		driver.close();
	}

}
