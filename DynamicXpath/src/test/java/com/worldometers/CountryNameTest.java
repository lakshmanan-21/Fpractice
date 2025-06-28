package com.worldometers;

import java.time.Duration;
import java.util.Scanner;

import org.apache.commons.math3.exception.NoDataException;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CountryNameTest 
{
	@Test
	public void ratingTest()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the country name");
		String country=s.nextLine();
		String worldshare=" ";
		
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.worldometers.info/world-population/");
	driver.manage().window().maximize();
	WebElement entries=driver.findElement(By.xpath("//li[@class='datatable-pagination-list-item']/child::button[text()='›']"));
	Actions action=new Actions(driver);
	action.scrollToElement(entries).build().perform();
	for(;;)
	{
	try
	{
	String wshare=driver.findElement(By.xpath("(//h2[text()='World Population by Country']/parent::div/descendant::a[text()='"+country+"']/parent::td/following-sibling::td[@class='px-2 border-e border-zinc-200 text-end py-1.5 border-b'])[position()=9]")).getText();
	System.out.println(wshare);
	break;
	}
	catch(Exception e)
	{
		driver.findElement(By.xpath("//li[@class='datatable-pagination-list-item']/child::button[text()='›']")).click();
		
	}
	
	
	
	}
	driver.quit();
	}

}
