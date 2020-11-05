package com.pages;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowhandles {
public static void main(String[] args) {
	//simple alert...javasript alert...driver.switchto()Alert.accet,dismi
	//file upload...type=file(sendkeys(abc.txt));
	//file upload...Robotclass
	//windowhandles....set<string>
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver", "chromedriver85.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://demo.guru99.com/popup.php");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//a[text()='Click Here']")).click();
    
    String currentwindow=driver.getWindowHandle();
    
    Set<String>str=driver.getWindowHandles();
    Iterator<String>itr= str.iterator();
    while(itr.hasNext()){
     String childwindow=itr.next();
    	if(!currentwindow.equalsIgnoreCase(childwindow)){
    		driver.switchTo().window(childwindow);
    		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("pratiksha@gmail.com");
    		driver.findElement(By.name("btnLogin")).click();
    		driver.close();
    		}
    	}
		
		driver.switchTo().window(currentwindow);
	}

}
