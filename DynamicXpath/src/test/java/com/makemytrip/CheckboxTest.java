package com.makemytrip;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckboxTest
{
	@Test
	public void sampleTest()
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.makemytrip.com/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
	driver.findElement(By.xpath("(//span[text()='Hotels'])[position()=1]")).click();
	driver.findElement(By.xpath("//span[text()='City, Property name or Location']")).click();
	driver.findElement(By.xpath("(//span[text()='Mumbai'])[position()=1]")).click();
	driver.findElement(By.xpath("//input[@id='checkin']")).click();
	driver.findElement(By.xpath("(//div[text()='22'])[position()='1']")).click();
	driver.findElement(By.xpath("(//div[text()='17'])[position()='2']")).click();
	
	
	driver.findElement(By.xpath("//button[text()='APPLY']")).click();
	
	driver.findElement(By.xpath("//button[text()='Search']")).click();
	List<WebElement> clinks=driver.findElements(By.xpath("//input[@type='checkbox']/parent::span/descendant::span"));
	for(WebElement l:clinks)
	{
		String li=l.getText();
		System.out.println(li);
		
	}
	
	
	
	}

}
