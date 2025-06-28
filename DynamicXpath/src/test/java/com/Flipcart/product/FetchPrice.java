package com.Flipcart.product;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FetchPrice 
{
	@Test
	public void productTest()
	{
		String pname="Swiss Made Quartz White Dial Analog Watch  - For Men HB...";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("watches");
		driver.findElement(By.xpath("//button[@class='_2iLD__']//*[name()='svg']")).click();
	WebElement checkbox=driver.findElement(By.xpath("(//div[@class='XqNaEv'])[position()=6]"));
	Actions action=new Actions(driver);
		action.moveToElement(checkbox).click().build().perform();
	WebElement next=driver.findElement(By.xpath("//span[text()='Next']"));
		
		action.moveToElement(next).build().perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(next));
		
		
		for(;;)
		{
			try {
			try
			{
				String price=driver.findElement(By.xpath("(//a[text()='"+pname+"']/ancestor::div[@class='hCKiGj']/descendant::div)[position()=4]")).getText();
				System.out.println(price);
				break;
			}
			catch(Exception e)
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			}
			catch(Exception en)
			{
				System.out.println("Element not found");
				break;
			}
			
				
		}
		
		
	driver.quit();
	}

}
