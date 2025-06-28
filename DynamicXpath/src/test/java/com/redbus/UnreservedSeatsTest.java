package com.redbus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class UnreservedSeatsTest 
{
	@Test
	public void ratingTest() throws Throwable
	{
	
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[text()='From']")).click();
		String from="Bangalore";
		String to="Tirupati";
		String Date="24";
		driver.findElement(By.xpath("//div[text()='"+from+"']")).click();
	    driver.findElement(By.xpath("//div[text()='"+to+"']")).click();
	    driver.findElement(By.xpath("//i[@class='icon___0039d4 icon icon-date_range']")).click();
	    driver.findElement(By.xpath("//span[text()='"+Date+"']")).click();
	    driver.findElement(By.xpath("//i[@class='icon___5d0bb4 icon icon-search']")).click();
	    driver.findElement(By.xpath("(//button[@class='primaryButton___2f7bf2 viewSeatsBtn___3f5f2a'])[position()=1]")).click();
	   driver.findElement(By.xpath("(//button[@class='actionButton___0bea1c  action___750fc3'])[position()=4]")).click();
	  
	   List<WebElement> seatsprice = driver.findElements(By.xpath("//div[@class='canvaswrapper__ind-seat-styles-module-scss-x8zip']/descendant::span[@tabindex='0']/child::span"));
	   
	   List<WebElement> sold = driver.findElements(By.xpath("//span[@class='seatSold__ind-seat-styles-module-scss-Q8oyB']"));
	   List<WebElement> price = driver.findElements(By.xpath("//span[@class='seatPrice__ind-seat-styles-module-scss-CdBu1']"));  
	   
	  String a=null;
	   String b=null;
	   String c=null;
	   for(WebElement seat:seatsprice)
	   {
		   a=seat.getText();
		   System.out.println(a);
	   }
	   for(WebElement s:sold)
	   {
		  b= s.getText();
		  System.out.println(b);
	   }
	   for(WebElement se:price)
	   {
		    c=se.getText();
		    System.out.println(c);
	   }

		ExcelUtility elib=new ExcelUtility();
		
		
		elib.setDataIntoExcel("seats", 0, 0,a);
		
	
		
	
	   
	  driver.quit();
}
	
		
		
		
	
	}

