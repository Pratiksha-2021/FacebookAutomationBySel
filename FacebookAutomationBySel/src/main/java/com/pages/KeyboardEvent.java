package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvent {
 static WebDriver driver;
 public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "chromedriver85.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	
	WebElement username=driver.findElement(By.id("email"));
	Actions action=new Actions(driver);
	
	Action seriesofAction=action.moveToElement(username).click().keyDown(username, Keys.SHIFT)
			       .sendKeys(username,"pratiksha")
	.keyUp(username,Keys.SHIFT).doubleClick(username).contextClick().build();
	seriesofAction.perform();
	
 
}
}
