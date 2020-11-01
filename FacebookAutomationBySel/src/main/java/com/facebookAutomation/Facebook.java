package com.facebookAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Facebook {

	WebDriver driver;

	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver85.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/r.php");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("open browser");

	}

	@Test(priority = -1)
	public void registration() {
		WebElement username = driver.findElement(By.name("firstname"));
        username.sendKeys("pratiksha");
		String nameValue = username.getAttribute("name");
		System.out.println("Attribute of name is>>" + nameValue);
		driver.findElement(By.name("lastname")).sendKeys("Gunjal");
		// driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("gunjal");

		driver.findElement(By.name("reg_email__")).sendKeys("888888");
		driver.findElement(By.name("reg_passwd__")).sendKeys("888888");
		System.out.println("valid credential is pass");

	}

	@Test
	public void enterDate() {
		WebElement element = driver.findElement(By.id("day"));
		Select sel = new Select(element);
		// sel.selectByIndex(7);

		// sel.selectByValue("10");
		sel.selectByVisibleText("5");

		System.out.println("day is enter");
	}

	@Test(priority = 1)
	public void entermonth() {

		// month data

		WebElement monthlocator = driver.findElement(By.id("month"));
		Select sel2 = new Select(monthlocator);

		List<WebElement> alloption = sel2.getOptions();
		int size = alloption.size();
		System.out.println("total size is" + size);
		for (int i = 1; i < size; i++) {
			String alldata = alloption.get(i).getText();
			System.out.println("All dropdown text is" + alldata);
			alloption.get(2).click();
		}
		System.out.println(" valid month enter");
	}

	@Test(priority = 2)
	public void enterYear() {
		List<WebElement> allyeardata = driver.findElements(By.xpath("//option[contains(@value,'199')]"));
		int allyearsize = allyeardata.size();
		System.out.println("size of year>>>" + allyearsize);
		for (int i = 1; i < allyearsize; i++) {
			String allyeardatavalue = allyeardata.get(i).getText();
			System.out.println("All dropdown text is" + allyeardatavalue);
			allyeardata.get(2).click();
		}
		System.out.println("valid year enter");
	}

	@Test(priority = 3)
	public void selectRadiobtn() {

		WebElement radiobtn = driver.findElement(By.name("sex"));
		radiobtn.click();
		driver.findElement(By.name("websubmit")).click();
		System.out.println("radio btn select");
	}

	@AfterSuite
	public void endUp() {
		driver.close();
		System.out.println("valid registration");

	}
	
	
	 /*  WebDriverWait wait = new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(username));
	
	 WebDriverWait wait=new WebDriverWait(driver,20);
	  wait.until(ExpectedConditions.visibilityOf(username));*/

}
